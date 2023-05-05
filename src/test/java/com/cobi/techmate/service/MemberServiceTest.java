package com.cobi.techmate.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.cobi.techmate.dto.SignUpRequest;
import com.cobi.techmate.dto.response.MemberResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
class MemberServiceTest {

  @Autowired private MemberService memberService;

  @Test
  @DisplayName("회원을 id값으로 찾는다.")
  public void findById() {
    // given
    SignUpRequest member = new SignUpRequest("cobi", "cobi@naver.com", "spring!password");
    Long memberId = memberService.join(member);

    // when
    MemberResponse findMember = memberService.findById(memberId);

    // then
    assertThat(findMember)
        .extracting("id", "username", "email", "password")
        .containsExactly(memberId, "cobi", "cobi@naver.com", "spring!password");
  }

  @Test
  @DisplayName("회원의 username을 수정한다.")
  public void update() {
    // given
    SignUpRequest member = new SignUpRequest("cobi", "cobi@naver.com", "spring!password");
    Long memberId = memberService.join(member);

    // when
    memberService.updateUsername(memberId, "cobi98");

    // then
    assertThat(memberService.findById(memberId))
        .extracting("id", "username", "email", "password")
        .containsExactly(memberId, "cobi98", "cobi@naver.com", "spring!password");
  }

  @Test
  @DisplayName("회원을 id값을 통해 제거한다.")
  public void delete() {
    // given
    SignUpRequest member = new SignUpRequest("cobi", "cobi@naver.com", "spring!password");
    Long memberId = memberService.join(member);

    // when
    memberService.delete(memberId);

    // then
    assertThatThrownBy(() -> memberService.findById(memberId))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("회원 username 중복체크")
  public void joinValidation() throws Exception {
    // given
    SignUpRequest signUpRequest = new SignUpRequest("cobi", "cobi@naver.com", "spring!password");
    memberService.join(signUpRequest);

    // when
    SignUpRequest signUpRequest2 = new SignUpRequest("cobi", "cobi98@naver.com", "spring!password");

    // then
    assertThrows(
        IllegalStateException.class,
        () -> {
          memberService.join(signUpRequest2);
        });
  }
}
