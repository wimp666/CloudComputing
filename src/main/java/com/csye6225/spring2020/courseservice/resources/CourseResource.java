package com.csye6225.spring2020.courseservice.resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
//import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.csye6225.spring2020.courseservice.datamodel.Course;
import com.csye6225.spring2020.courseservice.datamodel.Program;
import com.csye6225.spring2020.courseservice.datamodel.Student;
import com.csye6225.spring2020.courseservice.service.CourseService;
import com.csye6225.spring2020.courseservice.service.ProgramService;

@Path("course")
public class CourseResource {
	CourseService courseService = new CourseService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Course> getCourses() {
		return courseService.getAllCourses();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{courseId}")
	public Course getCourse(@PathParam("courseId") String courseId) {
		System.out.println("Course Resource: Looking for: " + courseId);
		return courseService.getCourse(courseId);
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/student/{courseId}")
	public ArrayList<String> getCourseStudent(@PathParam("courseId") String courseId) {
		return courseService.getCourseStudent(courseId);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course addCourse(Course course) {
		return courseService.addCourse(course);
	}
	@DELETE
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Course deleteCourse(@PathParam("courseId") String courseId) {
		return courseService.deleteCourse(courseId);
	}
	@PUT
	@Path("/student/add/{courseId}/{stuId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student addStudent(@PathParam("courseId") String courseId, @PathParam("stuId")String stuId) {
		return courseService.addStudent(stuId, courseId);
	}
	@PUT
	@Path("/student/delete/{courseId}/{stuId}")
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<String> deleteStudent(@PathParam("courseId") String courseId, @PathParam("stuId")String stuId) {
		return courseService.deleteStudent(courseId, stuId);
	}
	@PUT
	@Path("/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Course updateCourse(@PathParam("courseId") String courseId, 
			Course course) {
		return courseService.updateCourseInformation(courseId, course);
	}
}
