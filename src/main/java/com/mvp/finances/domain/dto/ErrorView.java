package com.mvp.finances.domain.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorView {
    private Integer status;
    private String error;
    private String message;
    private String path;
    private LocalDateTime timestamp = LocalDateTime.now();

    public ErrorView(Integer status, String error, String message, String path, LocalDateTime timestamp) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public String getMessage() {
        return message;
    }

    public String getPath() {
        return path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
