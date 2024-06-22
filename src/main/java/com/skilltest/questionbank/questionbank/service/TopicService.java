package com.skilltest.questionbank.questionbank.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilltest.questionbank.questionbank.dao.SubjectRepository;
import com.skilltest.questionbank.questionbank.dao.TopicRepository;
import com.skilltest.questionbank.questionbank.exception.QuestionBankException;
import com.skilltest.questionbank.questionbank.model.Subject;
import com.skilltest.questionbank.questionbank.model.Topic;
import com.skilltest.questionbank.questionbank.util.SupplierFactory;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public Long createTopic(Topic topic) {
		List<Subject> subjects = subjectRepository.findAllByNameIn(
				topic.getSubjects().stream().map(subject -> subject.getName()).collect(Collectors.toList()));
		 if (subjects.isEmpty()) {
			 throw new QuestionBankException("Subjects not found.");
		 }
		topic.setSubjects(subjects);
		return topicRepository.save(topic).getId();
	}
	
	public List<Topic> getTopics() {
		return topicRepository.findAll();
	}	
	
	public Topic getTopicByName(String name) {
		return topicRepository.findByName(name).orElseThrow(SupplierFactory.getQuestionBankExceptionSupplier("Topic Not found: " + name));
	}
	
	public void updateTopic(Topic topic) {
		topicRepository.findById(topic.getId()).orElseThrow();
		topicRepository.save(topic);
	}
	
	public void deleteTopic(Long id) {
		topicRepository.deleteById(id);
	}
}
