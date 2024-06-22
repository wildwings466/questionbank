package com.skilltest.questionbank.questionbank.dao;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilltest.questionbank.questionbank.model.Subject;
import com.skilltest.questionbank.questionbank.model.Topic;

public interface TopicRepository  extends JpaRepository<Topic, Long>{

	Optional<Topic> findByName(String name);
	
	Set<Topic> findAllBySubjectsIn(List<Subject> subject);
 }
