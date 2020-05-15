package com.yujianq.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yujianq.filter.XssFilter;

import javax.servlet.DispatcherType;

/**
 * @author Yujianq
 * @description 请求过滤配置中心
 * @date 2020-05-14 11:18
 */
@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<XssFilter> xssFilterRegistration() {
		FilterRegistrationBean<XssFilter> registration = new FilterRegistrationBean<>();
		registration.setDispatcherTypes(DispatcherType.REQUEST);
		registration.setFilter(new XssFilter());
		registration.addUrlPatterns("/*");
		registration.setName("xssFilter");
		registration.setOrder(Integer.MAX_VALUE);
		return registration;
	}

}