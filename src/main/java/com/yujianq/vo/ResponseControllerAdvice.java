package com.yujianq.vo;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yujianq.exception.CustomException;

/**
 * @author Yujianq
 * @description 全局响应数据处理
 * @date 2020-05-14 11:18
 */
@RestControllerAdvice(basePackages = { "com.yujianq.controller" })
public class ResponseControllerAdvice implements ResponseBodyAdvice<Object>{

	@Override
	public Object beforeBodyWrite(Object data, MethodParameter returnType, MediaType mediaType,
			Class<? extends HttpMessageConverter<?>> cls, ServerHttpRequest request, ServerHttpResponse response) {
		// String 类型不能直接包装，所以要进行些特别的处理
		if (returnType.getGenericParameterType().equals(String.class)) {
			ObjectMapper objectMapper = new ObjectMapper();
			try {
				return objectMapper.writeValueAsString(new ResponseVO<>().success(data));
			} catch (JsonProcessingException e) {
				throw new CustomException("返回 String 类型错误：" + e.getMessage());
			}
		}
		return new ResponseVO<>().success(data);
	}

	@Override
	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> cls) {
		// 如果接口返回的类型本身就是 ResponseVO 那就没有必要进行额外的操作，返回 false
		return !returnType.getGenericParameterType().equals(ResponseVO.class);
	}

}
