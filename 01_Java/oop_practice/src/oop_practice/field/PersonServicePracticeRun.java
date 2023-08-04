package oop_practice.field;

public class PersonServicePracticeRun {
	public static void main(String[] args) {
		
		PersonServicePractice servicePractice = new PersonServicePractice();
		
		// PersonServicePractice 객체에 초기화된 title출력
		String title = servicePractice.getTitle2();
		System.out.println(title);
		
		
		PersonPractice p1 = servicePractice.createPerson2();
							// 생성된 Person 객체의 주소만 반환 받음
		
		String str2 = servicePractice.PersonFields(p1);
			System.out.println(str2);
		
	}
}
