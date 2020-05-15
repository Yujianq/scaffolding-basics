package com.yujianq.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Yujianq
 * @description XSS 过滤器
 * @date 2020-05-14 11:18
 */
public class XssFilter implements Filter {
	
	@Override
	public void init(FilterConfig config) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		XssHttpServletRequestWrapper xssRequest = new XssHttpServletRequestWrapper(req);
		chain.doFilter(xssRequest, response);
	}

	@Override
	public void destroy() {
	}
	
}