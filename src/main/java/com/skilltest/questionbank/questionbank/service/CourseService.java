package com.skilltest.questionbank.questionbank.service;

import java.util.List;
import java.util.Set;

import com.skilltest.questionbank.questionbank.constants.CourseType;
import com.skilltest.questionbank.questionbank.model.entities.CourseProjection;
import com.skilltest.questionbank.questionbank.model.entities.CourseDetailProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilltest.questionbank.questionbank.dao.CourseRepository;
import com.skilltest.questionbank.questionbank.model.Course;
import com.skilltest.questionbank.questionbank.util.SupplierFactory;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public Long createCourse(Course course) {
		return courseRepository.save(course).getId();
	}
	
	public List<CourseProjection> getCourses() {
		return courseRepository.findAllProjected();
	}

	public List<CourseProjection> getCoursesByCourseType(String courseType) {
		return courseRepository.findByCourseType(CourseType.valueOf(courseType));
	}
	
	public CourseDetailProjection getCourseByName(String name) {
		return courseRepository.findCourseByName(name).orElseThrow(SupplierFactory.getQuestionBankExceptionSupplier("Course Not found"));
	}

	public CourseDetailProjection getCourseById(Long courseId) {
		return courseRepository.findCourseById(courseId).orElseThrow(SupplierFactory.getQuestionBankExceptionSupplier("Course Not found"));
	}
	
	public Set<CourseProjection> getCourseByBoard(String board){
		return courseRepository.findAllByBoard(board).
				orElseThrow(SupplierFactory.getQuestionBankExceptionSupplier("No courses available for this board: " + board));
	}
}
