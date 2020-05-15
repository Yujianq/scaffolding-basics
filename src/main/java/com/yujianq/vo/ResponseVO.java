package com.yujianq.vo;

import com.yujianq.enums.ResultEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Yujianq
 * @description 页面展示数据对象：返回状态信息
 * @date 2020-05-14 11:18
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseVO<T> {

	/**
	 * 返回状态码
	 */
	private int code;
	
	/**
	 * 返回状态对应信息
	 */
	private String msg;
	
	/**
	 * 响应数据
	 */
	private T data;
	
    public ResponseVO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    
    public ResponseVO(ResultEnum result) {
    	this.code = result.getCode();
    	this.msg = result.getMsg();
    }

    public ResponseVO(ResultEnum result, T data) {
    	this.code = result.getCode();
    	this.msg = result.getMsg();
    	this.data = data;
    }

    /**
     * 操作失败
     * @return
     */
    public static ResponseVO<String> faild() {
        return new ResponseVO<>(ResultEnum.FAILD);
    }
    
    /**
     * 系统错误
     * @return
     */
    public static ResponseVO<String> error() {
    	return new ResponseVO<>(ResultEnum.ERROR);
    }
    
    /**
     * 参数验证失败
     * @return
     */
    public static ResponseVO<String> paramsFaild() {
    	return new ResponseVO<>(ResultEnum.PARAMS_VALIDATE_FAILED);
    }
    
    /**
     * 操作成功
     * @return
     */
    public static ResponseVO<String> success() {
        return new ResponseVO<>(ResultEnum.SUCCESS);
    }

    /**
     * 操作成功并返回响应数据
     * @param data
     * @return
     */
    public ResponseVO<T> success(T data) {
        return new ResponseVO<>(ResultEnum.SUCCESS, data);
    }
	
}
