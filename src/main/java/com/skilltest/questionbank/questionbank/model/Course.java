package com.skilltest.questionbank.questionbank.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.skilltest.questionbank.questionbank.constants.CourseType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
	
    @JsonManagedReference
	@OneToMany(mappedBy = "course", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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
	private String updatedBy;
	
	@UpdateTimestamp
	@Column(name ="last_updated_on")
	@ToString.Exclude
    private Instant lastUpdatedOn;
	
}
