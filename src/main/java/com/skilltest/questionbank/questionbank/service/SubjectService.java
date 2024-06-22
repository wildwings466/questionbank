package com.skilltest.questionbank.questionbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilltest.questionbank.questionbank.dao.SubjectRepository;
import com.skilltest.questionbank.questionbank.dao.SyllabusRepository;
import com.skilltest.questionbank.questionbank.model.Subject;
import com.skilltest.questionbank.questionbank.util.SupplierFactory;

@Service
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private SyllabusRepository syllabusRepository;
	
	public Long createSubject(Subject subject) {
		String syllabusName = subject.getSyllabus().getName();
		subject.setSyllabus(syllabusRepository.findByName(syllabusName).
				orElseThrow(SupplierFactory.getQuestionBankExceptionSupplier("Syllabus not found: " + syllabusName)));
		return subjectRepository.save(subject).getId();
	}
	
	
	public List<Subject> getSubjects() {
		return subjectRepository.findAll();
	}
	
	public Subject getSubjectByName(String name) {
		return subjectRepository.findByName(name).
				orElseThrow(SupplierFactory.getQuestionBankExceptionSupplier("Subject not found: " + name));
	}
}
