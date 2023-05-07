package com.cobi.techmate.exception.authorization;

import com.cobi.techmate.exception.TechMateException;
import org.springframework.http.HttpStatus;

public class TokenExpiredException extends TechMateException {
  private static final String MESSAGE = "로그인 인증 유효기간이 만료되었습니다. 다시 로그인 해주세요.";

  public TokenExpiredException() {
    super(MESSAGE, HttpStatus.UNAUTHORIZED);
  }
}
