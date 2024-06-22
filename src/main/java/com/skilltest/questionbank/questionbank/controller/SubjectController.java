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

import com.skilltest.questionbank.questionbank.model.Subject;
import com.skilltest.questionbank.questionbank.service.SubjectService;

@RestController
@RequestMapping("api/subjects")
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectController {
	private static Logger logger = LoggerFactory.getLogger(SubjectController.class);
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Subject> getSubjects() {
		return subjectService.getSubjects();
	}
	
	@GetMapping(
			path="/internal",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Subject> getSubjectsInternal() {
		return subjectService.getSubjects();
	}
	
	@GetMapping("/name/{name}")
	public Subject getSubjectsByName(@PathVariable(value = "name") String name) {
		return subjectService.getSubjectByName(name);
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public Long createSubjects(@RequestBody Subject category) {
		logger.info("creating Cateogry: {}", category);
		return subjectService.createSubject(category);
	}

}
