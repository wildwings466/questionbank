package com.skilltest.questionbank.questionbank.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilltest.questionbank.questionbank.model.SubTopic;
import com.skilltest.questionbank.questionbank.model.Topic;

public interface SubTopicRepository  extends JpaRepository<SubTopic, Long>{

	SubTopic findByName(String name);
	
	Set<SubTopic> findByTopic(Topic subjectId);
 }
