package com.lecture.repository;

import com.lecture.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

public interface CommentRepository extends CrudRepository<Comment, Long>
{
  @RestResource(path = "findCommentByText", rel = "findCommentByText")
  Comment findCommentByText(@Param("text") String text);
}
