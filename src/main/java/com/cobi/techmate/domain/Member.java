package com.cobi.techmate.domain;

import com.cobi.techmate.enums.Platform;
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
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "member_id")
  private Long id;

  @Column(length = 20, nullable = false)
  private String username;

  @Column(length = 255, nullable = false)
  private String password;

  @Column(length = 255, nullable = false, unique = true)
  private String email;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "platform", nullable = false)
  private Platform platform;

  @Column(name = "platform_id", nullable = false)
  private String platformId;

  public Member(
      Long id,
      String username,
      String password,
      String email,
      Platform platform,
      String platformId) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.email = email;
    this.platform = platform;
    this.platformId = platformId;
  }
}
