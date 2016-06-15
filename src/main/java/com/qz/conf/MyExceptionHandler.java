//package com.qz.conf;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.HandlerExceptionResolver;
//import org.springframework.web.servlet.ModelAndView;
//
//@Component//接收Controller层throw的异常
//public class MyExceptionHandler implements HandlerExceptionResolver {
//
//	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
//			Exception ex) {
//		ModelAndView modelAndView = new ModelAndView("/");// exception后跳转页面
//		Map<String, Object> model = new HashMap<String, Object>();
//		model.put("ex", ex);
//		// 根据不同错误转向不同页面
//		ex.getMessage();
//		System.out.println("自定义异常处理" + ex);
//		return modelAndView;
//	}
// }
