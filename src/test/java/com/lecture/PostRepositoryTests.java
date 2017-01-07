package com.lecture;

import com.google.common.base.Charsets;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.hateoas.MediaTypes;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class PostRepositoryTests
{
  private static final String CONTENT_TYPE = MediaTypes.HAL_JSON_VALUE + ";charset=UTF-8";

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  @Before
  public void setup()
  {
    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
  }

  @Test
  public void shouldGetProperJsonForFirstUser() throws Exception
  {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/posts/1"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(CONTENT_TYPE))
        .andExpect(jsonPath("text", equalTo("text in the post")))
        .andExpect(jsonPath("image", nullValue()))
        .andExpect(jsonPath("date", nullValue()))
        .andExpect(jsonPath("_links.hashtags").exists())
        .andExpect(jsonPath("_links.user").exists());
  }

  @Test
  public void shouldGetProperJsonForFirstUserProjection() throws Exception
  {
    this.mockMvc.perform(MockMvcRequestBuilders.get("/posts/1?projection=outgoingPost"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(CONTENT_TYPE))
        .andExpect(jsonPath("text", equalTo("text in the post")))
        .andExpect(jsonPath("image", nullValue()))
        .andExpect(jsonPath("date").doesNotExist())
        .andExpect(jsonPath("hashtags[0].text", equalTo("#SpringDataRest")));
  }

}
