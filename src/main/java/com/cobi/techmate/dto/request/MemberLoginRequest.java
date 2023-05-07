package com.cobi.techmate.dto.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberLoginRequest {

  @NotBlank(message = "비어있는 항목을 입력해주세요.")
  @Email(message = "올바른 이메일 형식이 아닙니다.")
  private String email;

  @NotNull(message = "비어있는 항목을 입력해주세요.")
  public String password;

  public MemberLoginRequest(final String email, final String password) {
    this.email = email;
    this.password = password;
  }
}
