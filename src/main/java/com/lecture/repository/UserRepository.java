package com.lecture.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import com.lecture.domain.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {



}
