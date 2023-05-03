package com.cobi.techmate.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
  STUDENT(1, "학생"),
  INSTRUCTOR(2, "강사"),
  ADMIN(0, "관리자"),
  ;
  private Integer statusCode;
  private String statusTitle;
}
