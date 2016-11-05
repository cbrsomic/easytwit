package com.lecture.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.lecture.domain.Hashtag;

public interface HashtagRepository extends PagingAndSortingRepository<Hashtag, Long> {



}
