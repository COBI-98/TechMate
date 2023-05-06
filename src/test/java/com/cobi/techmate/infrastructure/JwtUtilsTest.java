package com.cobi.techmate.infrastructure;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class JwtUtilsTest {

  @Autowired private JwtUtils jwtUtils;

  @Test
  @DisplayName("token 발급 테스트")
  public void createToken() throws Exception {
    // given
    Map<String, Object> payload = JwtUtils.payloadBuilder().setSubject("cobi@naver.com").build();

    // when
    String token = jwtUtils.createToken(payload);

    // then
    System.out.println(token);
    assertThat(token).isInstanceOf(String.class);
  }
}
