package com.cobi.techmate.service.auth;

import com.cobi.techmate.domain.member.Member;
import com.cobi.techmate.service.member.MemberLoginRequest;
import com.cobi.techmate.service.auth.response.TokenResponse;
import com.cobi.techmate.exception.member.NoSuchMemberException;
import com.cobi.techmate.exception.member.PasswordMismatchException;
import com.cobi.techmate.infrastructure.JwtUtils;
import com.cobi.techmate.domain.member.MemberRepository;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthService {
  private final MemberRepository memberRepository;
  private final JwtUtils jwtUtils;

  @Transactional(readOnly = true)
  public TokenResponse login(final MemberLoginRequest loginRequest) {
    Member findMember =
        memberRepository
            .findByEmail(loginRequest.getEmail())
            .orElseThrow(NoSuchMemberException::new);

    validatePassword(findMember, loginRequest.getPassword());

    String token = issueToken(findMember);

    return TokenResponse.of(token);
  }

  private String issueToken(Member findMember) {
    Map<String, Object> payload =
        JwtUtils.payloadBuilder().setSubject(findMember.getEmail()).build();

    return jwtUtils.createToken(payload);
  }

  private void validatePassword(Member findMember, String password) {
    if (!findMember.checkPassword(password)) {
      throw new PasswordMismatchException();
    }
  }
}
