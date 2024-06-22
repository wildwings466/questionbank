package com.skilltest.questionbank.questionbank.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilltest.questionbank.questionbank.model.Exam;
import com.skilltest.questionbank.questionbank.model.Syllabus;

public interface SyllabusRepository  extends JpaRepository<Syllabus, Long>{

	Syllabus findByExam(Exam exam);
	Optional<Syllabus> findByName(String name);
 }
