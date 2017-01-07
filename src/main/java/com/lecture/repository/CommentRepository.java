package com.lecture.repository;

import org.springframework.data.repository.CrudRepository;
import com.lecture.domain.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long>
{
}
