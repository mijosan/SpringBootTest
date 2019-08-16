package com.rubypaper.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rubypaper.domain.Board;
import com.rubypaper.service.BoardService;

@Controller
public class BoardController {
	
	//@Autowired
	//private BoardService boardService;
	
	@RequestMapping("/getBoardList")
	public String getBoardList(Model model) {
		List<Board> boardList = new ArrayList<Board>();
		for(int i = 1; i<= 10; i++) {
			Board board = new Board();
			board.setSeq(new Long(i));
			board.setTitle("�Խ��� ���α׷� �׽�Ʈ");
			board.setWriter("�����");
			board.setContent("�Խ��� ���α׷� �׽�Ʈ�Դϴ�...");
			board.setCreateDate(new Date());
			board.setCnt(0L);
			boardList.add(board);
		}
		model.addAttribute("boardList", boardList);
		return "getBoardList";
		
		/*
		 * List<Board> boardList = boardService.getBoardList(board);
		 * model.addAttribute("boardList", boardList); return "getBoardList";
		 */
	}
}
