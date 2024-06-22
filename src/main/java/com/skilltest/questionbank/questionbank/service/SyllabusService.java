package com.skilltest.questionbank.questionbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilltest.questionbank.questionbank.dao.ExamRepository;
import com.skilltest.questionbank.questionbank.dao.SyllabusRepository;
import com.skilltest.questionbank.questionbank.model.Syllabus;
import com.skilltest.questionbank.questionbank.util.SupplierFactory;

@Service
public class SyllabusService {
	
	@Autowired
	private SyllabusRepository syllabusRepository;
	
	@Autowired
	private ExamRepository examRepository;
	
	public Long createSyllabus(Syllabus syllabus) {
		String examName = syllabus.getExam().getName();
		syllabus.setExam(examRepository.findByName(examName).
				orElseThrow(SupplierFactory.getQuestionBankExceptionSupplier("Exam not found: " + examName)));
		return syllabusRepository.save(syllabus).getId();
	}
	
	public List<Syllabus> getSyllabi() {
		return syllabusRepository.findAll();
	}
	
	public Syllabus getSyllabusByExam(String exam) {
		return syllabusRepository.findByExam(examRepository.findByName(exam).orElseThrow());
	}
}
