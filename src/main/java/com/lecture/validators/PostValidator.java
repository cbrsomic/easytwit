package com.lecture.validators;

import com.lecture.domain.Post;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Arrays;
import java.util.List;


public class PostValidator implements Validator
{
  private List<String> abuses = Arrays.asList("PHP", "CMS", "JAVA6");

  @Override
  public boolean supports(Class<?> clazz)
  {
    return Post.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors)
  {
    Post post = (Post) target;
    if (abuses.stream().anyMatch(abuse -> post.getText().contains(abuse)))
    {
      errors.rejectValue("text", "Please don't use abuse words in description");
    }
  }
}
