package edu.kh.oop.calc;

import java.util.Scanner;

public class Calc복습View {

	public Calc복습 calc = new Calc복습();
	Scanner sc = new Scanner(System.in);
	
	public void displayMenu() {
		int input = 0;
		do {
			System.out.println("\n-------------------------------");
			System.out.println("현재 값 : " + calc.getSaveValue());
			System.out.println("-------------------------------\n");
			
			System.out.println("1. 더하기(+)");
			System.out.println("2. 빼기(-)");
			System.out.println("3. 곱하기(*)");
			System.out.println("4. 나누기(/)");
			System.out.println("5. 초기화(c)");
			
			System.out.println("6. 최대값으로 변경");
			System.out.println("7. 최소값으로 변경");
			System.out.println("8. 원의 넓이 구하기");

			System.out.println("0. 종료");
			
			System.out.println("메뉴 선택 : ");
			input = sc.nextInt();
			
			switch(input) {
			case 1: System.out.println(plus());      break; 
			case 2: System.out.println(minus());     break; 
			case 3: System.out.println(multi());     break; 
			case 4: System.out.println(div());     break; 
//			case 5: System.out.println("초기화 : " + calc.init());	break;
//			case 6: System.out.println("최대값으로 변경 : " + calc.changeMaxValue());	break;
//			case 7:	System.out.println("최소값으로 변경 : " + calc.changeMinValue());	break;
//			case 8:	System.out.println(theAreaOfACircle());	break;
			case 0: System.out.println("계산기 종료");     break; 
			default : System.out.println("잘못 입력");
			}
		} while(input != 0);
		// input이 0이 아닐때 까지 do{ }문 반복
	}
	
	
	private String plus() {
		System.out.println("더할 값 : ");
		double num = sc.nextDouble();
		
		double saveValue = calc.getSaveValue();
		double result = calc.plus(num);
		
		String str = String.format("%.1f + %.1f = %.1f", saveValue, num, result);
		return str;
	}
	
	private String minus() {
		System.out.print("뺄 값을 입력해주세요 : ");
		double number = sc.nextDouble(); // 입력 값
		
		double saveValue = calc.getSaveValue(); // 기존 값
		double result = calc.minus(number); // 연산 결과
		
		String str = String.format("%.2f - %.2f = %.2f \n", saveValue, number, result);
		return str;
	}
	
	private String multi() {
		System.out.println("곱할 값을 입력해주세요 : ");
		double number = sc.nextDouble();
		
		double saveValue = calc.getSaveValue();
		double result = calc.multi(number);
		
		String str = String.format("%.2f * %.2f = %.2f \n", saveValue, number, result);
		return str;
	}
	
	private String div() {
		System.out.println("나눌 값을 입력해주세요 : ");
		double number = sc.nextDouble();
		
		double saveValue = calc.getSaveValue();
		double result = calc.div(number);
		
		String str = String.format("%.2f / %.2f = %.2f \n", saveValue, number, result);
		return str;
	}
	
	
	
	
}
