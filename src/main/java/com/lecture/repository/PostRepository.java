package com.lecture.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.lecture.domain.Post;

public interface PostRepository extends PagingAndSortingRepository<Post, Long> {



}
