package com.socialmedia.impl;

import com.socialmedia.integration.PostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PostServiceTest {
    @Mock
    PostRepository repository;
    @InjectMocks
    PostService service;

//    @Test
//    void shouldCreatePost() {
//        PostResponse expected = PostResponseStub.post();
//        PostRequest postRequest = PostRequestStub.post();
//        Mockito.when(repository.save(expected)).thenReturn(expected);
//        PostResponse response = service.createPost(postRequest);
//        Assertions.assertEquals(expected, response);
//    }

//    @Test
//    void shouldGetPosts() {
//        PostResponse expected = PostResponseStub.post();
//        Mockito.when(repository.findAll()).thenReturn(IterableUtil.iterable(expected));
//        List<PostResponse> response = service.getPostById();
//        Assertions.assertEquals(List.of(expected), response);
//    }

    @Test
    void shouldDeletePost() {
        Integer postId = 1;
        Mockito.doNothing().when(repository).deleteById(postId);
        service.deletePost(postId);
        Mockito.verify(repository, Mockito.times(1)).deleteById(postId);
    }
}