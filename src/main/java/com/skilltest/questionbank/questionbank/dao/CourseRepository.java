package com.skilltest.questionbank.questionbank.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.skilltest.questionbank.questionbank.constants.CourseType;
import com.skilltest.questionbank.questionbank.model.entities.CourseProjection;
import com.skilltest.questionbank.questionbank.model.entities.CourseDetailProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.skilltest.questionbank.questionbank.model.Course;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course, Long>{

	@Query("SELECT e FROM Course e")
	List<CourseProjection> findAllProjected();

	Optional<Course> findByName(String courseName);
	 Optional<CourseDetailProjection> findCourseByName(String courseName);

	Optional<CourseDetailProjection> findCourseById(Long courseName);
	
	 Optional<Set<CourseProjection>> findAllByBoard(String board);

	List<CourseProjection> findByCourseType(CourseType courseType);

}
