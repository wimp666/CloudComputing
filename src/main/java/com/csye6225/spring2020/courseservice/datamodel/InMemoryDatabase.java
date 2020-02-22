package com.csye6225.spring2020.courseservice.datamodel;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class InMemoryDatabase {

	private static HashMap<String, Professor> professorDB = new HashMap<> ();
	private static HashMap<String, Student> studentDB = new HashMap<> ();
	private static HashMap<String, Program> programDB = new HashMap<> ();
	private static HashMap<String, Course> courseDB = new HashMap<> ();
	private static HashMap<String, Lecture> lectureDB = new HashMap<> ();
	
	public static HashMap<String, Program> getProgramDB(){
		programDB.put("001", new Program("001","Royal Navy"));
		return programDB;
	}
	public static HashMap<String, Lecture> getLectureDB(){
		lectureDB.put("week1", new Lecture("week1"));
		return lectureDB;
	}
	

	public static HashMap<String, Professor> getProfessorDB() {
		professorDB.put("KelK", new Professor("Kelsey", "k", "coop","20200802"));
		professorDB.put("AshA", new Professor("Ashshi", "A", "Algorithm","20200803"));
		return professorDB;
	}
	
	public static HashMap<String, Course> getCourseDB(){
		courseDB.put("CSYE6225", new Course("Cloud Computing", "CSYE6225","Welcome to CSYE6225"));
		return courseDB;
	}
	
	public static HashMap<String, Student> getStudentDB() {
		studentDB.put("HMSHood", new Student("HMS", "Hood", "HMSHood","Url1",programDB.get("001")));
		return studentDB;
	}
}