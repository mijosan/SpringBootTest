package com.rubypaper.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //컨트롤러에서 발생하는 모든 예외를 이 객체에서 처리하도록 설정
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BoardException.class) //BoardException 예외처리
	public String handleCustomException(BoardException exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errors/boardError";
	}
	
	@ExceptionHandler(Exception.class) //나머지 모든 예외처리
	public String handleException(Exception exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errors/globalError";
	}
}
