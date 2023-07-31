package com.cobi.techmate;

import static com.cobi.techmate.DocumentUtils.getRequestPreprocessor;
import static com.cobi.techmate.DocumentUtils.getRequestSpecification;
import static com.cobi.techmate.DocumentUtils.getResponsePreprocessor;
import static com.cobi.techmate.DocumentUtils.setRequestSpecification;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration;

import com.cobi.techmate.service.member.request.MemberRegisterRequest;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@AutoConfigureRestDocs
public class AcceptanceTest {

  @LocalServerPort int port;

  @BeforeEach
  public void setUp(RestDocumentationContextProvider restDocumentation) {
    RestAssured.port = port;
    RequestSpecification spec =
        new RequestSpecBuilder().addFilter(documentationConfiguration(restDocumentation)).build();
    setRequestSpecification(spec);
  }

  protected ExtractableResponse<Response> saveMember(
      final MemberRegisterRequest memberRegisterRequest) {
    return RestAssured.given(getRequestSpecification())
        .log()
        .all()
        .accept("application/json")
        .filter(document("member/post", getRequestPreprocessor(), getResponsePreprocessor()))
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .body(memberRegisterRequest)
        .when()
        .post("/api/v1/members")
        .then()
        .log()
        .all()
        .extract();
  }
}
