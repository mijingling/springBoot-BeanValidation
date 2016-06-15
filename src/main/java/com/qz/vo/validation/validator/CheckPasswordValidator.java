package com.qz.vo.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

import com.qz.vo.UserVo;
import com.qz.vo.validation.annotation.CheckPassword;

public class CheckPasswordValidator implements ConstraintValidator<CheckPassword, UserVo> {

	@Override
	public void initialize(CheckPassword constraintAnnotation) {
	}

	@Override
	public boolean isValid(UserVo user, ConstraintValidatorContext context) {
		if (user == null) {
			return true;
		}

		// 没有填密码
		if (!StringUtils.hasText(user.getPasswd())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("{password.null}").addPropertyNode("password")
					.addConstraintViolation();
			return false;
		}

		if (!StringUtils.hasText(user.getConfirmation())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("{password.confirmation.null}")
					.addPropertyNode("confirmation").addConstraintViolation();
			return false;
		}

		// 两次密码不一样
		if (!user.getPasswd().trim().equals(user.getConfirmation().trim())) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("{password.confirmation.error}")
					.addPropertyNode("confirmation").addConstraintViolation();
			return false;
		}
		return true;
	}
}
