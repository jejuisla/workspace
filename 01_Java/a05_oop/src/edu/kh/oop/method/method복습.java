package edu.kh.oop.method;

public class method복습 {

	private String name;
	private int age;
	private char gender;
	
	
	public method복습() {
		
	}


	public method복습(String name, int age, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	// 메서드
	// 작성법
	// [접근제한자][예약어] 반환형 메서드명([매개변수]){ }
	
	// 반환형 void 메서드 -> 메서드 수행 후 돌려 보내주는 값 없음
	
	public void method1() {
		this.name = name;
		return;
	}
	
	// 반환형 -> return할 값의 자료형
	public String method2() {
		this.name = name;
		return this.name;
	}
	
	
	
	
}
