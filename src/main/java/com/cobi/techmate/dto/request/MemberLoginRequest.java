package com.cobi.techmate.dto.request;

import lombok.Getter;

@Getter
public class MemberLoginRequest {

  public String email;
  public String password;

  public MemberLoginRequest(final String email, final String password) {
    this.email = email;
    this.password = password;
  }
}
