package edu.kh.poly.model.dto;

// Car를 상속 받은 자식 클래스 Porshce
public class Porsche extends Car{

	
	private boolean openTheDoor;
	
	public Porsche() {
		
	}

	public Porsche(int wheel, int seat, String fuel, boolean openTheDoor) {
		super(wheel, seat, fuel);
		this.openTheDoor = openTheDoor;
	}

	// Car의 toString() 오버라이딩
	@Override
	public String toString() {
		return super.toString() + " / Porsche [openTheDoor=" + openTheDoor + "]";
	}

	

	

	


	
}
