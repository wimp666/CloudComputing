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

public class ProfessorService {
	
	static HashMap<String, Professor> prof_Map = InMemoryDatabase.getProfessorDB();
	
	public ProfessorService() {
	}
	
	// Getting a list of all professor 
	// GET "..webapi/professor"
	public List<Professor> getAllProfessors() {	
		//Getting the list
		ArrayList<Professor> list = new ArrayList<>();
		for (Professor prof : prof_Map.values()) {
			list.add(prof);
		}
		return list ;
	}

	// Adding a professor
	//public void addProfessor(String firstName, String lastName, String department, String joiningDate) {
		// Next Id 
		//Integer nextAvailableId = prof_Map.size() + 1;
		
		//Create a Professor Object
		//Professor prof = new Professor(firstName+lastName, firstName , lastName, 
				//department, joiningDate);
		
		//prof_Map.put(nextAvailableId, prof);
	//}	
	public Professor addProfessor(Professor prof) {
		//addProfessor(prof.getFirstName(), prof.getLastName(), prof.getDepartment(), prof.getJoiningDate());
		prof_Map.put(prof.getProfessorId(), prof);
		return prof;
	}
	
	// Getting One Professor
	public Professor getProfessor(String profId) {
		
		 //Simple HashKey Load
		 Professor prof2 = prof_Map.get(profId);
	     System.out.println("Item retrieved:");
	     System.out.println(prof2.toString());
		
		return prof2;
	}
	
	// Deleting a professor
	public Professor deleteProfessor(String profId) {
		Professor deletedProfDetails = prof_Map.get(profId);
		prof_Map.remove(profId);
		return deletedProfDetails;
	}
	
	// Updating Professor Info
	public Professor updateProfessorInformation(String profId, Professor prof) {	
		//Professor oldProfObject = prof_Map.get(profId);
		//profId = oldProfObject.getProfessorId();
		//prof.setProfessorId(profId);
		prof_Map.put(profId,prof);
		return prof;
	}
	
	// Get professors in a department 
	public List<Professor> getProfessorsByDepartment(String department) {	
		//Getting the list
		ArrayList<Professor> list = new ArrayList<>();
		for (Professor prof : prof_Map.values()) {
			if (prof.getDepartment().equals(department)) {
				list.add(prof);
			}
		}
		return list ;
	}
	
	// Get professors for a year with a size limit
	
}


