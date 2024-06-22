package com.skilltest.questionbank.questionbank.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skilltest.questionbank.questionbank.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Long>{
	
	public Optional<Subject> findByName(String name);
	
	public List<Subject> findAllByNameIn(List<String> names);
	
}
