package com.cobi.techmate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "community") // 게시판
public class Community {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "community_id")
  private Long id;

  @Column(name = "community_title", nullable = false)
  private String title;

  @Column(name = "community_comment", nullable = false)
  private String comment;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "community_type")
  private Community community;
}
