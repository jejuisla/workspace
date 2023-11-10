package com.kh.test.controller;

public class Buycar{
	private Driver bestDriver;
	private Car carType;
	
	public Buycar(Driver d) {
		this.bestDriver = d;
		this.carType = new Benz();
	}
}
