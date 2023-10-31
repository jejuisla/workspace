package com.kh.test.board.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.test.board.model.dto.Board;
import com.kh.test.board.model.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	@GetMapping("selectBoard")
	public String selectBoard(String boardTitle, Model model) {
		
		Board result = service.selectBoard(boardTitle);
		
		if(result != null) {
			model.addAttribute("result", result);
			return "searchSuccess";
		}else {
			return "searchFail";
		}
	}
	
	
}
