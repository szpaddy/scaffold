package com.scaffold.core.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

/**
 * 全局异常处理类
 */
public class GlobalExceptionHandler extends SimpleMappingExceptionResolver {
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		ModelAndView mv = null;
		String accept = request.getHeader("accept");
		String requestedWith = request.getHeader("X-Requested-With");
		if (StringUtils.contains(accept, "application/json") || StringUtils.contains(requestedWith, "XMLHttpRequest")) {
			// json 请求返回
			try {
				PrintWriter writer = response.getWriter();
				writer.write(ex.getMessage());
				writer.flush();
			} catch (IOException e) {
				logger.info(ExceptionUtils.getStackTrace(e));
			}
		} else {
			mv = super.doResolveException(request, response, handler, ex);
		}
		return mv;
	}
}
