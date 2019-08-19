package com.rubypaper.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //��Ʈ�ѷ����� �߻��ϴ� ��� ���ܸ� �� ��ü���� ó���ϵ��� ����
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BoardException.class) //BoardException ����ó��
	public String handleCustomException(BoardException exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errors/boardError";
	}
	
	@ExceptionHandler(Exception.class) //������ ��� ����ó��
	public String handleException(Exception exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errors/globalError";
	}
}
