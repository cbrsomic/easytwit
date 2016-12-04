package com.lecture.repository;

import com.lecture.domain.Hashtag;
import org.springframework.data.repository.CrudRepository;

public interface HashtagRepository extends CrudRepository<Hashtag, Long>
{
}
