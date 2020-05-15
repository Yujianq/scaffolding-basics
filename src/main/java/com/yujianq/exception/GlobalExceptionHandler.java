package com.yujianq.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.yaml.snakeyaml.constructor.DuplicateKeyException;

import com.yujianq.enums.ResultEnum;
import com.yujianq.vo.ResponseVO;

/**
 * @author Yujianq
 * @description 全局异常捕获
 * @date 2020-05-14 11:18
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 处理自定义异常
	 * @param e
	 * @return
	 */
    @ExceptionHandler(CustomException.class)
    public ResponseVO<String> handleRRException(CustomException e) {
        logger.error(e.getMessage(), e);
        return new ResponseVO<>(e.getCode(), e.getMessage());
    }
	
    /**
     * 方法参数校验
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseVO<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new ResponseVO<>(ResultEnum.PARAMS_VALIDATE_FAILED, objectError.getDefaultMessage());
    }
    
    /**
     * 参数异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(BindException.class)
    public ResponseVO<String> handleBindException(BindException e) {
    	 // 从异常对象中拿到ObjectError对象
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        // 然后提取错误提示信息进行返回
        return new ResponseVO<>(ResultEnum.PARAMS_VALIDATE_FAILED, objectError.getDefaultMessage());
    }
    
    /**
     * 系统异常信息
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseVO<String> handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return new ResponseVO<>(500, "系统繁忙，请稍后再试");
    }
    
    /**
     * 重复数据提交
     * @param e
     * @return
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseVO<String> handleDuplicateKeyException(DuplicateKeyException e) {
        logger.error(e.getMessage(), e);
        return new ResponseVO<>(ResultEnum.DUPLICATE_KEY, "数据重复，请检查后提交");
    }
    
    /**
     * 未找到该路径
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseVO<String> handlerNoFoundException(Exception e) {
        logger.error(e.getMessage(), e);
        return new ResponseVO<>(ResultEnum.N0_HANDLER_FOUND, "路径不存在，请检查路径是否正确");
    }

    /**
     * 请求方法不被支持
     * @param e
     * @return
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseVO<String> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        logger.error(e.getMessage(), e);
        return new ResponseVO<>(ResultEnum.METHOD_NOT_SUPPORTED, "不支持'" + e.getMethod() + "'请求方法");
    }
    
}
