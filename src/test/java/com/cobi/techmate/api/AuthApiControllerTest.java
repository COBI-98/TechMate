package com.cobi.techmate.api;

import static com.cobi.techmate.DocumentUtils.getRequestPreprocessor;
import static com.cobi.techmate.DocumentUtils.getRequestSpecification;
import static com.cobi.techmate.DocumentUtils.getResponsePreprocessor;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;

import com.cobi.techmate.AcceptanceTest;
import com.cobi.techmate.service.auth.response.TokenResponse;
import com.cobi.techmate.service.member.request.MemberLoginRequest;
import com.cobi.techmate.service.member.request.MemberRegisterRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class AuthApiControllerTest extends AcceptanceTest {
  public static final String USERNAME = "cobi";
  public static final String EMAIL = "cobi@naver.com";
  public static final String PASSWORD = "test1234";

  @DisplayName("유효한 정보의 로그인 요청이 오면 200 ok로 응답하며 토큰을 발급한다.")
  @Test
  void login() {
    // given
    saveMember(new MemberRegisterRequest(USERNAME, EMAIL, PASSWORD));

    // when
    MemberLoginRequest loginRequest = new MemberLoginRequest(EMAIL, PASSWORD);
    ExtractableResponse<Response> response = login(loginRequest);
    TokenResponse responseBody = response.body().as(TokenResponse.class);
    // then
    assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    assertThat(responseBody.getAccessToken()).isInstanceOf(String.class);
  }

  private ExtractableResponse<Response> login(final MemberLoginRequest loginRequest) {
    return RestAssured.given(getRequestSpecification())
        .log()
        .all()
        .accept("application/json")
        .filter(document("member/login", getRequestPreprocessor(), getResponsePreprocessor()))
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(loginRequest)
        .when()
        .post("/api/auth/member/login/token")
        .then()
        .log()
        .all()
        .extract();
  }
}
