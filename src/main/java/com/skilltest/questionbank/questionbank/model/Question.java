package com.skilltest.questionbank.questionbank.model;


import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subtopic_id")
	private SubTopic subTopic;
	
	@NotNull
	@Column(name = "statement", unique = true)
	private String statement;
	
	@NotNull
	private String answer;
	
	@NotNull
	private String option1;
	
	@NotNull
	private String option2;
	
	private String option3;
	
	private float penalty;
	
	@Column(name = "question_paper_code")
	private String questionPaperCode;
	
	@Column(name = "default_grade")
	private float defaultGrade;
	
	@Column(name = "previous_years")
	private String[] previousYears;
	
	@JsonBackReference
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "previous_exams",
	joinColumns = {@JoinColumn(name="question_id")},
	inverseJoinColumns = {@JoinColumn(name = "exam_id")})
	@ToString.Exclude
	@Builder.Default
	private List<Exam> exams = new ArrayList<>();
	
	@Column(name ="created_by")
	@ToString.Exclude
	private String createdBy;
	
	@CreationTimestamp
	@Column(name ="time_created")
	@ToString.Exclude
    private Instant timeCreated;
	
	@Column(name = "updated_by")
	@ToString.Exclude
	private String updatedBy;
	
	@UpdateTimestamp
	@Column(name ="last_updated_on")
	@ToString.Exclude
    private Instant lastUpdatedOn;
}
