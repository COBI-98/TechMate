package com.cobi.techmate.service.member.request;

import lombok.Getter;

@Getter
public class MemberRegisterRequest {

  private String username;
  private String email;
  private String password;

  public MemberRegisterRequest() {}

  public MemberRegisterRequest(String username, String email, String password) {
    this.username = username;
    this.email = email;
    this.password = password;
  }

  public SignUpRequest toServiceRequest() {
    return new SignUpRequest(username, email, password);
  }
}
