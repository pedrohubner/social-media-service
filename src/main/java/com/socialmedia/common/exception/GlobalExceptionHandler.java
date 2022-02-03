package com.socialmedia.common.exception;

import com.socialmedia.common.model.response.ApiException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Objects;

@ControllerAdvice
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public static ApiException genericExceptionHandler(Exception e) {
        return buildException(e);
    }

    @ExceptionHandler(ApiException.class)
    public static ResponseEntity<ApiException> buildExceptionHandler(String message, HttpStatus status,
                                                                     String suggestion) {
        return ResponseEntity.status(status)
                .body(buildException(message, status, suggestion));
    }

    private static ApiException buildException(Exception e) {
        return ApiException.builder()
                .message("Ocorreu um erro inesperado")
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .suggestion(Objects.nonNull(e.getMessage()) ? e.getMessage() : null)
                .build();
    }

    private static ApiException buildException(String message, HttpStatus status, String suggestion) {
        return ApiException.builder()
                .message(message)
                .status(status)
                .suggestion(suggestion)
                .build();
    }
}
