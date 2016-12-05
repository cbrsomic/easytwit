package com.lecture;

import com.lecture.eventListeners.PostEventHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration
{
  @Bean
  PostEventHandler postEventHandler()
  {
    return new PostEventHandler();
  }
}
