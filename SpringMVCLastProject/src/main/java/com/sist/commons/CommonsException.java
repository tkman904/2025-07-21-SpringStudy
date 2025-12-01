package com.sist.commons;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonsException {
	@ExceptionHandler(Exception.class)
	public void exception(Exception e) {
		System.out.println("====== 예외 처리 발생(Excepton) ======");
		e.printStackTrace();
	}
	
	@ExceptionHandler(Throwable.class)
	public void throwable(Throwable e) {
		System.out.println("====== 예외 처리 발생(Throwable) ======");
		e.printStackTrace();
	}
}
