package com.skilltest.questionbank.questionbank.model.entities;

import com.skilltest.questionbank.questionbank.model.Syllabus;

import java.util.List;

public interface ExamProjection {

    public Long getId();

    public void setId(Long id);

    public String getName();

    public void setName(String name);

    public int getYear();

    public void setYear(int year);

    public boolean isActive();

    public void setActive(boolean active);

    public SyllabusProjection getSyllabus();

    public void setSyllabus(SyllabusProjection syllabus);

    public List<QuestionPaperProjection> getQuestionPaper();

    public void setQuestionPaper(List<QuestionPaperProjection> questionPaper);
}
