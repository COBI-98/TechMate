package com.cobi.techmate.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommunityType {
  QNA(1, "질문답변"),
  TOPIC(2, "자유주제"),
  STUDY(3, "스터디");

  private Integer statusCode;
  private String statusTitle;
}
