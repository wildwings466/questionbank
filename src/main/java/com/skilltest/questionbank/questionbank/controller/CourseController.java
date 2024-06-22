package com.skilltest.questionbank.questionbank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilltest.questionbank.questionbank.model.Course;
import com.skilltest.questionbank.questionbank.service.CourseService;

@RestController
@RequestMapping("api/courses")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
	@Autowired
	private CourseService courseService;

	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Course> getCourses() {
		return courseService.getCourses();
	}

	@GetMapping("/name/{name}")
	public Course getCourseByName(@PathVariable(value = "name") String name) {
		return courseService.getCourseByName(name);
	}

	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public Long createCourse(@RequestBody Course course) {
		return courseService.createCourse(course);
	}

}
