package com.csye6225.spring2020.courseservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.csye6225.spring2020.courseservice.datamodel.DynamoDbConnector;
import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Student;

public class StudentService {
	static HashMap<String, Student> stu_Map = InMemoryDatabase.getStudentDB();
	
	public List<Student> getAllStudents() {	
		ArrayList<Student> list = new ArrayList<>();
		for (Student stu : stu_Map.values()) {
			list.add(stu);
		}
		return list ;
	}
	public Student addStudent(Student stu) {
		stu_Map.put(stu.getStudentId(), stu);
		return stu;
	}
	public Student getStudent(String studentId) {
		Student stu = stu_Map.get(studentId);
	    System.out.println("Item retrieved:");
	    System.out.println(stu.toString());	
		return stu;
	}
	public Student deleteStudent(String studentId) {
		Student deletedStuDetails = stu_Map.get(studentId);
		stu_Map.remove(studentId);
		return deletedStuDetails;
	}
	public Student updateStudentInformation(String studentId, Student stu) {	
		stu_Map.put(studentId,stu);
		return stu;
	}
}
