package com.skilltest.questionbank.questionbank.dao;

import com.skilltest.questionbank.questionbank.model.Exam;
import com.skilltest.questionbank.questionbank.model.Syllabus;
import com.skilltest.questionbank.questionbank.model.entities.SyllabusProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SyllabusRepository  extends JpaRepository<Syllabus, Long>{

	Syllabus findByExam(Exam exam);
	Optional<Syllabus> findByName(String name);

	@Query("SELECT s FROM Syllabus s WHERE s.exam.name = :examName")
	Optional<SyllabusProjection> findSyllabusByExamName(@Param("examName") String examName);
 }
