package edu.kh.control.loop.practice;

import java.util.Scanner;

public class LoopPractice {

	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 하나 입력하세요 : ");
		int input = sc.nextInt();
		
		int sum = 0;
		
		for(int i =1 ; i <= input; i++) {
			i += sum;
			
			System.out.print(i);
			
			if(i < input) {
				System.out.print("+");
			}
		} System.out.print("=" + sum);
	}
	
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 숫자 : ");
		int input1 = sc.nextInt();
		System.out.print("두 번째 숫자 : ");
		int input2 = sc.nextInt();
		
		
		if(input1 >= 1 && input2 >= 1) { // 먼저 입력한 수(input1)가 작거나 같을 때 
			/*  쉬운 방법
			if(input1 <= input2) {
				for(int i = input1; i<= input2; i++) {
					System.out.print(i + " ");
				}
			}else { // 나중에 입력한 수(input2)가 작을 때
				for(int i = input2; i<= input1; i++) {
					System.out.print(i + " ");
				}
			}
		} else {
			System.out.print("1 이상의 숫자를 입력해주세요.");
		} */
		
		
			if(input1 > input2) { // 먼저 입력한 수가 더 큰경우
				// 두 변수의 값 교환(임시 변수 필요)
				int temp = input1;
				input1 = input2;
				input2 = temp;
			}
			for(int i = input1; i <= input2; i++) {
				System.out.print(i + " ");
			}
		
	}
}
	
	public void practice6(){
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자 : ");
		int input = sc.nextInt();
		
		// input < 2 || input > 9
		if(!(input >= 2 && input <= 9)) {
			System.out.print("2~9 사이 숫자만 입력해주세요.");
		} else {
			for ( int dan=input; dan<=9; dan++) {
				System.out.printf("===== %d단 ===== \n",dan);
				
				for(int i =1; i<=9;i++) {
					System.out.printf("%d * %d = %d \n",dan,i,dan*i);
				}
			}
		}
	}
}
