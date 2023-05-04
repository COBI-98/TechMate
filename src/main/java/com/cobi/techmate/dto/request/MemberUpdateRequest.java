package com.cobi.techmate.dto.request;

import lombok.Getter;

@Getter
public class MemberUpdateRequest {

  private String username;

  public MemberUpdateRequest() {}

  public MemberUpdateRequest(String username) {
    this.username = username;
  }
}
