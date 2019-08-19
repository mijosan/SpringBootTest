package com.rubypaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.rubypaper.domain.Board;
import com.rubypaper.domain.Member;
import com.rubypaper.service.BoardService;

@SessionAttributes("member") // member라는 이름으로 Model에 저장한 데이터는 자동으로 세션에 등록된다.
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@ModelAttribute("member") //@ModelAttribute를 이용했기때문에 @RequestMapping보다 먼저 사용된다.
	public Member setMember() {
		return new Member(); //Model객체를 member라는 이름으로 Model에 저장
	}
	
	@RequestMapping("/getBoardList")
	public String getBoardList(@ModelAttribute("member")Member member, Model model, Board board) {//어노테이션을 이용해서 세션에 등록된 "member"라는 이름의 객체를 바인딩
		
		if(member.getId() == null) {
			return "redirect:login";
		}
		List<Board> boardList = boardService.getBoardList(board);
	
		model.addAttribute("boardList", boardList);
		return "getBoardList";
		
	}
	
	@GetMapping("/getBoard")
	public String getBoard(@ModelAttribute("member")Member member, Model model, Board board) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		model.addAttribute("board", boardService.getBoard(board));
		return "getBoard";
	}
	
	@GetMapping("/insertBoard") //Get 방식으로 들어왔을경우
	public String insertBoardView(@ModelAttribute("member")Member member) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		return "insertBoard";
	}
	
	@PostMapping("/insertBoard") //Post 방식으로 들어왔을경우
	public String insertBoard(@ModelAttribute("member")Member member, Board board) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		boardService.insertBoard(board);
		return "redirect:getBoardList";
	}
	
	@PostMapping("/updateBoard")
	public String updateBoard(@ModelAttribute("member")Member member, Board board) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		boardService.updateBoard(board);
		return "forward:getBoardList";
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(@ModelAttribute("member")Member member, Board board) {
		if(member.getId() == null) {
			return "redirect:login";
		}
		boardService.deleteBoard(board);
		return "forward:getBoardList";
	}
	
	@GetMapping("/hello")
	public void hello(Model model) {
		model.addAttribute("greeting", "Hello 타임리프.^^");
	}
	
}
