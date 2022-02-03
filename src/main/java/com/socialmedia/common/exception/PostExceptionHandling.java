package com.socialmedia.common.exception;

import com.socialmedia.common.model.response.ApiException;
//import com.socialmedia.common.utils.Properties;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PostExceptionHandling {
//    private final Properties properties;

    public ApiException buildPostNotFoundException() {
        return new ApiException("properties.getPostNotFoundMessage()", HttpStatus.NOT_FOUND,
                "properties.getPostNotFoundSuggestion()");
    }
}
