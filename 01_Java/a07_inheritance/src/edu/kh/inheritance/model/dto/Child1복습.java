package edu.kh.inheritance.model.dto;

public class Child1복습 extends Parent복습{

	private String car;
	
	public Child1복습() {
		super();
	}
	
	public Child1복습(String car) {
		super();
		this.car = car;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	@Override
	public String toString() {
		return "Child1복습 [car=" + car + "]";
	}
	
	@Override
	public int getMoney() {
		return (int)(super.getMoney()*0.6);
	}
}
