package com.kh.test.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

@Controller //컨트롤러 bean등록
@RequestMapping("board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@PostMapping("insert")
	public String insert(String boardTitle, String boardPw, String boardWriter, String boardContent) {
		
		int result = service.insert(boardTitle, boardPw, boardWriter, boardContent);
		
		if(result>0) {
			return "redirect:/";
		}
		return "redirect:insert";
	}
	
	@GetMapping("/selectOne")
	public String selectOne(Board board, int boardNo) {
		
		Board selectBoard = service.selectOne(boardNo); 
		
		return null;
	}
	
}
