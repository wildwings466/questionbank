package com.skilltest.questionbank.questionbank.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.skilltest.questionbank.questionbank.util.ToLowerCase;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(unique = true)
	@ToLowerCase
	private String name;
	
	private int year;
	
	private boolean active;
	
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "course_id", nullable = false)
	@ToString.Exclude
	private Course course;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "exam", fetch = FetchType.LAZY)
	@ToString.Exclude
	private Syllabus syllabus;
	
	@OneToMany(mappedBy = "exam", fetch = FetchType.LAZY)
	@ToString.Exclude
	@Builder.Default
	private List<QuestionPaper> questionPaper = new ArrayList<>();
	
	@JsonManagedReference
	@ManyToMany(mappedBy="exams", fetch = FetchType.LAZY)
	@ToString.Exclude
	@Builder.Default
	private List<Question> questions = new ArrayList<>();
	
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
