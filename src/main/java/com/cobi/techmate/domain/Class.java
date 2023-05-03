package com.cobi.techmate.domain;

import com.cobi.techmate.enums.ClassStatus;
import com.cobi.techmate.enums.Difficulty;
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
@Getter
@Table(name = "class")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Class {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "class_id")
  private Long id;

  @Column(name = "class_title", length = 255, nullable = false)
  private String title;

  @Column(name = "class_content")
  private String content;

  @Enumerated(value = EnumType.STRING) // 강의수준
  @Column(name = "class_ difficulty", nullable = false)
  private Difficulty difficulty;

  @Enumerated(value = EnumType.STRING) // 강의개설여부
  @Column(name = "class_status", nullable = false)
  private ClassStatus classStatus;
}
