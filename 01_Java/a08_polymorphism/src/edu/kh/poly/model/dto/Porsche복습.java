package edu.kh.poly.model.dto;

public class Porsche복습 extends Car복습{

	private boolean OpenDoor;
	
	public Porsche복습() {
		
	}

	public Porsche복습(int wheel, int seat, String fuel, boolean Opendoor) {
		super(wheel, seat, fuel);
		this.OpenDoor = Opendoor;	
	}

	public boolean isOpenDoor() {
		return OpenDoor;
	}

	public void setOpenDoor(boolean openDoor) {
		OpenDoor = openDoor;
	}

	@Override
	public String toString() {
		return "Porsche복습 [OpenDoor=" + OpenDoor + "]";
	}
	
	

	
	
	
	
}
