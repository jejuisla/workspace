package edu.kh.thread.ex4;

import java.util.Random;

public class RaceHeart implements Runnable{
	@Override
	public void run() {
		
		 Random ran = new Random(); // 난수 생성 객체
		 
		 try {
			 for(int i=0; i<=10; i++) {
				 // 콘솔창 클리어
				 RaceRun.clear();
				 
				 if(i==0) { // 첫번째 반복일 때
					 System.out.println("준비");
					 System.out.println("❤");
					 System.out.print("★");
					 
					 Thread.sleep(1000);
					 
					 continue; // 다음 반복으로 이동
				 }
				 System.out.println(i + "회차");
				 
				 // temp || tmp == 임시 변수
				 int temp = ran.nextInt(5)+1; // 1,2,3,4,5 중 하나 발생
				 
				 // 생성된 난수를 heartCount에 누적
				 RaceRun.heartCount += temp;
				 
				 System.out.println("❤ " + temp + "칸 이동");
				 // heartCount 누적된 숫자만큼 - 표시 후 하트 출력
				 for(int h=0; h<RaceRun.heartCount; h++) {
					 System.out.print("-");
				 }
				 System.out.println("❤");
				 
				 for(int s=0; s<RaceRun.starCount; s++) {
					 System.out.print("-");
				 }
				 System.out.print("★");
				 
				 
				 Thread.sleep(1000); // 1초 일시 정지 -> 항상 for문 제일 밑에
			 }
		 } catch(InterruptedException e) {
			 Thread.currentThread().interrupt();
		 }
	}
}
