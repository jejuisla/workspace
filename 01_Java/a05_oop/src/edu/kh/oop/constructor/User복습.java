package edu.kh.oop.constructor;

public class User복습 {
	
	private String name;
	private int age;
	private String address;
	
	public User복습() {
		
	}
	// 생성자가 작성되지 않을경우 컴파일러가 자동 추가
	// 생성자를 임의로 하나 이상 작성하면 자동 추가 X
	
	
	// 오버로딩(OverLoading)
	// - 한 클래스 내부에
	//   동일한 이름의 메서드, 생성자를 여러개 작성하는 기법
	
	// --> 메서드, 생성자 이름은 하나인데
	//     매개변수의 차이에 따라서 알맞는 메서드, 생성자가 수행됨
	
	// * 오버로딩 성립 조건 *
	// 1. 메서드, 생성자 이름이 같아야 한다!!
	// 2. 매개변수의 개수, 순서, 타입 중 하나라도 달라야 한다.
	// 3. 접근 제한자는 상관 없음
	
	public User복습(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public User복습(int age, String name) {
		this.age = age;
		this.name = name;
	}
	// 매개변수 개수가 다르면 여러개 작성 가능
	// 매개변수 순서가 다르면 여러개 작성 가능
	// 자료형이 다르면 여러개 작성 가능
	
	
	
}
