package com.cobi.techmate.service.member.request;

import lombok.Getter;

@Getter
public class MemberUpdateRequest {

  private String username;

  public MemberUpdateRequest() {}

  public MemberUpdateRequest(String username) {
    this.username = username;
  }
}
