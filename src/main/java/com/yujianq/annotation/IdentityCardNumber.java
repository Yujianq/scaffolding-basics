package com.yujianq.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.yujianq.annotation.impl.IdentityCardNumberImpl;

/**
 * @author Yujianq
 * @description 自定义参数验证注解类
 * @date 2020-05-14 14:02
 */
@Documented
@Target({ElementType.PARAMETER, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = IdentityCardNumberImpl.class)
public @interface IdentityCardNumber {
	
	String message() default "身份证号码不合法";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};

}