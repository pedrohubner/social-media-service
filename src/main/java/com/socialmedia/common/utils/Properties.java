package com.socialmedia.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@AllArgsConstructor
public class Properties {
    @Value("${error.message.post-not-found}")
    private String postNotFoundMessage;
    @Value("${error.suggestion.post-not-found}")
    private String postNotFoundSuggestion;
}
