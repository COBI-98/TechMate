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

  private CourseStatus classStatus;

  @Builder
  private CourseCreateServiceRequest(
      String courseNumber,
      String title,
      String content,
      Difficulty difficulty,
      CourseStatus classStatus) {
    this.courseNumber = courseNumber;
    this.title = title;
    this.content = content;
    this.difficulty = difficulty;
    this.classStatus = classStatus;
  }

  public Course toEntity() {
    return Course.builder()
        .courseNumber(courseNumber)
        .title(title)
        .content(content)
        .difficulty(difficulty)
        .classStatus(classStatus)
        .build();
  }
}
