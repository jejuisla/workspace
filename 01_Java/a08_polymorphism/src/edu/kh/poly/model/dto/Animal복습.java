package edu.kh.poly.model.dto;

public abstract class Animal복습 {

	private String type;
	private int tail;
	private int foot;
	private String eatType;
	
	public Animal복습() {
		super();
	}

	public Animal복습(String type, int tail, int foot, String eatType) {
		super();
		this.type = type;
		this.tail = tail;
		this.foot = foot;
		this.eatType = eatType;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTail() {
		return tail;
	}

	public void setTail(int tail) {
		this.tail = tail;
	}

	public int getFoot() {
		return foot;
	}

	public void setFoot(int foot) {
		this.foot = foot;
	}

	public String getEatType() {
		return eatType;
	}

	public void setEatType(String eatType) {
		this.eatType = eatType;
	}
	
	@Override
	public String toString() {
		return type + " / " + eatType;
	}
	
	public abstract void breath();
}
