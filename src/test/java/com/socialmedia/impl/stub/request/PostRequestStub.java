package com.socialmedia.impl.stub.request;

import com.socialmedia.common.model.request.PostRequest;

public class PostRequestStub {
    public static PostRequest post() {
        return PostRequest.builder()
                .author("John Doe")
                .content("Hello, World!")
                .build();
    }
}
