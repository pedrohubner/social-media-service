package com.socialmedia.common.model.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ApiException extends RuntimeException {
    private String message;
    private HttpStatus status;
    private String suggestion;
}
