package com.lecture.eventListeners;

import com.google.common.collect.Sets;
import com.lecture.domain.Hashtag;
import com.lecture.domain.Post;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

@RepositoryEventHandler(Post.class)
public class PostEventHandler
{
  @HandleBeforeCreate
  public void onBeforeCreate(Post post)
  {
    if (post.getHashtags().isEmpty())
    {
      Hashtag hashtag = new Hashtag();
      hashtag.setText("#SpringDataRestLection");
      post.setHashtags(Sets.newHashSet(hashtag));
    }
  }
}
