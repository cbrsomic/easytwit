package com.lecture;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.core.mapping.RepositoryDetectionStrategy;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RepositoryConfiguration
{
  @Bean
  public RepositoryRestConfigurer repositoryRestConfigurer()
  {
    return new RepositoryRestConfigurerAdapter()
    {
      @Override
      public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config)
      {
        config.setRepositoryDetectionStrategy(RepositoryDetectionStrategy.RepositoryDetectionStrategies.DEFAULT);
      }
    };
  }
}
