package edu.kh.oop.cls.pack복습;

import edu.kh.oop.basic.Nation;

public class Class복습 {

	// 클래스 : 객체의 속성, 기능을 정리한 문서
	
	// 클래스 선언 방법
	// [접근제한자] [예약어] class 클래스명{ }
	// -> [ ] 표시는 생략 가능
	
	// 접근제한자 종류
	// 1. public 
	//		-> 같은 프로젝트 내에서 어디서든 접근 가능
	// 2. (default)
	//		-> 같은 패키지 내에서 접근 가능, default 사용할 경우 무조건 생략
	
	
	// Nation n1 = new Nation();
	// -> Nation 참조 변수 n1에 Heap에 생성된 Nation 객체 주소를 대입
	
	
	// private으로 캡슐화 적용 시
	// 접근이 차단된 변수에 접근하려면 간접 접근 기능 사용
	// getter / setter 사용
	// ex) n1.getJob()
}
