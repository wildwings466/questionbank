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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skilltest.questionbank.questionbank.model.Exam;
import com.skilltest.questionbank.questionbank.service.ExamService;

@RestController
@RequestMapping("api/exams")
@CrossOrigin(origins = "http://localhost:4200")
public class ExamController {
	private static Logger logger = LoggerFactory.getLogger(ExamController.class);
	@Autowired
	private ExamService examService;
	
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Exam> getExams() {
		return examService.getExams();
	}
	
	@GetMapping(
			path = "/active",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Exam> getActiveExams() {
		return examService.getActiveExams();
	}
	
	@GetMapping(path = "/internal",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Exam> getExamsInternal() {
		return examService.getExams();
	}
	
	@GetMapping("/name/{name}")
	public Exam getExamsByName(@PathVariable(value = "name") String name) {
		return examService.getExamByName(name);
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public Long createExams(@RequestBody Exam category) {
		logger.info("creating Cateogry: {}", category);
		return examService.createExam(category);
	}	
	
	@PutMapping(path="/{id}")
	public void activateExam(@PathVariable(value = "id") long id) {
		examService.activateExam(id);
	}

}
