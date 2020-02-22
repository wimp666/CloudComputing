package com.csye6225.spring2020.courseservice.datamodel;

public class Lecture {
	private String lecName;
	private String lecNote;
	private String lecMaterial;
	
	public Lecture() {
		
	}
	public Lecture(String lecName) {
		this.lecName = lecName;
	}
	public String getLecName() {
		return lecName;
	}
	public String getLecNote() {
		return lecNote;
	}
	public String getLecMaterial() {
		return lecMaterial;
	}
	public void setLecName(String lecName) {
		this.lecName = lecName;
	}
	public void setLecNote(String lecNote) {
		this.lecNote = lecNote;
	}
	public void setLecMaterial(String lecMaterial) {
		this.lecMaterial = lecMaterial;
	}
}
