package edu.kh.operator.practice;

import java.util.Scanner;

public class Practice1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("[실행화면]");
		
		System.out.print("인원 수 : ");
		int input1 = sc.nextInt();
		System.out.print("사탕 개수 : ");
		int input2 = sc.nextInt();
		
		System.out.println();
		int result1 = input2 / input1;
		System.out.println("1인당 사탕 개수 : " + result1);
		
		int result2 = input2 % input1;
		System.out.print("1인당 사탕 개수 : " + result2);
	}
}
