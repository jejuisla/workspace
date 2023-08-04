package oop_practice.field;

import java.util.Scanner;

public class PersonServicePractice {
	
	private Scanner sc = new Scanner(System.in);
	
	private String title;
	
	public PersonServicePractice() {
		title = "Person을 이용한 프로그램";
	}
	public String getTitle2() { // 프로그램 이름 반환
		return title;
	}
	
	// 사람 객체를 생성해서 반환하는 메서드
	public PersonPractice createPerson2() {
		System.out.print("이름 : ");
		String name = sc.next();
		
		System.out.print("나이 : ");
		int age = sc.nextInt();
		
		System.out.print("성별 : ");
		char gender = sc.next().charAt(0);
		
		PersonPractice p = new PersonPractice(name,age,gender);
		
		return p;
	}
	
	// 매개변수로 전달받은 PersonPractice를 이용해서
	// 필드에 작성된 값을 하나의 문자열로 만들어서 반환
	public String PersonFields(PersonPractice p) {
		String str2 = p.getName() + "/" + p.getAge();
		
		return str2;
	}
}
