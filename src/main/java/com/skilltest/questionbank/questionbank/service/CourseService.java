package com.skilltest.questionbank.questionbank.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilltest.questionbank.questionbank.dao.CourseRepository;
import com.skilltest.questionbank.questionbank.model.Course;
import com.skilltest.questionbank.questionbank.util.SupplierFactory;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public Long createCourse(Course course) {
		return courseRepository.save(course).getId();
	}
	
	public List<Course> getCourses() {
		return courseRepository.findAll();
	}
	
	public Course getCourseByName(String name) {
		return courseRepository.findByName(name).orElseThrow(SupplierFactory.getQuestionBankExceptionSupplier("Course Not found"));
	}
	
	public Set<Course> getCourseByBoard(String board){
		return courseRepository.findAllByBoard(board).
				orElseThrow(SupplierFactory.getQuestionBankExceptionSupplier("No courses available for this board: " + board));
	}
}
