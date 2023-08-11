package edu.kh.array.ex;

import java.util.Scanner;
import java.util.Arrays;

public class array복습 {
	
	public void ex1() {
		Scanner sc = new Scanner(System.in);
		double[] heightArray = new double[3];
		
		double sum = 0;
		
		for(int i=0; i<3; i++) {
			System.out.print(i + "번 키 입력 : ");
			heightArray[i] = sc.nextDouble();
		}
		
		for(int r=0; r<heightArray.length;r++) {
			System.out.printf("%d번째 키 : %.1f \n", r, heightArray[r]);
			sum += heightArray[r];
		}
		System.out.println(sum/3.0);
	}
	
	
	/* 생성할 배열의 길이 : 3
	 * 
	 * 0번 인덱스 요소 : 40
	 * 1번 인덱스 요소 : 60
	 * 2번 인덱스 요소 : 80
	 * 
	 * 저장된 값을 확인하려는 인덱스(-1 종료) : 0
	 * 0번 인덱스 : 40

	 * 저장된 값을 확인하려는 인덱스(-1 종료) : 2
	 * 2번 인덱스 : 80
	 * 
	 * 저장된 값을 확인하려는 인덱스(-1 종료) : 99
	 * 존재하지 않는 인덱스 번호입니다
	 * 
	 * 저장된 값을 확인하려는 인덱스(-1 종료) : -1
	 * 프로그램 종료
	 */
	
	public void ex2() {
		Scanner sc = new Scanner(System.in);
		System.out.print("생성할 배열의 길이 : ");
		int input = sc.nextInt();
		
		int[] nums = new int[input];
		
		for(int i=0; i<input; i++) {
			System.out.printf("%d번 인덱스 요소 : ", i);
			nums[i] = sc.nextInt();
		}
		
		
		while(true) {
			System.out.print("저장된 값을 확인하려는 인덱스(-1종료) : ");
			int check = sc.nextInt();
			
			if(check == -1) {
				System.out.println("프로그램 종료");
				break;
			}
			if(check<0 || check>=input) {
				System.out.println("존재하지 않는 인덱스 번호입니다.");
				continue;
			}
			System.out.printf("%d번 인덱스 : %d \n", check,nums[check]);
		}
		
	}
	
	
	public void ex3() {
		
		char[][] arr = {{'a','s','d'},{'z','x','c'},{'f','g','h'}};
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("알파벳 입력 : ");
		char input = sc.next().charAt(0);
		
		boolean flag = false;
		
		for(int r=0; r<arr.length; r++) {
			for(int c=0; c<arr[r].length;c++) {
				if(arr[r][c] == input) {
					System.out.printf("%c = %d행 %d열에 있습니다 \n", input, r,c);
					flag = true;
				}
			}
		}
		if(!flag) System.out.println("해당하는 알파벳은 없습니다.");
	}
}
