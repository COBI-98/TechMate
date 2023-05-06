package com.cobi.techmate.exception;

import com.cobi.techmate.dto.ValidatorMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class TechMateException extends RuntimeException {

  private final HttpStatus status;

  public TechMateException() {
    super(ValidatorMessage.SERVER_ERROR_MESSAGE);
    this.status = HttpStatus.INTERNAL_SERVER_ERROR;
  }

  public TechMateException(final HttpStatus status) {
    super(ValidatorMessage.SERVER_ERROR_MESSAGE);
    this.status = status;
  }

  public TechMateException(String message, final HttpStatus status) {
    super(message);
    this.status = status;
  }

  public TechMateException(final String message, final Throwable cause, final HttpStatus status) {
    super(message, cause);
    this.status = status;
  }
}
