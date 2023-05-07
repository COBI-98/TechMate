package com.cobi.techmate.exception.authorization;

import com.cobi.techmate.exception.TechMateException;
import org.springframework.http.HttpStatus;

public class InvalidTokenException extends TechMateException {
  private static final String MESSAGE = "로그인이 필요한 서비스입니다.";

  public InvalidTokenException() {
    super(MESSAGE, HttpStatus.UNAUTHORIZED);
  }
}
