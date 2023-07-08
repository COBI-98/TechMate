package com.cobi.techmate.domain.course;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CourseStatus {
  OPEN("개설"),
  STOP("중지");

  private final String text;
}
