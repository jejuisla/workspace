package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그 찍어보기
@Controller // Controller 역할(응답/요청 제어) + bean 등록
@RequestMapping("member") // Spring Boot Controller에서 요청 주소 작성시 제일 앞에 "/" 제외하고 작성
@SessionAttributes({"loginMember"}) // session 올리기
public class MemberController {

	// MemberService 의존성주입(DI)
	@Autowired
	private MemberService service;
	
	/**
	 * @param inputMember : 아이디, 비밀번호
	 * @param model : 데이터 전달 객체
	 * @param ra : 리다이렉트 시 request scope로 데이터 전달
	 * @return 메인 페이지로 리다이렉트
	 */
	@PostMapping("login")
	public String login(Member inputMember, Model model, RedirectAttributes ra) {
		
		// 로그인 서비스 호출 
		Member loginMember = service.login(inputMember);
		
		// 로그인 성공 시
		if(loginMember != null) {
			// 쿠키 생성 코드 작성 예정
		}
		// 로그인 실패 시
		if(loginMember == null) {
			ra.addFlashAttribute("message","아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		model.addAttribute("loginMember",loginMember); // 로그인 결과를 session에 등록
		// 메인페이지로 리다이렉트
		return "redirect:/";
	}
	
	@GetMapping("logout")
	public String logout(SessionStatus status) {
		status.setComplete(); // @SessionAttributes 세션 만료
		return "redirect:/";
	}
	
	
	/** 로그인 전용 페이지 forward
	 * @return "member/login"
	 */
	@GetMapping("login")
	public String login() {	
		return "member/login";
	}
	
	/** 회원가입 페이지 forward
	 * @return
	 */
	@GetMapping("signup")
	public String signup() {
		// templates/member/signup.html 로 forward
		return "member/signup";
	}
	
	/** 회원가입
	 * @param inputMember : 파라미터가 저장된 커맨드 객체
	 * @param memberAddress : 주소 입력 값이 저장된 배열(가공 예정)
	 * @param RedirectAttributes : 리다이렉트 시 request scope로 값 전달
	 * @return
	 */
	@PostMapping("signup")
	public String signup(Member inputMember, String[] memberAddress, RedirectAttributes ra) {
		
		// 회원가입 서비스 호출
		int result = service.signup(inputMember, memberAddress);
		
		// 회원가입 성공 시
		if(result > 0) {
			ra.addFlashAttribute("message", "회원 가입 성공");
			return "redirect:/";
		}
		// 회원가입 실패 시
		ra.addFlashAttribute("message", "가입 실패");
		return "redirect:signup"; // 회원가입 페이지(상대경로)
		
	}
	
	
}