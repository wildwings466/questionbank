package com.skilltest.questionbank.questionbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilltest.questionbank.questionbank.dao.ExamRepository;
import com.skilltest.questionbank.questionbank.dao.QuestionPaperRepository;
import com.skilltest.questionbank.questionbank.model.QuestionPaper;
import com.skilltest.questionbank.questionbank.util.SupplierFactory;

@Service
public class QuestionPaperService {
	
	@Autowired
	private QuestionPaperRepository questionPaperRepository;
	
	@Autowired
	private ExamRepository examRepository;
	
	public Long createQuestionPaper(QuestionPaper questionPaper) {
		questionPaper.setExam(examRepository.findByName(questionPaper.getExam().getName()).
				orElseThrow(SupplierFactory.getQuestionBankExceptionSupplier("Exam not found!")));
		return questionPaperRepository.save(questionPaper).getId();
	}
	
	public List<QuestionPaper> getQuestionPapers() {
        return questionPaperRepository.findAll();
	}
	
	public List<QuestionPaper> getQuestionPaperByExamNameAndYear(String examName, Integer year) {
		return questionPaperRepository.findByExamNameAndYearOfExam(examName, year);
	}
}
