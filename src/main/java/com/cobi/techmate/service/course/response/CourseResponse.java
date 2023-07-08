package com.cobi.techmate.service.course.response;

import com.cobi.techmate.domain.course.CourseStatus;
import com.cobi.techmate.domain.course.Difficulty;
import lombok.Getter;

@Getter
public class CourseResponse {

  private Long id;

  private String courseNumber;

  private String title;

  private String content;

  private Difficulty difficulty;

  private CourseStatus classStatus;

  public CourseResponse(
      Long id,
      String courseNumber,
      String title,
      String content,
      Difficulty difficulty,
      CourseStatus classStatus) {
    this.id = id;
    this.courseNumber = courseNumber;
    this.title = title;
    this.content = content;
    this.difficulty = difficulty;
    this.classStatus = classStatus;
  }
}
