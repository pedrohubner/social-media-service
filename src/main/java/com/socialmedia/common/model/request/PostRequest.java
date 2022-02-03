package com.socialmedia.common.model.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    @NonNull
    private String author;
    @NonNull
    private String content;
}
