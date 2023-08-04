package oop_practice.field;

public class PersonPractice {

	// 필드
	private String name;
	private int age;
	private char gender;
	
	// 기본 생성자
	public PersonPractice() {
		
	}
	
	// 매개변수 생성자
	public PersonPractice(String name, int age, char gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	
	// 메서드 : 객체의 기능
	
	// [접근제한자] [예약어] 반환형 메서드명 ([매개변수]){ }
	
	// name 필드에 전달 받은 값을 세팅하는 메서드
	// 반환형 void : 메서드 수행 후 돌려 보내주는 결과가 없음
	public void setName(String name) {
		this.name = name;
		
		return; // 현재 메서드를 종료하고
				// 현재 메서드를 호출한 곳으로 돌아감
		
		// void 메서드는 return을 작성하지 않아도 컴파일로가 자동 추가
	}
	
	// name필드의 값을 호출한 곳으로 돌려 보내주는 메서드
	public String getName() {
		// 반환형 : return할 값의 자료형
		
		// return 값 : 메서드 종료 후 호출한 곳으로 값을 가지고 돌아가기
		return this.name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return this.age;
	}
	
	public void setGender(char gender) {
		this.gender = gender;
	}
	public char getGender() {
		return this.gender;
	}
}
