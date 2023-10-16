package edu.kh.project.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.project.member.model.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 현재 클래스에서 로그 출력 시 작성하는 어노테이션
@Controller
public class MainController {

	@RequestMapping("/") // GET/POST 가리지 않고 매핑
	public String MainPage(Model model) {
		// Model : 데이터 전달용 객체 (request scope)
		model.addAttribute("testName","홍길동");
		model.addAttribute("testAge",27);
		
		Member testMember = new Member();
		testMember.setMemberNo(999);
		testMember.setMemberEmail("testMember@gmail.com");
		testMember.setMemberNickname("테스트");
		
		model.addAttribute("testMember", testMember);
		
		// text, utext 비교
		model.addAttribute("address", "<h1>서울시 강남구</h1>");
		
		// 로그 출력 방법
		// log.debug("문자열");
		log.debug("로그는 이렇게 찍을수 있음");
		log.debug("메인페이지 요청이 왔습니다");
		
		/* Thymeleaf 템플릿 엔진 사용 시 접두사, 접미사 */
		// 접두사 : classpath:/templates/
		// 접미사 : .html
		
		// classpath == src/main/resources 폴더
		return "common/main";
	}
}
