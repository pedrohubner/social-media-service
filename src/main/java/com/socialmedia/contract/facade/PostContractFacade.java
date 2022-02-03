package com.socialmedia.contract.facade;

import com.socialmedia.common.model.request.PostRequest;
import com.socialmedia.common.model.response.PostResponse;
import com.socialmedia.impl.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class PostContractFacade {
    private final PostService service;

    public PostResponse createPost(PostRequest post) {
        List<PostResponse> posts = service.createPost(post);
        return posts.get(posts.size() - 1);
    }
}
