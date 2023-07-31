package com.cobi.techmate.service.course.request;

import com.cobi.techmate.domain.course.Course;
import com.cobi.techmate.domain.course.CourseStatus;
import com.cobi.techmate.domain.course.Difficulty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CourseCreateServiceRequest {

  private String courseNumber;

  private String title;

  private String content;

  private Difficulty difficulty;

  private CourseStatus courseStatus;

  @Builder
  private CourseCreateServiceRequest(
      String courseNumber,
      String title,
      String content,
      Difficulty difficulty,
      CourseStatus courseStatus) {
    this.courseNumber = courseNumber;
    this.title = title;
    this.content = content;
    this.difficulty = difficulty;
    this.courseStatus = courseStatus;
  }

  public Course toEntity(String nextCourseNumber) {
    return Course.builder()
        .courseNumber(nextCourseNumber)
        .title(title)
        .content(content)
        .difficulty(difficulty)
        .courseStatus(courseStatus)
        .build();
  }
}
