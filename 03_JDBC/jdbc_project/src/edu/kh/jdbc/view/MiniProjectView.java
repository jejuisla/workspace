package edu.kh.jdbc.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.kh.jdbc.model.dto.MiniProject;
import edu.kh.jdbc.model.service.MiniProjectService;

public class MiniProjectView {
	private Scanner sc = new Scanner(System.in);
	private MiniProjectService service = new MiniProjectService(); 
	
	public void displayMenu() {
		int input = -1;
		
		do {
			try {
				System.out.println("MAIN 페이지");
				System.out.println("1. 회원가입");
				System.out.println("2. 개인정보 수정");
				System.out.println("3. QnA 등록");
				System.out.println("4. QnA 삭제");
				System.out.println("5. QnA 조회");
				System.out.println("6. QnA 추천");
				System.out.println("0. 종료");
				
				System.out.println("메뉴 선택 : ");
				input = sc.nextInt();
				switch(input) {
				case 1: insertMember(); break;
				case 0: System.out.println("프로그램 종료");
				default: System.out.println("메뉴 번호만 입력해주세요");
				}
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력");
				sc.nextLine();
			}
		}while(input != 0);
		
	}

	private void insertMember() {
		System.out.println("회원가입");
		
		System.out.print("아이디 : ");
		String id = sc.next();

		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("주소 : ");
		String address = sc.next();

		System.out.print("전화번호 : ");
		String phone = sc.next();
		
		System.out.print("주민번호 : ");
		String ssn = sc.next();
		
		MiniProject member = new MiniProject(id, pw, phone, address, phone, name, ssn);
		
		int result = service.insertMember(member);
		
		
		
		
		
	}
}
