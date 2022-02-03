package com.socialmedia.impl.mapper;

import com.socialmedia.common.model.request.PostRequest;
import com.socialmedia.common.model.response.PostResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PostResponseMapper {
    public static PostResponse mapToPost(PostRequest postRequest) {
        return PostResponse.builder()
                .author(postRequest.getAuthor())
                .date(LocalDateTime.now().withSecond(0).withNano(0))
                .content(postRequest.getContent())
                .build();
    }
}
