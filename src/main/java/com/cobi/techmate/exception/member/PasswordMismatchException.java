package com.cobi.techmate.exception.member;

import com.cobi.techmate.exception.InputFieldException;
import org.springframework.http.HttpStatus;

public class PasswordMismatchException extends InputFieldException {
  private static final String Message = "일치하지 않는 패스워드입니다.";

  public PasswordMismatchException() {
    super(Message, HttpStatus.NOT_FOUND, PASSWORD);
  }
}
