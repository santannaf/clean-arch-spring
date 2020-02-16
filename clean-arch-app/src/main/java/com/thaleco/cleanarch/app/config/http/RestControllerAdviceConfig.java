package com.thaleco.cleanarch.app.config.http;

import com.thaleco.cleanarch.domain.usecase.exception.BusinessException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdviceConfig {
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorMessage> handleNotFoundException(final BusinessException ex) {
        return ResponseEntity.badRequest().body(new ErrorMessage(ex.getMessage()));
    }

    @Data
    @AllArgsConstructor
    private
    class ErrorMessage {

        private String message;
    }
}
