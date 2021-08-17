package com.joo.book.springboot.domain.posts;

import com.joo.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스. 카멜케이스가 언더스코어 네이밍으로 매칭됨.
public class Posts extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 스프링부트 2.0에서는 옵션을 추가해야 AI가 된다.
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
