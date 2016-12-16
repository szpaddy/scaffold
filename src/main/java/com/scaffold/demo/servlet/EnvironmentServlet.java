package com.scaffold.demo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.scaffold.common.utils.JsonUtil;
import com.scaffold.demo.service.IDemoService;
import com.scaffold.demo.vo.Environment;
import com.scaffold.demo.vo.Permission;
import com.scaffold.demo.vo.User;

@SuppressWarnings("serial")
@Component
public class EnvironmentServlet extends HttpServlet {
	private static final Logger logger = LoggerFactory.getLogger(EnvironmentServlet.class);

	@Resource
	private IDemoService demoService;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Environment env = getEnvironmentInfo();
		String envJsonStr = "{}";
		try {
			envJsonStr = JsonUtil.getJsonString(env);
		} catch (Exception e) {
			logger.error("error when get envJsonStr", e);
		}

		// 拼接需要传给前段的json对象字符串
		StringBuffer sb = new StringBuffer();
		sb.append("var environment = ").append(envJsonStr).append(";");

		resp.getWriter().write(sb.toString());
	}

	/**
	 * 组合需要返回到前台的对象信息
	 * 
	 * @return
	 */
	private Environment getEnvironmentInfo() {
		Environment env = new Environment();

		User user = demoService.getUserByUid("1");
		env.setUser(user);

		List<Permission> permissionList = new ArrayList<Permission>();
		permissionList.add(new Permission("view"));
		env.setPermissionList(permissionList);

		return env;
	}

}
