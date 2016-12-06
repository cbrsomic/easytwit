package com.lecture.projections;

import com.lecture.domain.Hashtag;
import com.lecture.domain.Post;
import org.springframework.data.rest.core.config.Projection;

import java.util.Set;

@Projection(name = "outgoingPost", types = {Post.class})
public interface OutgoingPost
{
  String getText();

  byte[] getImage();

  Set<Hashtag> getHashtags();
}
