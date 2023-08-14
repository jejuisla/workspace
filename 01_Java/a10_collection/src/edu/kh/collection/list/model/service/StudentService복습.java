package edu.kh.collection.list.model.service;

import java.util.ArrayList;
import java.util.List;

import edu.kh.collection.list.model.dto.Student;

public class StudentService복습 {

	private List<Student> studentList = new ArrayList<Student>();
	
	public StudentService복습() {
		studentList.add(new Student(3,5,17,"홍길동",'M',75));
		studentList.add(new Student(1,5,17,"갑을병",'M',65));
		studentList.add(new Student(2,5,17,"고길순",'M',55));
	}
	
	
	
	}
