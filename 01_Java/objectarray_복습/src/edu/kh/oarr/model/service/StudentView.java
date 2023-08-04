package edu.kh.oarr.model.service;

import java.util.Scanner;

public class StudentView {
	private Scanner sc = new Scanner(System.in);
	
	private StudentService service = new StudentService();
	
	public void displayMenu() {
		
		int input = 0; // 메뉴 번호 입력
		
		do {
			System.out.println("\n----- 학생 관리 프로그램 -----");
			System.out.println("1. 학생 추가");
			System.out.println("2. 학생 전체 조회");
			System.out.println("3. 학생 1명 정보 조회(인덱스)");
			System.out.println("4. 학생 이름으로 조회");
			System.out.println("5. 학생 정보 수정(인덱스)");
			System.out.println("6. 학생 1명 점수 조회(점수, 합계, 평균)");
			
			System.out.println("7. 평균 최고점, 최저점 학생");
			
			System.out.println("0. 종료");
			
			System.out.println("메뉴 선택 : ");
			input = sc.nextInt();
			
			switch(input) {
			case 1:	addStudent();	break;
			case 2:	selectAll();	break;
			case 3:		break;
			case 4:	 break;
			case 5:		break;
			case 6:		break;
			case 7:		break;
			
			case 0:	System.out.println("프로그램 종료");	break;
			default : System.out.println("잘못 입력"); break;
			}
			
			
		}while(input != 0);
	}
	
	
	public String addStudent() {
		// 학년, 반, 번호, 이름을 StudentService로 전달하여
		// 객체 배열에 추가
		// 성공시 true 실패시 false 반환
		System.out.println("\n ----- 학생 추가 -----");
		
		System.out.println("학년 : ");
		int grade = sc.nextInt();
		
		System.out.println("반 : ");
		int ban = sc.nextInt();
		
		System.out.println("번호 : ");
		int number = sc.nextInt();
		
		System.out.println("이름 : ");
		String name = sc.next();
		
		boolean result = service.addStudent(grade, ban, number, name);
		
		if(result) {
			return name + " 학생이 추가되었습니다.";
		} else {
			return "학생을 더 이상 추가할 수 없습니다.";
		}
	}
	
	
	/** 학생 전체 조회*/
	private void selectAll() {
		System.out.println("\n----- 학생 전체 조회 -----");
		
		Student[] arr = service.selectAll();
		
		for( Student s : arr) {
			if(s == null) {
				break;
			}
			System.out.println(s.toString());
		}
	}


	/** 학생 1명 정보 조회(인덱스)*/
	private void selectIndex() {
		System.out.println("\n----- 학생 1명 정보 조회 -----");
		
		System.out.print("조회할 학생의 인덱스 번호를 입력하세요 : ");
		int index = sc.nextInt();
		
		service.selectIndex();
		
		// StudentService로 index를 전달하여
		// 해당하는 index에 학생 개체가 있으면 그 객체의 주소를 반환
		// 그런데 index에 학생이 없거나 범위가 초과되면 null 반환
	}
}
