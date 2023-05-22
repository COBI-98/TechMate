package com.cobi.techmate.config;

import org.springframework.context.annotation.Configuration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

  //  @Bean
  //  public BCryptPasswordEncoder bCryptPasswordEncoder() {
  //    return new BCryptPasswordEncoder();
  //  }
  //
  //
  //  @Bean
  //  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
  //    http.cors()
  //        .and() // be, fe cors 처리
  //        .csrf()
  //        .disable()
  //        .headers()
  //        .frameOptions()
  //        .disable()
  //        .and()
  //        .authorizeRequests()
  //        .antMatchers(
  //            "/",
  //            "/**/*.png",
  //            "/**/*.jpg",
  //            "/**/*.js",
  //            "/**/*.css",
  //            "/**/*.html",
  //            "/**/*.gif",
  //            "/**/*.svg",
  //            "/signup",
  //            "/signup/**",
  //            "/signin")
  //        .permitAll()
  //        .antMatchers(
  //            HttpMethod.GET,
  //            "/hello/**",
  //            "/class",
  //            "/class/**",
  //            "/community",
  //            "/community/**",
  //            "/comment",
  //            "/commnet/**")
  //        .permitAll()
  //        .antMatchers(HttpMethod.PATCH, "/class/**")
  //        .hasRole("ADMIN") // ADMIN이라고 작성하면 자동으로 ROLE_ADMIN으로 검색이 이루어진다
  //        .antMatchers(HttpMethod.DELETE, "/class/**")
  //        .hasRole("ADMIN") // ADMIN 권한을 가진 경우에만 접근 허용
  //        .anyRequest()
  //        .authenticated(); // 위를 제외한 다른 모든 요청은 권한 확인
  //    //                .and()
  //    //                .formLogin()
  //    //                .loginProcessingUrl("/signin");
  //    return http.build();
  //  }
}
