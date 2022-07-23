package com.mvp.finances.domain.exceptions;

public class NotFoundException extends RuntimeException {
    private String message;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String message) {
        super(message);
        this.message = message;
    }

    public NotFoundException(String message, Throwable err){
        super(message, err);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
