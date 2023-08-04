package edu.kh.array.practice;

public class ArrayPractice {

	public void practice1() {
		int sum = 0;
		for(int i=1; i<10; i++) {
			System.out.print(i + " ");
			if(i%2 == 0) {
				sum += i;
			}
		}
		System.out.println();
		System.out.println("짝수 번째 인덱스 합 : " + sum);
	}
	
	public void pracitce2() {
		
	}
}
