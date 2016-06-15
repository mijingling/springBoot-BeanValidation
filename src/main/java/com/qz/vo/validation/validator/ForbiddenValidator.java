package com.qz.vo.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.qz.vo.validation.annotation.Forbidden;

/**
 * 校验器-禁止字符
 */
public class ForbiddenValidator implements ConstraintValidator<Forbidden, String> {

	private String[] forbiddenWords = { "admin" };

	@Override
	public void initialize(Forbidden constraintAnnotation) {
		// 初始化，得到注解数据
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (StringUtils.isEmpty(value)) {
			return true;
		}

		for (String word : forbiddenWords) {
			if (value.contains(word)) {
				return false;// 验证失败
			}
		}
		return true;
	}
}
