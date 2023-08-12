package edu.kh.oarr.model.service;

import java.util.Random;

import edu.kh.oarr.model.dto.Student복습;

public class StudentService복습 {

	private Student복습[] studentArr = new Student복습[10];
	
	public StudentService복습() {

		studentArr[0] = new Student복습(1, 2, 3, "홍길동");
		studentArr[1] = new Student복습(3, 6, 19, "박철수");
		studentArr[2] = new Student복습(2, 5, 7, "최미영");
		
		Random random = new Random();
		
		for(int i=0; i<studentArr.length; i++) {
			if(studentArr[i] == null) {
				break;
			}
			studentArr[i].setKor(random.nextInt(101));
			studentArr[i].setEng(random.nextInt(101));
			studentArr[i].setMath(random.nextInt(101));
		}
	}

	public boolean addStudent(int grade, int ban, int number, String name) {
		
		for(int i=0; i<studentArr.length; i++) {
			if(studentArr[i] == null) {
				studentArr[i] = new Student복습(grade, ban, number, name);
			}
		return true;
		}
		return false;
	
	}

	public Student복습[] selectAll() {
		return studentArr;
	}

	public Student복습 selectIndex(int input) {
		
		if( input<0 || input>=studentArr.length 
				|| studentArr[input] == null) {
			return null;
		}
		return studentArr[input];
	}

	public Student복습[] selectName(String name) {
		
		int count = 0;
		for( Student복습 s : studentArr) {
			
			if(s==null) break;
			if(s.getName().equals(name)) count++;
		}
		if(count==0) return null;
		
		Student복습[] arr = new Student복습[count];
		
		
		for( Student복습 s : studentArr) {
				
			int index = 0;
			if(s==null) break;
			if(s.getName().equals(name)) {
				studentArr[index] = s;
				index++;
			}
		}
		return arr;
	
	}


	public void updateStudent(Student복습 s, int kor, int eng, int math) {
		s.setKor(kor);
		s.setEng(eng);
		s.setMath(math);
	}


}
