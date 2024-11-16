package com.skilltest.questionbank.questionbank.model.entities;

import java.util.List;

public interface SubjectProjection {
	
	 long getId();

	 void setId(long id);

	 String getName();

	 void setName(String name);

	 List<TopicProjection> getTopics();

	 void setTopics(List<TopicProjection> topics);
}
