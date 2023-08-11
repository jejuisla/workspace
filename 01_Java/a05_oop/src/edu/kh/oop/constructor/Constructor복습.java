package edu.kh.oop.constructor;

public class Constructor복습 {

	// 필드 + 캡슐화
	private String Id;
	private String Pw;
	private String Name;
	private int age;
	
	// 기본 생성자
	// 생성자 규칙 : 클래스명과 동일한 생성자명 사용
	public Constructor복습() {
		System.out.println("기본생성자로 생성");
		
		Id = "mem01";
		Pw = "pass01";
		Name = "홍길동";
		age = 26;
	}

	
	// 매개변수 생성자
	// () 안에 작성된 값을 전달 받아 저장하는 변수
	// alt + shift + s -> o
	public Constructor복습(String id, String pw, String name, int age) {
		super();
		Id = id;
		Pw = pw;
		Name = name;
		this.age = age;
	}
	
	
	
}
