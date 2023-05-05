package com.cobi.techmate.service;

import com.cobi.techmate.domain.Member;
import com.cobi.techmate.dto.SignUpRequest;
import com.cobi.techmate.dto.response.MemberResponse;
import com.cobi.techmate.repository.MemberRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

  private final MemberRepository memberRepository;

  // CREATE
  public Long join(final SignUpRequest signUpRequest) {
    validateDuplicateMember(signUpRequest); // 중복 회원 검증
    //    memberRepository.save(member);
    return memberRepository.save(signUpRequest.toEntity()).getId();
  }

  private void validateDuplicateMember(final SignUpRequest signUpRequest) {
    List<Member> findMembers =
        memberRepository.findByUsername(
            signUpRequest.toEntity().getUsername()); // 멀티쓰레드 상황 고려 (db 유니크제약조건)
    if (!findMembers.isEmpty()) {
      throw new IllegalStateException("이미 존재하는 회원입니다.");
    }
  }

  // 회원 조회 READ
  @Transactional(readOnly = true)
  public MemberResponse findById(final Long memberId) {
    Member member =
        memberRepository
            .findById(memberId) // -> Optional로 받을수 있도록 한것을 값이 없을 경우 예외를 던져줌
            .orElseThrow(IllegalArgumentException::new);
    return MemberResponse.toEntity(member);
  }

  // 회원 전체 조회
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Member findOne(Long memberId) {
    return memberRepository.findById(memberId).get();
  }

  // 회원 수정 UPDATE
  public void updateUsername(final Long memberId, final String username) {
    Member member = memberRepository.findById(memberId).orElseThrow(IllegalArgumentException::new);
    member.changeUsername(username);
  }

  public void delete(final Long memberId) {
    memberRepository.delete(
        memberRepository
            .findById(memberId)
            . // id 찾고 null 인경우 exception
            orElseThrow(IllegalArgumentException::new));
  }
}
