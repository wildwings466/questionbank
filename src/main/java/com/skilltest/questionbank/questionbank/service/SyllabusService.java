package com.skilltest.questionbank.questionbank.service;

import com.skilltest.questionbank.questionbank.dao.ExamRepository;
import com.skilltest.questionbank.questionbank.dao.SyllabusRepository;
import com.skilltest.questionbank.questionbank.model.Syllabus;
import com.skilltest.questionbank.questionbank.model.entities.SyllabusProjection;
import com.skilltest.questionbank.questionbank.util.SupplierFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SyllabusService {
	
	private final SyllabusRepository syllabusRepository;
	
	private final ExamRepository examRepository;
	
	public Long createSyllabus(Syllabus syllabus) {
		String examName = syllabus.getExam().getName();
		syllabus.setExam(examRepository.findByName(examName).
				orElseThrow(SupplierFactory.getQuestionBankExceptionSupplier("Exam not found: " + examName)));
		return syllabusRepository.save(syllabus).getId();
	}
	
	public List<Syllabus> getSyllabi() {
		return syllabusRepository.findAll();
	}
	
	public SyllabusProjection getSyllabusByExam(String exam) {
		return syllabusRepository.findSyllabusByExamName(exam).orElseThrow(SupplierFactory.getNotFoundExceptionSupplier("Exam Not found"));
	}
}
