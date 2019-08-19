package com.rubypaper.controller;

import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.exception.BoardNotFoundException;

@Controller
public class ExceptionController {
	
	@RequestMapping("boardError")
	public String boardError() {
		throw new BoardNotFoundException("�˻��� �Խñ��� �����ϴ�.");
	}
	
	@RequestMapping("illegalArgumentError")
	public String ellegalArgumentError() {
		throw new IllegalArgumentException("�������� ���ڰ� ���޵Ǿ����ϴ�.");
	}
	
	@RequestMapping("sqlError")
	public String sqlError() throws SQLException{
		throw new SQLException("SQL ������ ������ �ֽ��ϴ�.");
	}
	
	@ExceptionHandler(SQLException.class) //���� �������� �ۼ������� ��Ʈ�ѷ����� ������ ����ó�� ������ �����ϰ� ������ ���
	public String numberFormatError(SQLException exception, Model model) {
		model.addAttribute("exception", exception);
		return "/errors/sqlError";
	}
}
