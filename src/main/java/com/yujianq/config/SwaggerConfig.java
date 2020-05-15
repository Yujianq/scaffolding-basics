package com.yujianq.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Yujianq
 * @description Swagger API 文档配置中心，文档地址：https://doc.xiaominfo.com/knife4j/
 * @date 2020-05-14 11:18
 */
@Configuration
@EnableSwagger2
@EnableKnife4j
public class SwaggerConfig {

	@Bean
	public Docket defaultApi2() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				// 分组名称
				.groupName("1.0 版本")
				.select()
				// 这里指定Controller扫描包路径
//				.apis(RequestHandlerSelectors.basePackage("com.yujianq.controller"))
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
				.paths(PathSelectors.any())
				.build();
		return docket;
	}

	/**
	 * 详细信息
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("API 接口文档")
				.description("详细接口文档")
				.termsOfServiceUrl("www.yujianq.cn")
				.contact(new Contact("Yujianq", "", "angeyujianq@foxmail.com"))
				.version("1.0").build();
	}

}
