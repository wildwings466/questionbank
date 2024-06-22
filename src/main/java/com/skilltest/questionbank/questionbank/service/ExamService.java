package com.skilltest.questionbank.questionbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilltest.questionbank.questionbank.dao.CourseRepository;
import com.skilltest.questionbank.questionbank.dao.ExamRepository;
import com.skilltest.questionbank.questionbank.model.Exam;
import com.skilltest.questionbank.questionbank.util.SupplierFactory;

import jakarta.transaction.Transactional;

@Service
public class ExamService {
	
	@Autowired
	private ExamRepository examRepository;
	
	
	  @Autowired private CourseRepository courseRepository;
	 
	
	public Long createExam(Exam exam) {
		
		  String courseName = exam.getCourse().getName();
		  exam.setCourse(courseRepository.findByName(courseName).orElseThrow(
				  SupplierFactory.getQuestionBankExceptionSupplier("Course not found: " + courseName)));
		 
		return examRepository.save(exam).getId();
	}
	
	public List<Exam> getExams() {
		return examRepository.findAll();
	}
	
	public List<Exam> getActiveExams(){
		return examRepository.findAllActiveExams();
	}
	
	@Transactional 
	public void activateExam(long id) {
		examRepository.activateExam(id);
	}
	
	public Exam getExamByName(String name) {
		return examRepository.findByName(name)
				.orElseThrow(SupplierFactory.getQuestionBankExceptionSupplier("Exam Not found"));
	}
}
