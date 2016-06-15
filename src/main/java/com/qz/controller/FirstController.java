package com.qz.controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qz.vo.UserVo;
import com.qz.vo.validation.groups.Add;
import com.qz.vo.validation.groups.Edit;

@RestController
public class FirstController {

	@RequestMapping(value = "/")
	public String home(@Valid UserVo userVo, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			System.out.println(result.getFieldError().getDefaultMessage());// 返回message
		} else {
			System.out.println("param ok");
		}
		return "hello spring boot";
	}

	@RequestMapping(value = "/edit")
	public String testGroupValidation(@Validated({ Edit.class }) UserVo userVo, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			String field = result.getFieldError().getField();
			String msgCode = result.getFieldError().getDefaultMessage();// 返回编码
			return "error:" + field + "-" + msgCode;
		}
		return "param check ok";
	}

	@RequestMapping(value = "/add")
	public String testGroupValidation2(@Validated({ Add.class }) UserVo userVo, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			String field = result.getFieldError().getField();
			String msgCode = result.getFieldError().getDefaultMessage();// 返回编码
			return "error:" + field + "-" + msgCode;
		}
		return "param check ok";
	}

	@RequestMapping(value = "/editPasswd")
	public String testGroupValidation3(@Valid UserVo userVo, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			String field = result.getFieldError().getField();
			String msgCode = result.getFieldError().getDefaultMessage();// 返回编码
			return "error:" + field + "-" + msgCode;
		}
		return "param check ok";
	}

	@RequestMapping(value = "/del/{id}")
	public String testGroupValidation4(@PathVariable Integer id) throws Exception {
		System.out.println("id:" + id);
		return "param check ok";
	}

	public static void main(String[] args) {
		// 查找以Java开头,任意结尾的字符串
		Pattern pattern = Pattern.compile("((http|https)://)([a-zA-Z0-9_-]+.)*");
		Matcher matcher = pattern.matcher("http://baidu.com:8081");
		boolean b = matcher.matches();
		// 当条件满足时，将返回true，否则返回false
		System.out.println(b);
	}
}
