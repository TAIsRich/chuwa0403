package com.chuwa.redbook.exception;

import org.springframework.http.HttpStatus;

public class BlogAPIException extends RuntimeException {
    private HttpStatus httpStatus;
    private String message;
    public BlogAPIException(HttpStatus httpStatus, String message, String message1) {
        super(message);
        this.message = message1;
        this.httpStatus = httpStatus;
    }

    public BlogAPIException(HttpStatus httpStatus, String message) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
