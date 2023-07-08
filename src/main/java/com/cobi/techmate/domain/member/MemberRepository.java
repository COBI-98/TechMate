package com.cobi.techmate.domain.member;

import com.cobi.techmate.domain.member.Member;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> { // type, id
  List<Member> findByUsername(
      String username); // findByxxx -> select m from Member m where m.name(xxx) = :name (xxx)

  Optional<Member> findByEmail(String email);
}
