package com.cobi.techmate.domain.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long id;

  @Column(length = 20, nullable = false)
  private String username;

  @Column(length = 255, nullable = false, unique = true)
  private String email;

  @Column(length = 255, nullable = false)
  private String password;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "member_role", nullable = false)
  private Role role;

  //  @Enumerated(value = EnumType.STRING)
  //  @Column(name = "platform", nullable = false)
  //  private Platform platform;
  //
  //  @Column(name = "platform_id", nullable = false)
  //  private String platformId;

  public Member(String username, String email, String password) {
    //      Platform platform,
    //      String platformId) {
    this.username = username;
    this.email = email;
    this.password = password;
    this.role = Role.STUDENT;
    //    this.platform = platform;
    //    this.platformId = platformId;
  }

  public void changeUsername(final String username) {
    this.username = username;
  }

  public boolean checkPassword(String password) {
    return this.password.equals(password);
  }
}
