package edu.kh.control.condition.practice;

import java.util.Scanner;

public class ConditionPractice {

	// 실습문제 1
	public void practice1() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 한 개 입력하세요 : ");
		int num = sc.nextInt();
		
		String result;
		if(num <= 0) {
			result = "양수만 입력해주세요.";
		} else if(num % 2 == 0) {
			result = "짝수입니다.";
		} else {
			result = "홀수입니다.";
		}
		System.out.println(result);
	}
	
	
	// 실습문제 2
	public void practice2() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("국어점수 : ");
		int kor = sc.nextInt();
		System.out.print("수학점수 : ");
		int math = sc.nextInt();
		System.out.print("영어점수 : ");
		int eng = sc.nextInt();
		
		// 합계
		int sum = kor + math + eng;
		// 평균
		double avg = sum / 3.0;
		if(kor >= 40 && math >= 40 && eng >= 40 && avg >= 60) {
			System.out.println("국어 : " + kor);
			System.out.println("수학 : " + math);
			System.out.println("영어 : " + eng);
			System.out.println("합계 : " + sum);
			System.out.println("평균 : " + avg);
			System.out.println("축하합니다, 합격입니다!");
		} else {
			System.out.println("불합격입니다.");
		}
	}
	
	
	// 실습문제 3
	public void practice3() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("1~12 사이의 정수 입력 : ");
		int month = sc.nextInt();
		
		int day;
		switch(month){
			case 1 : case 3: case 5: case 7 : case 8 : case 10 : case 12 :
				day = 31; break;
			case 4 : case 6: case 9: case 11:
				day = 30; break;
			case 2 : day = 28; break; 
			default : day = -1; break;
		}
		if(day != -1) { // 1~12 사이가 입력 되었을 때
			System.out.printf("%d월은 %d일까지 있습니다.", month, day);
		} else { // 1~12 사이가 입력되지 않았을 때
			System.out.printf("%d월은 잘못 입력된 달입니다.", month);
		}
	}
	
	
	// 실습문제 4
	public void practice4() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("키(m)를 입력해 주세요. : ");
		double height = sc.nextDouble();
		System.out.print("몸무게(kg)를 입력해 주세요. : ");
		double weight = sc.nextDouble();
		
		double bmi = weight / (height * height);
		String result;
		if(bmi < 18.5) {
			result = "저체중";
		} else if(bmi < 23) {
			result = "정상체중";
		} else if(bmi < 25) {
			result = "과체중";
		} else if(bmi < 30) {
			result = "비만";
		} else {
			result = "고도 비만";
		}
		System.out.println("BMI 지수 : " + bmi);
		System.out.println(result);
	}
	
	
	// 실습문제 5
	public void practice5() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("중간 고사 점수 : ");
		int mid = sc.nextInt();
		System.out.print("기말 고사 점수 : ");
		int fin = sc.nextInt();
		System.out.print("과제 점수 : ");
		int sub = sc.nextInt();
		System.out.print("출석 점수 : ");
		int check = sc.nextInt();
		System.out.println("=========== 결과 ============");
		double result1 = mid / 5;
		double result2 = fin * 0.3;
		double result3 = sub * 0.3;
		double result4 = check; // == check * 5 * 0.2
		double result5 = result1 + result2 + result3 + result4;
		
		if((20 - check) >= 6) { // 출석 횟수가 부족한 경우
			System.out.printf("Fail [출석 횟수 부족 (%d/20)]", check);
		} else if(result5 < 70) { // 출석은 잘했을 때
			System.out.printf("중간 고사 점수(20) : %.1f \n", result1);
			System.out.printf("기말 고사 점수(30) : %.1f \n", result2);
			System.out.printf("과제 점수(30) : %.1f \n", result3);
			System.out.printf("출석 점수(20) : %.1f \n", result4);
			System.out.println("총점 : " + result5);
			System.out.println("Fail [점수 미달]");
		} else {
			System.out.printf("중간 고사 점수(20) : %.1f \n", result1);
			System.out.printf("기말 고사 점수(30) : %.1f \n", result2);
			System.out.printf("과제 점수(30) : %.1f \n", result3);
			System.out.printf("출석 점수(20) : %.1f \n", result4);
			System.out.println("총점 : " + result5);
			System.out.println("PASS");
		}
	}
}
