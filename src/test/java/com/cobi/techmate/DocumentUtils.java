package com.cobi.techmate;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;

import io.restassured.specification.RequestSpecification;
import org.springframework.restdocs.operation.preprocess.OperationRequestPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationResponsePreprocessor;

public final class DocumentUtils {
  private static RequestSpecification preConfiguredRequestSpecification;

  public DocumentUtils() {}

  public static RequestSpecification getRequestSpecification() {
    return preConfiguredRequestSpecification;
  }

  public static void setRequestSpecification(
      RequestSpecification preConfiguredRequestSpecification) {
    DocumentUtils.preConfiguredRequestSpecification = preConfiguredRequestSpecification;
  }

  public static OperationRequestPreprocessor getRequestPreprocessor() {
    return preprocessRequest(prettyPrint());
  }

  public static OperationResponsePreprocessor getResponsePreprocessor() {
    return preprocessResponse(prettyPrint());
  }
}
