package com.lecture.controllers;

import com.google.common.collect.Sets;
import com.lecture.domain.Hashtag;
import com.lecture.domain.Post;
import com.lecture.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RepositoryRestController
public class PostController
{
  private PostRepository postRepository;

  @Autowired
  public PostController(PostRepository postRepository)
  {
    this.postRepository = postRepository;
  }

  @PostMapping(value = "/posts")
  public ResponseEntity save(@RequestBody Post post)
  {
    if (post.getHashtags().isEmpty())
    {
      Hashtag hashtag = new Hashtag();
      hashtag.setText("#SpringDataRestLection");
      post.setHashtags(Sets.newHashSet(hashtag));
    }
    postRepository.save(post);

    return ResponseEntity.ok(post);
  }
}
