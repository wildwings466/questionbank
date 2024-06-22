package com.skilltest.questionbank.questionbank.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.skilltest.questionbank.questionbank.dao.SubTopicRepository;
import com.skilltest.questionbank.questionbank.dao.TopicRepository;
import com.skilltest.questionbank.questionbank.model.SubTopic;
import com.skilltest.questionbank.questionbank.util.SupplierFactory;

@Service
public class SubTopicService {
	
	@Autowired
	private SubTopicRepository subTopicRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	
	public Long createSubTopic(SubTopic subTopic) {
		String topicName = subTopic.getTopic().getName();
		subTopic.setTopic(topicRepository.findByName(topicName).
				orElseThrow(SupplierFactory.getQuestionBankExceptionSupplier("Topic not found: "+ topicName)));
		return subTopicRepository.save(subTopic).getId();
	}
	
	public List<SubTopic> getSubTopics() {
		return subTopicRepository.findAll();
	}	
	
	public SubTopic getTopicByName(String name) {
		return subTopicRepository.findByName(name);
	}
	
	public void updateTopic(SubTopic topic) {
		subTopicRepository.findById(topic.getId()).orElseThrow();
		subTopicRepository.save(topic);
	}
	
	public void deleteTopic(Long id) {
		subTopicRepository.deleteById(id);
	}

	public Set<SubTopic> getSubTopicsByTopic(String topicName) {
		// TODO Auto-generated method stub
		return null;
	}

	public SubTopic getSubTopicByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
