package com.skilltest.questionbank.questionbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilltest.questionbank.questionbank.dao.QuestionRepository;
import com.skilltest.questionbank.questionbank.model.Question;
import com.skilltest.questionbank.questionbank.model.SubTopic;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public Question createQuestion(Question question) {
		return questionRepository.save(question);
	}

	public List<Question> getQuestions() {
		return questionRepository.findAll();
	}
	
	public List<Question> getQuestionsByQuestionPaperCode(String questionPaperCode) {
		return questionRepository.findByQuestionPaperCode(questionPaperCode);
	}
	
	
	public List<Question> getQuestionsBySubTopic(SubTopic topic){
		return questionRepository.findBySubTopic(topic);
	}
	
	public void updateQuestion(Question question) {
		questionRepository.findById(question.getId()).orElseThrow();
		questionRepository.save(question);
	}
	
	public void deleteQuestion(Long id) {
		questionRepository.deleteById(id);
	}
}
