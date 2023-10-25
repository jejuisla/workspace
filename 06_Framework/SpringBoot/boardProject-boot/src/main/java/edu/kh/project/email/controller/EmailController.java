package edu.kh.project.email.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.kh.project.email.model.service.EmailSevice;
import lombok.RequiredArgsConstructor;

// @RestController : 비동기 요청 및 응답 제어 용도의 컨트롤러
@RestController // @Controller + @ResponseBody
@RequestMapping("email")
@RequiredArgsConstructor // 초기화되지 않은 final 필드에 bean DI
						// -> @Autowired 생성자 버전 자동완성
public class EmailController {

	// @Autowired를 이용한 DI 방법은 3가지가 존재
	// - 필드 (쉬움, 권장 X)
	// - setter
	// - 생성자 (권장)
	
	/* @Autowired 생성자 버전 */
	
	// 1) 의존성 주입을 받을 필드를 선언(final 필수)
	private final EmailSevice service;
	
	// 2) 매개변수 생성자
//	@Autowired
//	public EmailController(EmailSevice service) {
//		// 매개변수에 bean이 자동으로 주입(DI)
//		this.service = service;
//	}
	
	// 위 구문을 더 쉽게 하는 방법
	// -> Lombok의 @RequiredArgsConstructor 사용
	
	/** 회원가입 인증번호 생성 + 이메일 발송 + insert 또는 update
	 * @return
	 */
	@PostMapping("signup")
	public int signup(@RequestBody String email) {
		return service.sendEmail("signup",email);
	}
	
	@PostMapping("checkAuthKey")
	public int checkAuthKey(@RequestBody Map<String, Object> paramMap) {
		return service.checkAuthKey(paramMap);
	}
}
