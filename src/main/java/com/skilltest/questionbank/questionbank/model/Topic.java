package com.skilltest.questionbank.questionbank.model;

import java.time.Instant;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.skilltest.questionbank.questionbank.util.ToLowerCase;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
public class Topic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(unique = true)
	@ToLowerCase
	private String name;
	
	@JsonIgnore
	@ManyToMany(
		fetch = FetchType.LAZY,
		cascade = {
				CascadeType.PERSIST,
				CascadeType.MERGE
		}
	)
	@JoinTable(name = "topic_subject",
	joinColumns = {@JoinColumn(name = "topic_id")},
	inverseJoinColumns = {@JoinColumn(name = "subject_id")}
	)
	@ToString.Exclude
	@Builder.Default
	private List<Subject> subjects = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch= FetchType.LAZY)
	@ToString.Exclude
	@Builder.Default
	private List<SubTopic> subtopics = new ArrayList<>();
	
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
	
	/*
	 * public void addSubject(Subject subject) { this.subjects.add(subject);
	 * this.subjectNames.add(subject.getName()); subject.getTopics().add(this); }
	 * 
	 * public void removeSubject(long subjectId) { Subject subject =
	 * this.subjects.stream().filter(t -> t.getId() ==
	 * subjectId).findFirst().orElse(null); if (subject != null) {
	 * this.subjects.remove(subject); this.subjectNames.remove(subject.getName());
	 * subject.getTopics().remove(this); } }
	 * 
	 * public void setSubjects(Set<Subject> subjects) { if (subjects != null) {
	 * this.subjects = subjects; subjects.forEach(sub ->
	 * this.subjectNames.add(sub.getName())); }
	 * 
	 * }
	 * 
	 * public Set<String> getSubjectNames(){ if (this.subjectNames.isEmpty() &&
	 * !this.subjects.isEmpty()) { this.subjects.forEach(sub->
	 * this.subjectNames.add(sub.getName())); } return subjectNames; }
	 */
}
