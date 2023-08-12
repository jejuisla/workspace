package edu.kh.inheritance.model.dto;

public class Parent복습 extends Object{

	public int money = 100_000;
	private String lastName = "홍";
	
	public Parent복습() {
		
	}

	public Parent복습(int money, String lastName) {
		super();
		this.money = money;
		this.lastName = lastName;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Parent복습 [money=" + money + ", lastName=" + lastName + "]";
	}
	
}
