package com.skilltest.questionbank.questionbank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilltest.questionbank.questionbank.model.QuestionPaper;

public interface QuestionPaperRepository extends JpaRepository<QuestionPaper, Long>{

	List<QuestionPaper> findByExamNameAndYearOfExam(String examName, Integer YearOfExam);

}
