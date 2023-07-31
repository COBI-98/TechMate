package com.cobi.techmate.domain.course;

import java.util.List;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CourseStatus {
  CREATE("개설"),
  OPEN("운영"),
  STOP("중지");

  private final String text;

  public static List<CourseStatus> forDisPlay() {
    return List.of(OPEN);
  }
}
