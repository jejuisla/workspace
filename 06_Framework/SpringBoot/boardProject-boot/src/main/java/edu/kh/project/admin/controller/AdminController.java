package edu.kh.project.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.kh.project.admin.model.service.AdminService;
import edu.kh.project.member.model.dto.Member;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {
	
	@Autowired
	private AdminService service;
	
	/** 관리자 메인 페이지
	 * @return admin-main
	 */
	@GetMapping("main")
	public String adminMain() {
		// forward : 요청 위임
		// Thymeleaf
		// - prefix : classpath:/templates/
		//	 suffix : .html
		return "admin/admin-main";
	}
	
	@GetMapping("selectMember")
	public String selectMember(String inputEmail, Model model) {
		// 이메일이 일치하는 회원이 존재하는 경우
		// model.addattribute("searchMember",value);
		// return "admin/success";
		Member searchMember = service.selectMember(inputEmail);
		
		if(searchMember != null) {
			model.addAttribute("searchMember", searchMember);
			return "admin/success";
		} else {
			return "admin/fail";
		}
		// 이메일이 일치하는 회원이 존재하지 않는 경우
		// return "admin/fail";
		
	}
}
