package com.thaleco.cleanarch.domain.usecase.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(final String message) {
        super(message);
    }
}
