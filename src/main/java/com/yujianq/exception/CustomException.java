package com.yujianq.exception;

import lombok.Getter;

/**
 * @author Yujianq
 * @description 自定义异常类
 * @date 2020-05-14 11:18
 */
@Getter
public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * 状态码
	 */
	private int code;
	
	/**
	 * 回执消息
	 */
	private String msg;

	public CustomException(Integer code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

	public CustomException(String msg) {
        super(msg);
        this.msg = msg;
    }

	public CustomException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

	public CustomException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

	public CustomException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }

}