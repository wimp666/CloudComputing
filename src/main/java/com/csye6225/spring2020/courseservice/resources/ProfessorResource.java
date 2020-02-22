package com.csye6225.spring2020.courseservice.resources;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.spring2020.courseservice.datamodel.Professor;
import com.csye6225.spring2020.courseservice.service.ProfessorService;

// .. /webapi/professors
@Path("professor")
public class ProfessorResource {

	ProfessorService profService = new ProfessorService();
	
	//@GET
	//@Produces(MediaType.APPLICATION_JSON)
	//@Consumes(MediaType.APPLICATION_JSON)
	//public List<Professor> getProfessors() {
	//	return profService.getAllProfessors();
	//}	
	
	//...webapi/professor/getByDepartment?department=coop
	@GET
	//@Path("/getByDepartment")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Professor> getProfessorsByDeparment(@QueryParam("department") String department) {
		if (department == null) {
			return profService.getAllProfessors();
		}
		return profService.getProfessorsByDepartment(department);
		
	}
	
	
	//...webapi/professor/1 
	@GET
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Professor getProfessor(@PathParam("professorId") String profId) {
		System.out.println("Professor Resource: Looking for: " + profId);
		return profService.getProfessor(profId);
	}
	
	@DELETE
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Professor deleteProfessor(@PathParam("professorId") String profId) {
		return profService.deleteProfessor(profId);
	}
	
	@POST
	//@Path("/post")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	/*
	public Professor addProfessor(Professor prof) {
		prof.setProfessorId(prof.getFirstName()+prof.getLastName());
		prof.setJoiningDate(new Date().toString());
		//prof.setId(prof.getProfessorId());
		return profService.addProfessor(prof);
	}
	*/
	
	public Professor addProfessor(Professor prof) {
		prof.setProfessorId(prof.getFirstName()+prof.getLastName());
		prof.setJoiningDate(new Date().toString());
		return profService.addProfessor(prof);
	}
	
	@PUT
	@Path("/{professorId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Professor updateProfessor(@PathParam("professorId") String professorId, 
			Professor prof) {
		return profService.updateProfessorInformation(professorId, prof);
	}
	
	//public void addProfessor(String firstName, String lastName, String department, Date joiningDate) {
	//	profService.addProfessor(firstName, lastName, department, joiningDate.toString());
	//}
 }