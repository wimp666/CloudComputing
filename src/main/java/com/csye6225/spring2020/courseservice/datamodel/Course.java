package com.csye6225.spring2020.courseservice.datamodel;

import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlRootElement;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIgnore;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

public class Course {
	private String apId;
	private String TAId;
	private String courseName;
	private String courseId;
	private String courseBoard;
	private ArrayList<String> courseRoster;
	private HashMap<String, Student> courseStu;
	
	public Course() {}
	
	public Course(String courseName, String courseId, String courseBoard){
		this.courseRoster = new ArrayList<>();
		this.courseStu = new HashMap<>();
		this.courseName = courseName;
		this.courseId = courseId;
		this.courseBoard = courseBoard;
		this.apId = "";
		this.TAId = "";
	}
	
	public String getCourseName() {
		return courseName;
	}
	public String getApId() {
		return apId;
	}
	public String getTAId() {
		return TAId;
	}
	public String getCourseId() {
		return courseId;
	}
	public String getCourseBoard() {
		return courseBoard;
	}
	public ArrayList<String> getCourseRoster() {
		return courseRoster;
	}
	public HashMap<String, Student> getCourseStu() {
		return courseStu;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public void setTAId(String TAId) {
		this.TAId = TAId;
	}
	public void setApId(String apId) {
		this.apId = apId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public void setCourseBoard(String courseBoard) {
		this.courseBoard = courseBoard;
	}
	public void setCourseRoster(ArrayList<String> courseRoster) {
		this.courseRoster = courseRoster;
	}
	public void setCourseStu(HashMap<String, Student> courseStu) {
		this.courseStu = courseStu;
	}
	
	@Override
	public String toString() {
		return "CourseId=" + getCourseId() + ", CourseName=" + getCourseName()
		+ ", ApId=" + getApId() + ", TAId=" + getTAId();
	}
}


