package oop_practice.field;

public class PersonPracitceRun1 {
	public static void main(String[] args) {
		
		// 사람 객체 생성
		PersonPractice p2 = new PersonPractice();
		
		// p1이 참조하는 객체의 name 필드 값을 세팅
		p2.setName("홍길동");
		
		String result2 = p2.getName();
		
		System.out.println(result2);
	}
}
