package com.skilltest.questionbank.questionbank.model.entities;

import com.skilltest.questionbank.questionbank.constants.CourseType;


 public interface CourseProjection {

     Long getId();

     void setId(Long id);

     String getName();

     void setName(String name);

     String getBoard();

     void setBoard(String board);

     CourseType getCourseType();

     void setCourseType(CourseType courseType);
}
