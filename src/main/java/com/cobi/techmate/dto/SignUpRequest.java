package com.cobi.techmate.dto;

import com.cobi.techmate.domain.Member;

public class SignUpRequest {
  private String username;
  private String email;
  private String password;

  public SignUpRequest() {}

  public SignUpRequest(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public Member toEntity() {
    return new Member(username, email, password);
  }
}
