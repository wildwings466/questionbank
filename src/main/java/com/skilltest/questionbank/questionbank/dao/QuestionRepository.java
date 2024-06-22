package com.skilltest.questionbank.questionbank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilltest.questionbank.questionbank.model.Question;
import com.skilltest.questionbank.questionbank.model.SubTopic;

public interface QuestionRepository extends JpaRepository<Question, Long>{

	List<Question> findBySubTopic(SubTopic topic);
	List<Question> findByQuestionPaperCode(String questionPaperCode);
	
}
