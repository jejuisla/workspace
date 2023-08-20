package edu.kh.오답;

public class Fruit {

	private String name; // 과일명
	private int price; // 가격
	private int amount; // 개수
	
	public Fruit() {}

	public Fruit(String name, int price, int amount) {
		super();
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
// 생성자에 매개변수가 몇개있는지 잘 확인
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
}
