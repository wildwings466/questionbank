package com.skilltest.questionbank.questionbank.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilltest.questionbank.questionbank.model.QuestionPaper;
import com.skilltest.questionbank.questionbank.service.QuestionPaperService;

@RestController
@RequestMapping("api/question-paper")
@CrossOrigin(origins = "http://localhost:4200")
public class QuestionPaperController {
	private static Logger logger = LoggerFactory.getLogger(QuestionPaperController.class);
	
	@Autowired
	private QuestionPaperService questionPaperService;
	
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<QuestionPaper> getQuestionPaper() {
		return questionPaperService.getQuestionPapers();
	}
	
	
	@GetMapping(path = "/internal",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<QuestionPaper> getQuestionPaperInternal() {
		return questionPaperService.getQuestionPapers();
	}
	
	@GetMapping("/exam-name/{name}/year/{year}")
	public List<QuestionPaper> getQuestionPaperByExamNameAndYear(
			@PathVariable(value = "name") String name, @PathVariable(value = "year") Integer year) {
		return questionPaperService.getQuestionPaperByExamNameAndYear(name, year);
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public Long createCourse(@RequestBody QuestionPaper course) {
		logger.info("creating Course: {}", course);
		return questionPaperService.createQuestionPaper(course);
	}	
}
