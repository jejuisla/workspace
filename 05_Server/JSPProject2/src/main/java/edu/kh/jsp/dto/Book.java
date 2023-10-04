package edu.kh.jsp.dto;

public class Book {
	private String title;
	private String writter;
	private int price;
	
	public Book() {}
	
	public Book(String title, String writter, int price) {
		super();
		this.title = title;
		this.writter = writter;
		this.price = price;
	}
	
	public String getTitle(){
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getWritter() {
		return writter;
	}
	public void setWritter(String writter) {
		this.writter = writter;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override // 오버라이딩 메서드 잘 작성되었나 확인
	public String toString() {
		return String.format("%s / %s / %d", title, writter, price);
	}
}
