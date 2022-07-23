package com.mvp.finances.domain.exceptions;

import com.mvp.finances.domain.dto.ErrorView;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorView handleNotFoundExpection(NotFoundException exception, HttpServletRequest request) {
        return new ErrorView(HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name(),  exception.getMessage(), request.getServletPath(), LocalDateTime.now());
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorView globalExceptionHandler(
            Exception exception,
            HttpServletRequest request
    ) {
        return new ErrorView(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name(),  exception.getMessage(), request.getServletPath(), LocalDateTime.now());
    }
}
