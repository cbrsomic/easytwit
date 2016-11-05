package com.lecture.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.lecture.domain.Comment;

public interface CommentRepository extends PagingAndSortingRepository<Comment, Long> {



}
