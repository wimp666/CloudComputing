package com.csye6225.spring2020.courseservice.resources;

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

import com.csye6225.spring2020.courseservice.datamodel.Course;
import com.csye6225.spring2020.courseservice.datamodel.Program;
import com.csye6225.spring2020.courseservice.service.ProgramService;

@Path("program")
public class ProgramResource {
	ProgramService progService = new ProgramService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Program> getPrograms() {
		return progService.getAllPrograms();
	}
	@GET
	@Path("/courses/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getCoursesOfProgram(@PathParam("programId") String programId) {
		return progService.getCourseOfProgram(programId);
	}	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{programId}")
	public Program getProgram(@PathParam("programId") String programId) {
		System.out.println("Program Resource: Looking for: " + programId);
		return progService.getProgram(programId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program addProgram(Program prog) {
		return progService.addProgram(prog);
	}
	@PUT
	@Path("/course/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Course> addCourse(String courseId, @PathParam("programId") String programId) {
		return progService.addCourse(courseId, programId);
	}
	
	@DELETE
	@Path("/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Program deleteProgram(@PathParam("programId") String programId) {
		return progService.deleteProgram(programId);
	}
	
	@PUT
	@Path("/{programId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Program updateProgram(@PathParam("programId") String programId, 
			Program prog) {
		return progService.updateProgramInformation(programId, prog);
	}
}
