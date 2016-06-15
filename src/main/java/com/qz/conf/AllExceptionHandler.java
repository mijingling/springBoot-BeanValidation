package com.qz.conf;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class AllExceptionHandler {
	//
	// @ExceptionHandler(NumberFormatException.class)
	// @ResponseStatus(value = HttpStatus.BAD_REQUEST)
	// @ResponseBody
	// public String handleInvalidException(NumberFormatException ex) {
	// System.out.println(ex.getMessage());
	// return ex.getMessage();
	// }

	@ExceptionHandler(TypeMismatchException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public String handleInvalidException(TypeMismatchException ex) {
		System.out.println(ex.getErrorCode());
		return "Request id must be an integer";
	}

	//
	// @ExceptionHandler(NullPointerException.class)
	// @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	// @ResponseBody
	// public String handleControllerException(NullPointerException ex) {
	// System.out.println("nullException" + ex);
	// return ex.getMessage();
	// }

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public String handleUnexpectedServerError(RuntimeException ex) {
		System.out.println("exception" + ex);
		return ex.getMessage();
	}
}
