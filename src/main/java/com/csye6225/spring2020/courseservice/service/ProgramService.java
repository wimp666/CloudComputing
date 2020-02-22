package com.csye6225.spring2020.courseservice.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.PaginatedQueryList;
import com.csye6225.spring2020.courseservice.datamodel.Course;
import com.csye6225.spring2020.courseservice.datamodel.DynamoDbConnector;
import com.csye6225.spring2020.courseservice.datamodel.InMemoryDatabase;
import com.csye6225.spring2020.courseservice.datamodel.Program;

public class ProgramService {
	static HashMap<String, Program> program_Map = InMemoryDatabase.getProgramDB();
	
	public ProgramService() {
		
	}
	
	public List<Program> getAllPrograms() {	
		ArrayList<Program> list = new ArrayList<>();
		for (Program prog : program_Map.values()) {
			list.add(prog);
		}
		return list ;
	}
	public Program addProgram(Program prog) {
		program_Map.put(prog.getProgramId(), prog);
		return prog;
	}
	public Program getProgram(String programId) {
		Program prog = program_Map.get(programId);
	    System.out.println("Item retrieved:");
	    System.out.println(prog.toString());	
		return prog;
	}
	public List<Course> getCourseOfProgram(String programId){
		Program prog = program_Map.get(programId);
		return prog.getCourseList();
	}
	public List<Course> addCourse(String courseId, String programId){
		Program prog = program_Map.get(programId);
		prog.addCourse(InMemoryDatabase.getCourseDB().get(courseId));
		return prog.getCourseList();
	}
	public Program deleteProgram(String programId) {
		Program deletedProgDetails = program_Map.get(programId);
		program_Map.remove(programId);
		return deletedProgDetails;
	}
	public Program updateProgramInformation(String programId, Program prog) {	
		program_Map.put(programId,prog);
		return prog;
	}
}
