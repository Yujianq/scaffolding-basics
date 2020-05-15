package com.yujianq.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author Yujianq
 * @description 返回状态枚举
 * @date 2020-05-14 11:18
 */
@Getter
@AllArgsConstructor
public enum ResultEnum {
	
	SUCCESS(200, "操作成功"),
	
	N0_HANDLER_FOUND(404, "路径不存在"),
	
	ERROR(500, "系统错误"),
	
	FAILD(600, "操作失败"),
	PARAMS_VALIDATE_FAILED(601, "参数校验失败"),
	DUPLICATE_KEY(602, "数据重复"),
	METHOD_NOT_SUPPORTED(603, "请求方法不被支持");

	/**
	 * 状态码
	 */
	private int code;
	
	/**
	 * 回执消息
	 */
	private String msg;
	
}
