package edu.kh.oarr.view;

import java.util.Scanner;

import edu.kh.oarr.model.dto.Student복습;
import edu.kh.oarr.model.service.StudentService복습;

public class StudentView복습 {

	private Scanner sc = new Scanner(System.in);
	
	private StudentService복습 service = new StudentService복습();
	
	public void displayMenu() {
		
		int input = 0;
		
		do {
			System.out.println("\n----- 학생 관리 프로그램 -----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			
			System.out.println("0. 종료");
			
			System.out.println("메뉴 선택 : ");
			input = sc.nextInt();
			
			switch(input) {
			case 1: addStudent(); break;
			case 2: selectAll(); break;
			
			case 0: System.out.println("프로그램 종료"); break;
			default : System.out.println("잘못 입력");
			}
		} while(input != 0);
	}
	
	
	public String addStudent() {
		
		System.out.println("\n-----학생 추가-----\n");
		
		System.out.println("학년 : ");
		int grade = sc.nextInt();

		System.out.println("반 : ");
		int ban = sc.nextInt();
		
		System.out.println("번호 : ");
		int number = sc.nextInt();
		
		System.out.println("이름 : ");
		String name = sc.next();
		
		// 학년, 반, 번호, 이름을 StudentService로 전달하여
		// 객체 배열에 추가
		// 성공시 true 실패시 false 반환
		
		boolean result = service.addStudent(grade, ban, number, name);
		
		if(result) {
			return name + " 학생이 추가되었습니다.";
		} else {
			return "학생을 더 이상 추가할 수 없습니다.";
		}
		
	}
	
	
	public void selectAll() {
		System.out.println("\n -----학생 전체 조회-----\n");
		
		Student복습[] arr = service.selectAll();
		
		// for( 배열 요소 하나를 저장할 변수 : 배열명)
		// 배열 내 모든 요소를 접근하는 용도의 for문
		for( Student복습 s : arr ) {
			if(s == null) break;
			System.out.println(s.toString());
		}
	}
	
}
