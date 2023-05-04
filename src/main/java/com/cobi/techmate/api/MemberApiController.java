package com.cobi.techmate.api;

import com.cobi.techmate.dto.request.MemberRegisterRequest;
import com.cobi.techmate.dto.request.MemberUpdateRequest;
import com.cobi.techmate.service.MemberService;
import java.net.URI;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberApiController {

  private final MemberService memberService;

  @PostMapping
  public ResponseEntity<Void> createMember(
      @RequestBody @Valid MemberRegisterRequest memberRegisterRequest) {
    Long memberId = memberService.join(memberRegisterRequest.toServiceRequest());
    return ResponseEntity.created(URI.create("/api/v1/members" + memberId)).build();
  }

  @PutMapping("/{memberId}")
  public ResponseEntity<Void> updateMember(
      @PathVariable Long memberId, @RequestBody @Valid MemberUpdateRequest memberUpdateRequest) {
    memberService.updateUsername(memberId, memberUpdateRequest.getUsername());
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{memberId}")
  public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
    memberService.delete(memberId);
    return ResponseEntity.noContent().build();
  }
}
