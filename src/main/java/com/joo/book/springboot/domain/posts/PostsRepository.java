package com.joo.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//단순히 인터페이스생성한 후에 jpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD 메서드가 자동으로 생성된다.
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
