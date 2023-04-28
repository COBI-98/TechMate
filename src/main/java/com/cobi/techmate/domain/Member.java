package com.cobi.techmate.domain;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Member {

  @Id
  @GeneratedValue
  @Column(name = "member_id")
  private Long id;

  //    @NotEmpty 별도의 dto를 활용하여 설정해주는것이 정석
  @Column(name = "username")
  private String username;

  private String password;

  private String email;

  private String phone_number;

  private Date date_joined; // 계정 생성일

  private Date last_login;
}
