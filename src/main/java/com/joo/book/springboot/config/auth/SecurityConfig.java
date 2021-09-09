package com.joo.book.springboot.config.auth;

import com.joo.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity // 스프링 시큐리티 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                //h2-console 옵션 disable
                .headers().frameOptions().disable()
                .and()
                // url별 권한 관리 설정
                .authorizeRequests()
                .antMatchers("/", "/css/**", "/images/**", "js/**", "/h2-console/**").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                //나머지 url - 인증된 사용자들에게만 허용
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                // OAuth2 로그인 기능에 대한 여러 설정의 진입점
                .oauth2Login()
                // OAuth2 로그인 성공 이후 사용자 정보를 가져올 때의 설정을 담당
                .userInfoEndpoint()
                // 소셜 로그인 성공하고 나서 후속 조치를 진행할 UserService 인터페이스의 구현체를 등록
                // 로그인하고 사용자 정보 가져온 상태에서 추가로 진행하고자 하는 기능을 지원
                .userService(customOAuth2UserService);
    }
}
