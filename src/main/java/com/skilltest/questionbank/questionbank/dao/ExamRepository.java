package com.skilltest.questionbank.questionbank.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.skilltest.questionbank.questionbank.model.entities.ExamProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.skilltest.questionbank.questionbank.model.Exam;

public interface ExamRepository extends JpaRepository<Exam, Long>{
	
	public Optional<Exam> findByName(String name);

	public List<Exam> findAllByNameIn(Set<String> names);
	
	@Query("select e from Exam e where e.active = true")
	public List<Exam> findAllActiveExams();
	
	@Modifying
	@Query("update Exam e set e.active = true where e.id = :id")
	public void activateExam(@Param(value = "id") long id);

	@Query("SELECT e FROM Exam e WHERE e.course.id = :courseId")
	List<ExamProjection> findExamsByCourseId(@Param("courseId") Long courseId);

	@Query("select e from Exam e")
	List<ExamProjection> findAllExams();
	
	
}
