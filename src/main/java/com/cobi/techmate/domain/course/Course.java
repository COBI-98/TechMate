package com.cobi.techmate.domain.course;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "course")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Course {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String courseNumber;

  @Column(name = "course_title", length = 255, nullable = false)
  private String title;

  @Column(name = "course_content")
  private String content;

  @Enumerated(value = EnumType.STRING) // 강의수준
  @Column(name = "course_difficulty", nullable = false)
  private Difficulty difficulty;

  @Enumerated(value = EnumType.STRING) // 강의개설여부
  @Column(name = "course_status", nullable = false)
  private CourseStatus courseStatus;

  @Builder
  private Course(
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
}
