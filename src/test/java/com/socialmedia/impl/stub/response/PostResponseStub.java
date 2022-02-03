package com.socialmedia.impl.stub.response;

import com.socialmedia.common.model.response.PostResponse;

import java.time.LocalDateTime;

public class PostResponseStub {
    public static PostResponse post() {
        return PostResponse.builder()
                .date(LocalDateTime.now().withSecond(0).withNano(0))
                .content("Hello, World!")
                .author("John Doe")
                .build();
    }
}
