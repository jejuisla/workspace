package edu.kh.oop.field.pack1;

public class Field복습 {

	// 필드
	
	// 작성법
	// [접근제한자][예약어]자료형 변수명 [ = 초기값];
	// ex) public int v1 = 10;
	// -> 접근제한자 [예약어 생략] 자료형 변수명 = 초기값;
	
	// public : 같은 패키지 + 다른 패키지 (어디서든) 접근 가능
	// protected : 같은 패키지 + 다른 패키지 중 상속 관계 클래스에서만 접근 가능
	// (default) : 같은 패키지 내부에서만 접근 가능
	// private : 현재 클래스(정확히는 현재 객체) 내부에서만 접근 가능 
	
	public int v1 = 10;
	protected int v2 = 20;
	int v3 = 30; // default 생략
	private int v4 = 40;
	
	
	
	// 클래스 변수 : static이 붙은 변수
	// static이 붙으면 프로그램이 끝나기 전까지 고정
	// -> 프로그램 어디서든 공유 가능
	
	// static이 붙은 필드를 사용할 때는 클래스명.변수명 이렇게 사용 권장
}
