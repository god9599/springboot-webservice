package com.joo.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 메서드의 파라미터로 선언된 객체에서만 사용할 수 있다.
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
// 파일 자체를 어노테이션 클래스로 지정한다. LoginUser라는 어노테이션이 생성되었다고 보자.
public @interface LoginUser {

}
