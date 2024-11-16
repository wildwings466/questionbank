package com.skilltest.questionbank.questionbank.controller;

import com.skilltest.questionbank.questionbank.model.Course;
import com.skilltest.questionbank.questionbank.model.entities.CourseDetailProjection;
import com.skilltest.questionbank.questionbank.model.entities.CourseProjection;
import com.skilltest.questionbank.questionbank.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/courses")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class CourseController {

	private final CourseService courseService;

	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<CourseProjection> getCourses() {
		return courseService.getCourses();
	}

	@GetMapping("/courseType/{course-type}")
	public List<CourseProjection> getCoursesByCourseType(@PathVariable(value = "course-type") String courseType) {
		return courseService.getCoursesByCourseType(courseType);
	}

	@GetMapping("/name/{name}")
	public CourseDetailProjection getCourseByName(@PathVariable(value = "name") String name) {
		return courseService.getCourseByName(name);
	}

	@GetMapping("/{course-id}")
	public CourseDetailProjection getCourseById(@PathVariable(value = "course-id") Long courseId) {
		return courseService.getCourseById(courseId);
	}

	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE
	)
	public Long createCourse(@RequestBody Course course) {
		return courseService.createCourse(course);
	}

}
