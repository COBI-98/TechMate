package com.cobi.techmate.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CommunityStatus {
  ING(1, "미해결", "모집중"),
  COMPLETION(2, "해결", "모집완료");

  private int statusCode;
  private String statusQnaName;
  private String statusStudyName;
}
