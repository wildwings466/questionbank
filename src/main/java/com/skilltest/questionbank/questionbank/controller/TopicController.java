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

import com.skilltest.questionbank.questionbank.model.Topic;
import com.skilltest.questionbank.questionbank.service.TopicService;

@RestController
@RequestMapping("api/topics")
@CrossOrigin(origins = "http://localhost:4200")
public class TopicController {
	private static Logger logger = LoggerFactory.getLogger(TopicController.class);
	@Autowired
	private TopicService topicService;
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Topic> getTopics() {
		return topicService.getTopics();
	}
	
	@GetMapping(
			path="/internal",
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	public List<Topic> getTopicsInternal() {
		return topicService.getTopics();
	}
	
	@GetMapping("/name/{name}")
	public Topic getTopicByName(@PathVariable(value = "name") String name) {
		return topicService.getTopicByName(name);
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	public Long createTopic(@RequestBody Topic topic) {
		logger.info("creating Cateogry: {}", topic);
		return topicService.createTopic(topic);
	}

}
