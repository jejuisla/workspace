package edu.kh.control.loop.ex;

import java.util.Scanner;

public class loop복습 {

	public void ex1() {
		for(int i=2; i<=20; i+=2) {
			System.out.println(i);
		}
	}
	
	public void ex2() {
		for(int i=1; i<100; i *=2) {
			System.out.println(i);
		}
	}
	
	
	public void ex3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("시작 : ");
		int start = sc.nextInt();

		System.out.println("끝 : ");
		int end = sc.nextInt();
		
		System.out.println("증가할 수 : ");
		int add = sc.nextInt();
		
		int sum = 0;
		for(int i=start; i<= end; i+= add) {
			System.out.print(i + " ");
			sum += i;
		}
		System.out.println();
		System.out.println(sum);
	}
	
	public void ex4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("단 : ");
		int dan = sc.nextInt();
		
		if(dan >= 2 && dan<=9) {
			for(int i=1; i<=9; i++) {
				System.out.printf(" %d * %d = %d \n", dan, i, dan*i);
			}
		} else{
			System.out.println("잘못 입력 하셨습니다.");
		}
	}
	
	
	
	public void ex5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 입력 : ");
		int input = sc.nextInt();
		
		switch(input) {
		case 1: for(int i=2; i<=9; i++) {
			System.out.print(i + " ");
		} break;
		case 2: for(int r=9; r>=2; r--) {
			System.out.print(r + " ");
		} break;
		default: System.out.println("잘못 입력 하셨습니다.");
		}
	}
	
	// for문 에서 초기식 작성X -> 입력받은 값 사용
	
	
//	
//	while(조건식) {
//		// 조건식이 true일 때 수행할 구문
//	}
	
	public void ex6() {
		Scanner sc = new Scanner(System.in);
		
		int input = -1;
		int sum = 0;
		while(input != 0) {
			System.out.print("정수 입력 : ");
			input = sc.nextInt();
			sum += input;
		}
		System.out.println(sum);
	}
	
	
	
	public void ex7() {
		Scanner sc = new Scanner(System.in);
		
		int input = -1;
		int sum = 0;
		String OrderMenu ="";
		while(input != 0) {
			System.out.println("1. 김밥(2000)");
			System.out.println("2. 라면(4000)");
			System.out.println("3. 우동(4000)");
			System.out.println("0. 주문완료");
			
			System.out.println("번호 선택 : ");
			int number = sc.nextInt();
			
			switch(number) {
			case 1: 
				sum += 2000;
				OrderMenu += "김밥";
				break;
				
			case 2:
				sum += 4000;
				OrderMenu += "라면";
				break;
				
			case 3:
				sum += 2000;
				OrderMenu += "우동";
				break;
				
			case 0: System.out.println("주문 완료!"); break;
			default : System.out.println("잘못 입력하셨습니다");
			}
		}
	}
}
