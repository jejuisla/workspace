package edu.kh.array.practice;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayPractice {

	public void practice1() {
		int[] arr = new int[9];
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			arr[i] = i+1;
			System.out.print(arr[i] + " ");
			if(i%2 == 0) {
				sum += arr[i];
			}
		}
		System.out.println();
		System.out.println("짝수 번째 인덱스 합 : " + sum);
	}
	
	public void practice2() {
		int[] arr2 = new int[9];
		int sum = 0;
			for(int i=0; i<arr2.length; i++) {
			arr2[i]=9-i;
			System.out.print(arr2[i] + " ");
			if(i%2 != 0) {
				sum += arr2[i];
			}	
		}
		System.out.println();
		System.out.println("홀수 번째 인덱스 합 : " + sum);
	}
	
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		System.out.print("인덱스를 입력하세요 : ");
		int input = sc.nextInt();
		int[] arr3 = new int[input];
		System.out.println("양의 정수 : " + input);
		for(int i=0; i<arr3.length; i++) {
			arr3[i] = i+1;
			System.out.print(arr3[i] + " ");
		}
	}
	
	public void practice4() {
		int[] arr4 = new int[5];
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 0 : ");
		int input = sc.nextInt();
		arr4[0] = input;
		
		System.out.print("입력 1 : ");
		int input1 = sc.nextInt();
		arr4[1] = input1;
		
		System.out.print("입력 2 : ");
		int input2 = sc.nextInt();
		arr4[2] = input2;
		
		System.out.print("입력 3 : ");
		int input3 = sc.nextInt();
		arr4[3] = input3;
		
		System.out.print("입력 4 : ");
		int input4 = sc.nextInt();
		arr4[4] = input4;
		
		System.out.println("검색할 값 : ");
		int select = sc.nextInt();
		
		boolean flag = true;
		for(int i=0;i<arr4.length;i++) {
			if(arr4[i] == select) {
				System.out.println("인덱스 : " + i);
				flag = false;
			}
		}
		if(flag) {
			System.out.println("일치하는 값이 존재하지 않습니다.");
		}
	}
	
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("문자열 : ");
		String str = sc.next();
		System.out.println("문자 : ");
		char ch1 = sc.next().charAt(0);

		char[] ch = new char[str.length()];
		System.out.printf("%s에 %c가 존재하는 위치(인덱스) : \n", str,ch1);
		
		int count =0;
		
		for(int i=0; i<str.length(); i++) {
			ch[i] = str.charAt(i);
			if(ch1 == ch[i]) {
				System.out.print(i + " ");
				count++;
			}
		}
		System.out.println();
		System.out.printf("%s의 개수 : %d", ch1, count);
	}
	
	public void practice6() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		int[] arr6 = new int[input];
		int sum = 0;
		
		for(int i=0; i<input; i++) {
			System.out.printf("배열 %d번째 인덱스 넣을 값 : ",i);
			int input1 = sc.nextInt();
			arr6[i] = input1;
		}
		for(int i=0; i<input; i++) {
			System.out.print(arr6[i] + " ");
			sum += arr6[i];
		}
		
		System.out.print("\n총 합 : " + sum);
	}
	
	public void practice7() {
		Scanner sc = new Scanner(System.in);
		System.out.print("주민등록번호(-포함) : ");
		String number = sc.next();
	
		char[] ch1 = new char[14];
			for(int i = 0; i<ch1.length; i++) {
				if(i<8) {
					ch1[i] = number.charAt(i);
				}else {
					ch1[i] = '*';
				}
				
				
			}
			System.out.print(ch1);
	}
	
	public void practice8() {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int input = sc.nextInt();
		
		if(input%2 == 0 || input<3) {
			System.out.println("다시 입력하세요.");
		} else {
			for(int i=1; i<=input/2 + 1; i++) {
				System.out.print(i + " ");
			}
			for(int r=input/2; r>0;r--) {
				System.out.print(r + " ");
			}
		}
	}
	
	public void practice9() {
		int[] arr = new int[10];
		System.out.print("발생한 난수 : ");
		for(int i=0;i<10;i++) {
			int random = (int)(Math.random() * 10 + 1);
			arr[i] = random;
			System.out.print(arr[i] + " ");
		}
	}
	
	public void practice10() {
		int[] arr = new int[10];
		int max = 0;
		int min = 10;
		System.out.print("발생한 난수 : ");
		for(int i=0;i<10;i++) {
			int random = (int)(Math.random() * 10 + 1);
			arr[i] = random;
			System.out.print(arr[i] + " ");
			if(max<arr[i]) {
				max = arr[i];
			}
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		System.out.println();
		System.out.println("최대값 : " + max);
		System.out.println("최값 : " + min);
	}
	
	public void practice11() {
		int[] arr = new int[10];
		int same = 0;
		int r =0;
		for(int i=0;i<arr.length;i++) {
			int random = (int)(Math.random() * 10 + 1);
			arr[i] = random;
			for(int j=0; j<i; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
			arr[i] = arr[r];
			r++;
		}
		System.out.println(arr[r] + " ");
	}
	
	public void practice12() {
		
	}
	
	public void practice13() {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자열 : ");
		String str = sc.next();
	}
	
	public void practice14() {
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 입력하세요 : ");
		int size = sc.nextInt();
		String[] arr2 = new String[size];
		
		for(int i=0; i<arr2.length; i++) {
			System.out.printf("%d번째 문자열 : ",i+1);
			String str = sc.next();
			arr2[i] = str;
		}
		System.out.print("더 값을 입력하시겠습니까 (y/n) : ");
		char ch1 = sc.next().charAt(0);
		
		while(ch1 == 'y') {
			System.out.println("더 입력하고 싶은 개수 : ");
			int add = sc.nextInt();
//			String[] arr2 = new String[size+add];
			for(int j=arr2.length; j<arr2.length+add; j++) {
				System.out.printf("%d번째 문자열 : ",j);
				String str2 = sc.next();
				arr2[j] = str2;
			}
		}
		if(ch1 == 'n') {
			System.out.println(Arrays.toString(arr2));
		}
	}
	
	public void practice15() {
		String[][] str = new String[3][3];
		for(int i=0; i<str.length; i++) {
			for(int j=0; j<str[i].length; j++) {			
				System.out.printf("(%d,%d) ",i,j);
			}
			System.out.println();
		}
	}
	
	public void practice16() {
		int[][] arr = new int[4][4];
		int r = 0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				r++;
				arr[i][j] = r;
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void practice17() {
		int[][] arr = new int[4][4];
		int r = 16;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = r;
				System.out.print(arr[i][j] + " ");
				r--;
			}
			System.out.println();
		}
	}
}