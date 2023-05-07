package com.cobi.techmate.dto.response;

public class TokenResponse {
  private String accessToken;

  public TokenResponse() {}

  public TokenResponse(final String accessToken) {
    this.accessToken = accessToken;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public static TokenResponse of(String token) {
    return new TokenResponse(token);
  }
}
