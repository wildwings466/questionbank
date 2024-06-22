package com.skilltest.questionbank.questionbank.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skilltest.questionbank.questionbank.util.ToLowerCase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
public class Syllabus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@ToLowerCase
	private String name;
	
	@JsonBackReference
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exam_id")
	@ToString.Exclude
	private Exam exam;
	
	@JsonIgnore
	@OneToMany(mappedBy = "syllabus", fetch= FetchType.LAZY)
	@ToString.Exclude
	@Builder.Default
	private List<Subject> subjects = new ArrayList<>();
	
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
