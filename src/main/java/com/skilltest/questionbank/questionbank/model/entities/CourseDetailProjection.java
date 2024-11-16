package com.skilltest.questionbank.questionbank.model.entities;

import com.skilltest.questionbank.questionbank.constants.CourseType;

import java.util.List;

public interface CourseDetailProjection {
    Long getId();

    void setId(Long id);

    String getName();

    void setName(String name);

    String getBoard();

    void setBoard(String board);

    CourseType getCourseType();

    void setCourseType(CourseType courseType);

    List<ExamProjection> getExams();

    void setExams(List<ExamProjection> exams);

}
