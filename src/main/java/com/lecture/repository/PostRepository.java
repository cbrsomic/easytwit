package com.lecture.repository;

import com.lecture.domain.Post;
import com.lecture.projections.OutgoingPost;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = OutgoingPost.class)
public interface PostRepository extends CrudRepository<Post, Long>
{
}
