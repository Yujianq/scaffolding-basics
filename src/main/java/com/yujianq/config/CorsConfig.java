package com.yujianq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Yujianq
 * @description 接口请求跨域配置中心
 * @date 2020-05-14 11:18
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
			.allowedOrigins("*")
			.allowCredentials(true)
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
			.maxAge(3600);
	}
	
}
