package com.cobi.techmate.api;

import com.cobi.techmate.dto.request.MemberLoginRequest;
import com.cobi.techmate.dto.response.TokenResponse;
import com.cobi.techmate.service.AuthService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/member")
@RequiredArgsConstructor
public class AuthApiController {

  private final AuthService authService;

  @PostMapping("/login/token")
  public ResponseEntity<TokenResponse> login(
      @RequestBody @Valid final MemberLoginRequest loginRequest) {
    return ResponseEntity.ok().body(authService.login(loginRequest));
  }
}
