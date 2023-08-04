package edu.kh.oarr.model.service;

import java.util.Random;

public class StudentService {

	// 필드
	private Student[] studentArr = new Student[10];
	// 학생 객체 참조 변수 10개의 묶음 Student[]을 생성하고
	// 그 주소를 studentArr에 대입
	
	// 기본생성자
	// 샘플 학생 데이터 3개 추가
	public StudentService() {
		studentArr[0] = new Student(1, 2, 3, "홍길동");
		studentArr[1] = new Student(3, 6, 9, "박철수");
		studentArr[2] = new Student(2, 4, 8, "최미영");
		
		Random random = new Random();
		
		for(int i=0; i<studentArr.length; i++) {
			
			if(studentArr[i] == null) {
				break;
			}
			studentArr[i].setKor(random.nextInt(101));
			studentArr[i].setEng(random.nextInt(101));
			studentArr[i].setMath(random.nextInt(101));
		}
		
	}

	/** 학생 추가 서비스*/
	public boolean addStudent(int grade, int ban, int number, String name) {
		// 1. studentArr의 요소 중
		//	  참조하는게 없는 배열요소를 찾아
		//    그 중 index 번호가 가장 낮은 요소에 학생 객체 주소를 대입
		//	  true 반환
		for(int i=0; i<studentArr.length;i++) {
			if(studentArr[i] == null) {
				studentArr[i] = new Student(grade, ban, number, name);
				
				return true;
			}
		}
		return false;
	}

	
	/** 학생 전체 조회 서비스*/
	public Student[] selectAll() {
		return studentArr;
	}

	
	/** 학생 1명 점수 조회(각각의 점수, 합계, 평균)*/
	public void selectIndex() {
		// TODO Auto-generated method stub
		
	}
	
	
}
