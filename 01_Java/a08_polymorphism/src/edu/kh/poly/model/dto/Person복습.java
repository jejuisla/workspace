package edu.kh.poly.model.dto;

public class Person복습 extends Animal복습{

	private String name;
	private int age;
	
	public Person복습() {
		
	}

	public Person복습(String type, int tail, int foot, String eatType, String name, int age) {
		super(type,  tail, foot ,eatType);
		this.name = name;
		this.age = age;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person복습 [name=" + name + ", age=" + age + "]";
	}
	
	@Override
	public void breath() {
		System.out.println("사람 : 입과 코로 숨을 쉼");
	}
	
	
	
}
