package com.lecture.repository;

import com.lecture.domain.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.ZonedDateTime;

public interface PostRepository extends PagingAndSortingRepository<Post, Long>
{
  @RestResource(path = "findPostByDate", rel = "findPostByDate")
  Page findPostByDate(
      @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) @Param("date") ZonedDateTime date,
      Pageable p);
}
