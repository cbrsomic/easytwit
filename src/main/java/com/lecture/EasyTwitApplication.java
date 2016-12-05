package com.lecture;

import com.lecture.validators.PostValidator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@SpringBootApplication
public class EasyTwitApplication extends RepositoryRestConfigurerAdapter
{

  public static void main(String[] args)
  {
    SpringApplication.run(EasyTwitApplication.class, args);
  }

  @Override
  public void configureValidatingRepositoryEventListener(
      ValidatingRepositoryEventListener v)
  {
    v.addValidator("beforeCreate", new PostValidator());
  }
}
