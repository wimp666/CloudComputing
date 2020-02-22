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

import com.csye6225.spring2020.courseservice.datamodel.Program;
import com.csye6225.spring2020.courseservice.datamodel.Student;
import com.csye6225.spring2020.courseservice.service.ProgramService;
import com.csye6225.spring2020.courseservice.service.StudentService;

@Path("student")
public class StudentResource {
	StudentService stuService = new StudentService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStudents() {
		return stuService.getAllStudents();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{studentId}")
	public Student getStudent(@PathParam("studentId") String studentId) {
		System.out.println("Program Resource: Looking for: " + studentId);
		return stuService.getStudent(studentId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student addStudent(Student stu) {
		return stuService.addStudent(stu);
	}
	
	@DELETE
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student deleteStudent(@PathParam("studentId") String studentId) {
		return stuService.deleteStudent(studentId);
	}
	
	@PUT
	@Path("/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Student updateStudent(@PathParam("studentId") String studentId, 
			Student stu) {
		return stuService.updateStudentInformation(studentId, stu);
	}
}
