package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	// "/" 로 요청을 받게되면
	@RequestMapping("/")
	public String MainPage() {
		
		return "common/main";
		// /WEB-INF/views/common/main.jsp 로 forward
	}
}
