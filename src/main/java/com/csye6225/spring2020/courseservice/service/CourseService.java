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
import com.csye6225.spring2020.courseservice.datamodel.Professor;
import com.csye6225.spring2020.courseservice.datamodel.Program;
import com.csye6225.spring2020.courseservice.datamodel.Student;
import com.csye6225.spring2020.courseservice.datamodel.Course;

public class CourseService {
	static HashMap<String, Course> course_Map = InMemoryDatabase.getCourseDB();
	
	public List<Course> getAllCourses() {	
		ArrayList<Course> list = new ArrayList<>();
		for (Course course : course_Map.values()) {
			list.add(course);
		}
		return list ;
	}
	public Course getCourse(String courseId) {
		Course course = course_Map.get(courseId);
	    System.out.println("Item retrieved:");
	    System.out.println(course.toString());	
		return course;
	}
	public ArrayList<String> getCourseStudent(String courseId){
		Course course = course_Map.get(courseId);
		return course.getCourseRoster();
	}
	public Course addCourse(Course course) {
		course_Map.put(course.getCourseId(), course);
		return course;
	}
	public Student addStudent(String stuId, String courseId) {
		Course course = course_Map.get(courseId);
		HashMap<String, Student> courseStu = course.getCourseStu();
		ArrayList<String> courseRoster = course.getCourseRoster();
		Student stu = InMemoryDatabase.getStudentDB().get(stuId);
		courseStu.put(stuId, stu);
		courseRoster.add(stuId);
		course.setCourseRoster(courseRoster);
		course.setCourseStu(courseStu);
		return stu;
	}
	public Course deleteCourse(String courseId) {
		Course deletedCourseDetails = course_Map.get(courseId);
		course_Map.remove(courseId);
		return deletedCourseDetails;
	}
	public ArrayList<String> deleteStudent(String courseId, String stuId){
		Course course = course_Map.get(courseId);
		ArrayList<String> tempList = course.getCourseRoster();
		HashMap<String, Student> tempMap = course.getCourseStu();
		tempList.remove(stuId);
		tempMap.remove(stuId);
		course.setCourseRoster(tempList);
		course.setCourseStu(tempMap);
		return tempList;
	}
	public String setTA(String courseId, Student TA) {
		Course course = course_Map.get(courseId);
		course.setTAId(TA.getStudentId());
		return TA.toString();
	}
	public String setAp(String courseId, Professor ap) {
		Course course = course_Map.get(courseId);
		course.setTAId(ap.getProfessorId());
		return ap.toString();
	}
	public String setBoard(String courseId, String board) {
		Course course = course_Map.get(courseId);
		course.setCourseBoard(board);
		return board;
	}
	public Course updateCourseInformation(String courseId, Course course) {	
		course_Map.put(courseId,course);
		return course;
	}
}
