package com.socialmedia.contract;

import com.socialmedia.common.model.request.PostRequest;
import com.socialmedia.common.model.response.PostResponse;
import com.socialmedia.contract.facade.PostContractFacade;
import com.socialmedia.impl.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/post")
public class PostRestController {
    private final PostService service;
    private final PostContractFacade facade;

    @PostMapping
    public PostResponse createPost(@RequestBody PostRequest post) {
        return facade.createPost(post);
    }

    @GetMapping
    public List<PostResponse> getPosts() {
        return service.getPosts();
    }

    @GetMapping("/{id}")
    public PostResponse getPostById(@PathVariable Integer id) {
        return service.getPostById(id);
    }

    @DeleteMapping("/{postId}")
    public List<PostResponse> deletePost(@PathVariable Integer postId) {
        return service.deletePost(postId);
    }
}
