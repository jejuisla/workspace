package edu.kh.poly.model.dto;

public class Car복습 extends Object{

	private int wheel;
	private int seat;
	private String fuel;
	
	public Car복습() {
		
	}

	public Car복습(int wheel, int seat, String fuel) {
		super();
		this.wheel = wheel;
		this.seat = seat;
		this.fuel = fuel;
	}

	public int getWheel() {
		return wheel;
	}

	public void setWheel(int wheel) {
		this.wheel = wheel;
	}

	public int getSeat() {
		return seat;
	}

	public void setSeat(int seat) {
		this.seat = seat;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	@Override
	public String toString() {
		return "Car복습 [wheel=" + wheel + ", seat=" + seat + ", fuel=" + fuel + "]";
	}
	
	
}
