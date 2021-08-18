package com.joo.book.springboot.config.auth;

import com.joo.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
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
                .antMatchers("api/v1/**").hasRole(Role.USER.name())
                //나머지 url
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);

    }
}
