package com.skilltest.questionbank.questionbank.controller;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
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

import com.skilltest.questionbank.questionbank.model.Syllabus;
import com.skilltest.questionbank.questionbank.service.SyllabusService;

@RestController
@RequestMapping("api/syllabi")
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class SyllabusController {
	@Autowired
	private SyllabusService syllabusService;
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Syllabus> getSyllabi() {
		return syllabusService.getSyllabi();
	}
	
	@GetMapping(
			path="/internal",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Syllabus> getSyllabiInternal() {
		return syllabusService.getSyllabi();
	}
	
	@GetMapping("/exam/{exam_name}")
	public Syllabus getSyllabusByExam(@PathVariable(value = "exam_name") String examName) {
		return syllabusService.getSyllabusByExam(examName);
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public Long createSyllabus(@RequestBody Syllabus syllabus) {
		log.info("creating Syllabus: {}", syllabus);
		return syllabusService.createSyllabus(syllabus);
	}

}
