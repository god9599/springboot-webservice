package com.joo.book.springboot.service.posts;

import com.joo.book.springboot.domain.posts.dto.PostsListResponseDto;
import com.joo.book.springboot.domain.posts.dto.PostsResponseDto;
import com.joo.book.springboot.domain.posts.dto.PostsSaveRequestDto;
import com.joo.book.springboot.domain.posts.dto.PostsUpdateRequestDto;

import java.util.List;

public interface PostsService {

    Long save(PostsSaveRequestDto requestDto);

    Long update(Long id, PostsUpdateRequestDto requestDto);

    PostsResponseDto findById(Long id);

    void delete(Long id);

    List<PostsListResponseDto> findAllDesc();
}
