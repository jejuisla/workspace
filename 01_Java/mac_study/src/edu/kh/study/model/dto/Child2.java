package edu.kh.study.model.dto;

public class Child2 extends Parent{
private String house;
	
	// 생성자
	public Child2() {
		//super(); // 상속 관계 시 부모 객체가 먼저 생성되어야 하기 때문에
				// 자식 생성자 첫 번째 줄에 무조건 작성
				// 단, 미작성 시 컴파일러가 자동 추가
		System.out.println("Child2() 기본 생성자로 자식 객체 생성");
	}
	
	public Child2(String house) {
		this.house = house;
		System.out.println("Chilld2(String) 매개변수 생성자로 자식 객체 생성");
	}

	public Child2(int money, String lastName, String house) {
		
		// 자식 객체 생성 시
		// 매개변수가 있는 super() 생성자를 이용해서
		// 부모 객체의 필드도 초기화할 수 있다.
		
		super(money, lastName);
		this.house = house;
	}
	
	public String getHouse() {
		return house;
	}

	public void setHouse(String house) {
		this.house = house;
	}
	
	@Override // 문법 검사 (컴파일러가 읽으라고 주석 남김)
	public String toString() {
		// 부모로 부터 상속받은 멤버(필드, 메서드를 자식이 자신의 것처럼 사용 가능
//		setMoney(10);
//		getMoney();
		
		// 부모의 toString()을 호출하여 반환된 결과를 이용
		return super.toString() + " / " + house;
	}
}
