package com.cobi.techmate.exception.member;

import com.cobi.techmate.exception.InputFieldException;
import org.springframework.http.HttpStatus;

public class NoSuchMemberException extends InputFieldException {
  private static final String MESSAGE = "존재하지 않는 회원입니다.";

  public NoSuchMemberException() {
    super(MESSAGE, HttpStatus.NOT_FOUND, EMAIL);
  }
}
