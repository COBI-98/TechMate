package com.cobi.techmate.service.course.response;

import com.cobi.techmate.domain.course.Course;
import com.cobi.techmate.domain.course.CourseStatus;
import com.cobi.techmate.domain.course.Difficulty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CourseResponse {

  private Long id;

  private String courseNumber;

  private String title;

  private String content;

  private Difficulty difficulty;

  private CourseStatus courseStatus;

  @Builder
  private CourseResponse(
      Long id,
      String courseNumber,
      String title,
      String content,
      Difficulty difficulty,
      CourseStatus courseStatus) {
    this.id = id;
    this.courseNumber = courseNumber;
    this.title = title;
    this.content = content;
    this.difficulty = difficulty;
    this.courseStatus = courseStatus;
  }

  public static CourseResponse of(Course course) {

    return CourseResponse.builder()
        .id(course.getId())
        .courseNumber(course.getCourseNumber())
        .title(course.getTitle())
        .content(course.getContent())
        .difficulty(course.getDifficulty())
        .courseStatus(course.getCourseStatus())
        .build();
  }
}
