package com.skilltest.questionbank.questionbank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilltest.questionbank.questionbank.model.Question;
import com.skilltest.questionbank.questionbank.service.QuestionService;

@RestController
@RequestMapping("api/questions")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionController {
	
	Logger logger = LoggerFactory.getLogger(QuestionController.class);
	@Autowired
	private QuestionService questionService;
	
	@GetMapping
	public List<Question> getQuestions(){
		return questionService.getQuestions();		
	}
	
	@GetMapping(path = "/question-paper/{code}")
	public List<Question> getQuestionsByQuestionPaperCode(@PathVariable String questionPaperCode){
		return questionService.getQuestionsByQuestionPaperCode(questionPaperCode);		
	}
	
	@GetMapping(path="/internal")
	public List<Question> getQuestionsInternal(){
		return questionService.getQuestions();		
	}
	
	@PostMapping()
	public Question createQuestion(@RequestBody Question newQuestion) {
		logger.info("Creating Question ", newQuestion);
		return questionService.createQuestion(newQuestion);
	}
	

}
