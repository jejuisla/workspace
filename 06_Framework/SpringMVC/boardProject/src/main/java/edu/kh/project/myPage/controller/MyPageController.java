package edu.kh.project.myPage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.myPage.model.service.MyPageService;

// Controller : 요청(어떤 서비스 호출)/응답(어떤 jsp, redirect) 제어

/* @SessionAttributes(매개변수)
 * 1) Model에 세팅된 값에 key와 매개변수에 작성된 문자열이 같다면
 * 	  Model 값의 Scope를 변경
 * 
 * 2) session scope로 올려둔 값 중 매개변수와 key가 일치하는 값을 얻어와 사용가능하게 함
 * 		-> @SessionAttribute(key) 어노테이션을 통해 얻어옴
 * 
 * */

@SessionAttributes({"loginMember"})
@RequestMapping("/myPage") // /myPage 로 시작하는 요청을 해당 컨트롤러에 연결 
@Controller // Controller 역할 + bean 등록
public class MyPageController {

	@Autowired // 등록된 bean 중 타입 일치(또는 상속관계)하는 bean을 의존성 주입 
	private MyPageService service;
	
	// 마이 페이지 화면 전환
	@GetMapping("profile")
	public String profile() {
		return "/myPage/myPage-profile"; // /WEB-INF/views/myPage/myPage-profile.jsp 로 forward
		// servlet-context.xml 참고	
	}
	
	@GetMapping("info")
	public String info() {
		return "/myPage/myPage-info";
	}

	@GetMapping("changePw")
	public String changePw() {
		return "/myPage/myPage-changePw";
	}

	@GetMapping("secession")
	public String secession() {
		return "/myPage/myPage-secession";
	}
	
	// ---------------------------------------------------------------------
	/** 회원 정보 수정
	 * @param updateMember : 수정된 회원정보가 담긴 커맨드객체
	 * @param memberAddress : 입력된 주소만 저장한 String 배열
	 * @param RedirectAttributes : 리다이렉트 시 request scope로 데이터 전달
	 * @param loginMember : 로그인한 회원정보가 담긴 객체(Session) -> 로그인한 회원 번호를 얻어와 SQL 조건으로 사용
	 * @return
	 */
	@PostMapping("info") // /myPage/info (POST)
	public String info(Member updateMember, String[] memberAddress, RedirectAttributes ra, @SessionAttribute("loginMember") Member loginMember) {
																					//	@SessionAttribute("loginMember") Member loginMember
																					// -> session scope에 올려둔 값 중 key가  "loginMember"인 값을 얻어와
																					// Member loginMember 매개변수에 주입
		// 1. loginMember에서 로그인한 회원의 번호를 얻어와
		// 		updatdMember에 추가
		int MemberNo = loginMember.getMemberNo();
		updateMember.setMemberNo(MemberNo);
		
		// 2. 회원 정보 수정 서비스 호출 후 결과 반환
		int result = service.info(updateMember, memberAddress);
		
		// 3. 서비스 결과에 따라 응답처리
		String message = null;
		if(result>0) { // 성공 시
			message = "회원 정보가 수정되었습니다.";
			/* DB 정보를 수정했을 뿐 session이 수정되지 않음 */
			// -> session에 저장된 loginMember 수정
			// 얕은 복사 개념 적용
			
			loginMember.setMemberNickname(updateMember.getMemberNickname());
			loginMember.setMemberTel(updateMember.getMemberTel());
			loginMember.setMemberAddress(updateMember.getMemberAddress());
		}else { // 실패 시
			message = "회원 정보 수정실패";
		}
		
		// 4. message를 ra를 이용해 값을 세팅한 후 리다이렉트
		ra.addFlashAttribute("message",message);
		
		// 현재 요청주소: http:localhost/myPage/info (POST)
		// 목표 요청주소: http:localhost/myPage/info (GET)
		
		// redirect : GET방식 요청
		return "redirect:info"; // 상대경로
	}
	
	@PostMapping("changePw")
	public String chagenPw(@RequestParam("currentPw") String currentPw, String newPw, @SessionAttribute("loginMember") Member loginMember,
							RedirectAttributes ra) {
							
		// 로그인한 회원번호
		int memberNo = loginMember.getMemberNo();
		
		// 비밀번호 변경 서비스 호출 후 결과 반환받기
		int result = service.changePw(currentPw, newPw, memberNo);
		
		String path = null;
		String message = null;
		
		if(result > 0) { // 변경 성공 시
			message = "비밀번호가 변경되었습니다.";
			path = "redirect:info"; // 내 정보 페이지 재요청 (성공하면 다른곳으로 이동)
		}else { // 변경 실패 시
			message = "현재 비밀번호가 일치하지 않습니다.";
			path = "redirect:changePw"; // 비밀번호 변경 페이지 재요청
		}
		ra.addFlashAttribute("message", message);
		return path;
	}
	
	/** 회원 탈퇴
	 * @param memberPw : 현재 비밀번호
	 * @param ra : 리다이렉트 시 데이터 전달
	 * @param status : 세션 상태 관리(만료 시 사용)
	 * @return
	 */
	@PostMapping("secession")
	public String secession(String memberPw,
							@SessionAttribute("loginMember") Member loginMember, 
							RedirectAttributes ra,
							SessionStatus status) {
		// 1. 로그인한 회원번호 얻어오기
		int memberNo = loginMember.getMemberNo();
		
		// 2. 회원 탈퇴 서비스 호출
		int result = service.secession(memberPw, memberNo);
		
		// 3. 서비스 결과에 따라 응답 처리
		String path = null;
		String message = null;
		
		if(result > 0) {
			message = "탈퇴되었습니다";
			path = "redirect:/";
			status.setComplete(); // 세션 만료
		}else {
			message = "비밀번호가 일치하지 않습니다";
			path = "redirect:secession";
		}
		
		ra.addFlashAttribute("message", message);
		return path;
	}
}
