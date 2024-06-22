package com.skilltest.questionbank.questionbank.dao;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilltest.questionbank.questionbank.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long>{
	
	public Optional<Course> findByName(String courseName);
	
	public Optional<Set<Course>> findAllByBoard(String board);

}
