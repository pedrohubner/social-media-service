package com.socialmedia.integration;

import com.socialmedia.common.model.response.PostResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<PostResponse, Integer> {
}
