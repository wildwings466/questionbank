package com.skilltest.questionbank.questionbank.controller;

import java.util.List;
import java.util.Set;

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

import com.skilltest.questionbank.questionbank.model.SubTopic;
import com.skilltest.questionbank.questionbank.service.SubTopicService;

@RestController
@RequestMapping("api/sub-topics")
@CrossOrigin(origins = "http://localhost:4200")
public class SubTopicController {
	private static Logger logger = LoggerFactory.getLogger(TopicController.class);
	@Autowired
	private SubTopicService topicService;
	
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<SubTopic> getTopics() {
		return topicService.getSubTopics();
	}
	
	@GetMapping(
			path="/internal",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<SubTopic> getTopicsInternal() {
		return topicService.getSubTopics();
	}
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	@RequestMapping("/topic/{top-name}")
	public Set<SubTopic> getSubTopics(@PathVariable(value = "top-name") String subjectName) {
		return topicService.getSubTopicsByTopic(subjectName);
	}
	
	@GetMapping("/name/{name}")
	public SubTopic getSubTopicByName(@PathVariable(value = "name") String name) {
		return topicService.getSubTopicByName(name);
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public Long createSubTopic(@RequestBody SubTopic subTopic) {
		logger.info("creating SubTopic: {}", subTopic);
		return topicService.createSubTopic(subTopic);
	}
}
