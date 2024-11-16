package com.skilltest.questionbank.questionbank.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.skilltest.questionbank.questionbank.constants.CourseType;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String board;
	
    @NotNull
    @Column(name ="course_type")
    @Enumerated
    private CourseType courseType;

	@JsonIgnore
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@ToString.Exclude
	private List<Exam> exams = new ArrayList<>();
	
	@Column(name ="created_by")
	@ToString.Exclude
	private String createdBy;
	
	@CreationTimestamp
	@Column(name ="time_created")
	@ToString.Exclude
    private Instant timeCreated;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	@UpdateTimestamp
	@Column(name ="last_updated_on")
	@ToString.Exclude
    private Instant lastUpdatedOn;
	
}
