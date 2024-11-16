package com.skilltest.questionbank.questionbank.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skilltest.questionbank.questionbank.model.Exam;
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

public interface SyllabusProjection {
	

	public long getId();
	public void setId(long id);
	public String getName();
	public void setName(String name);
	public List<Subject> getSubjects();
	public void setSubjects(List<Subject> subjects);
}
