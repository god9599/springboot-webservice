package com.joo.book.springboot.config.auth.dto;

import com.joo.book.springboot.domain.user.User;
import lombok.Getter;

@Getter
// SessionUser에는 인증된 사용자 정보만 필요
public class SessionUser {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
