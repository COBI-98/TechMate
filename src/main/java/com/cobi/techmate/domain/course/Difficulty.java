package com.cobi.techmate.domain.course;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Difficulty {
  LOWER("초심자"),
  MIDDLE("중급자"),
  HIGHT("상급자");

  private final String text;
}
