package com.skilltest.questionbank.questionbank.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skilltest.questionbank.questionbank.model.SubTopic;
import com.skilltest.questionbank.questionbank.model.Subject;
import com.skilltest.questionbank.questionbank.util.ToLowerCase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public interface TopicProjection {
	
	public long getId();
	public void setId(long id);
	public String getName();
	public void setName(String name);
	public List<SubTopicProjection> getSubtopics();
	public void setSubtopics(List<SubTopic> subtopics);
}
