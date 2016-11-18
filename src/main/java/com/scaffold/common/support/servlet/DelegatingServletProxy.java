package com.scaffold.common.support.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@SuppressWarnings("serial")
public class DelegatingServletProxy extends GenericServlet {
	private Servlet proxy;

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		proxy.service(req, res);
	}

	@Override
	public void init() throws ServletException {
		initProxy();
		proxy.init(getServletConfig());
	}

	private void initProxy() {
		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		this.proxy = (Servlet) wac.getBean(getServletName());
	}
}