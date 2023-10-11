package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 객체 : new 연산자에 의해서 class 내용대로 heap 영역에 생성된 것 

// instace : 개발자가 만들고 관리하는 객체
// bean : Spring (Spring Container)이 만들고 관리하는 객체

@Controller // bean등록 + Controller 역할도 할 것이라는 것을 명시
							// Controller : 요청/응답 제어
public class MainController {
	
	// "/" 로 요청을 받게되면
	@RequestMapping("/")
	public String MainPage() {
		
		return "common/main";
		// /WEB-INF/views/common/main.jsp 로 forward
	}
}
