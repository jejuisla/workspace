package edu.kh.project.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
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
	 * @param saveId : 아이디 저장 체크 시 "on", 미체크 시 null
	 * @param resp : 응답 방법을 제공하는 객체
	 * @return 메인 페이지로 리다이렉트
	 */
	@PostMapping("login")
	public String login(Member inputMember, Model model, RedirectAttributes ra, String saveId, HttpServletResponse resp) {
		
		// 로그인 서비스 호출 
		Member loginMember = service.login(inputMember);
		
		// 로그인 성공 시
		if(loginMember != null) {
			// 쿠키 객체 생성
			// jakarta.servlet.http.Cookie
			// Map형식(K:v) 형식으로 데이터 저장
			Cookie cookie = new Cookie("saveId", loginMember.getMemberEmail());
			
			// 아이디 저장이 체크된 경우
			if(saveId != null) {
				// 쿠키의 수명(유지기간) 지정 (초 단위)
				cookie.setMaxAge(60*60*24*30); // 1개월
			}
			// 체크되지 않은 경우
			else {
				cookie.setMaxAge(0); // 만들자마자 없어짐 == 삭제
			}
			
			// 쿠키가 어떤 요청에 첨부되서 전달될 지 주소(경로)지정
			cookie.setPath("/"); // 최상위 주소 이하 모든 요청
			
			// 응답 객체(HttpServletResponse)를 이용해 서버 응답 시
			// 클라이언트에게 생성한 쿠키 전달
			// -> 전달받은 클라이언트(브라우저)가 
			// Cookie 객체를 브라우저 자체 쿠키 파일에 저장
			resp.addCookie(cookie);
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
	
	// @PathVariable("key")
	// - 경로(주소)를 변수에 값으로 사용하는 어노테이션
	
	/** 빠른 로그인(완성 후 삭제)
	 * @param memberEmail : 주소 마지막 레벨 문자열(@PathVariable)
	 * @param model : 데이터 전달용 객체
	 * @param ra : 리다이렉트 시 request scope로 데이터 전달
	 * @return
	 */
	@GetMapping("login/{memberEmail}")
	public String quickLogin(@PathVariable("memberEmail") String memberEmail, Model model, RedirectAttributes ra ) {
		
		Member loginMember = service.quickLogin(memberEmail);
		
		if(loginMember == null) {
			ra.addFlashAttribute("message", "빠른 로그인 실패");
		}
		// (기본값) request scope
		// @SessionAttributes({"loginMember"}) -> session scope로 이동
		model.addAttribute("loginMember", loginMember);
	
		return "redirect:/";
	}
	
	/* HttpMessageConverter
	 * Spring에서 비동기 통신 시
	 * - 전달되는 데이터의 자료형이나 응답하는 데이터의 자료형
	 * 위 두가지 알맞은 형태로 가공(변환)해주는 객체
	 * 
	 * - 문자열, 숫자 <-> TEXT
	 * - Map <-> JSON
	 * - DTO <-> JSON
	 * 
	 * (참고) 
	 * HttpMessageConverter가 동작하기 위해서는
	 * Jackson-data-bind 라이브러리가 필요한데
	 * SPring Boot 모듈에 내장되어 있음
	 * (Jakcson : 자바에서 JSON 다루는 방법을 제공하는 라이브러리)
	 * */
	/** 이메일 중복 검사
	 * @param email
	 * @return 0 또는 1
	 */
	@GetMapping("checkEmail")
	@ResponseBody
	public int checkEmail(String email) {
		
		return service.checkEmail(email);
	}
	
	@GetMapping("checkNickname")
	@ResponseBody
	public int checkNickname(String nickname) {
		return service.checkNickname(nickname);
	}
	
	
	
	
}
