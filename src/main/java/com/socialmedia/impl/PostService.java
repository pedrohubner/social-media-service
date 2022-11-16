package com.socialmedia.impl;

import com.socialmedia.common.model.request.PostRequest;
import com.socialmedia.common.model.response.PostResponse;
import com.socialmedia.impl.mapper.PostResponseMapper;
import com.socialmedia.integration.PostRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository repository;

    @CachePut(value = "posts", key = "T(org.springframework.cache.interceptor.SimpleKey).EMPTY")
    public List<PostResponse> createPost(PostRequest postRequest) {
        savePost(postRequest);
        return collectPosts();
    }

    @Cacheable(value = "posts", key = "#id")
    public PostResponse getPostById(Integer id) {
        return repository.findById(id)
                .orElseThrow(null);
    }

    @Cacheable(value = "posts")
    public List<PostResponse> getPosts() {
        return collectPosts();
    }

    @CacheEvict(value = "posts", allEntries = true)
    public List<PostResponse> deletePost(Integer id) {
        repository.deleteById(id);
        return collectPosts();
    }

    private void savePost(PostRequest postRequest) {
        PostResponse post = PostResponseMapper.mapToPost(postRequest);
        repository.save(post);
    }

    private List<PostResponse> collectPosts() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
