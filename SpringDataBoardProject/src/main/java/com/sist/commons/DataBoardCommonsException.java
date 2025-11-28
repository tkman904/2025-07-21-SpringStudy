package com.sist.commons;
// 모든 Controller에 대한 예외처리 = 공통기반 (공통 예외처리)

import org.springframework.web.bind.annotation.ExceptionHandler;

public class DataBoardCommonsException {
	@ExceptionHandler(RuntimeException.class)
	public void runtimeException(RuntimeException ex) {
		System.out.println("====== 오류발생 ======");
		ex.printStackTrace();
	}
	
	@ExceptionHandler(Exception.class)
	public void exception(Exception ex) {
		System.out.println("====== 오류발생 ======");
		ex.printStackTrace();
	}
}
