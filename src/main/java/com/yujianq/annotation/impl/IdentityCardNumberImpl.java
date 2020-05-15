package com.yujianq.annotation.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.yujianq.annotation.IdentityCardNumber;

import cn.hutool.core.util.IdcardUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;

/**
 * @author Yujianq
 * @description 自定义参数验证注解类的实现
 * @date 2020-05-14 14:02
 */
public class IdentityCardNumberImpl implements ConstraintValidator<IdentityCardNumber, Object> {

	@Override
	public void initialize(IdentityCardNumber constraintAnnotation) {
	}
	
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		if (ObjectUtil.isNull(value) || StrUtil.isEmpty(value.toString())) {
			return true;
		}
		return IdcardUtil.isValidCard(value.toString());
	}

}
