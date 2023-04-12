package com.example.redbook.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{

    private String resourceName;
    private String fieldName;

    public ResourceNotFoundException(String resourceName, String fieldName, long findValue) {
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.findValue = findValue;
    }

    public ResourceNotFoundException(String message, String resourceName, String fieldName, long findValue) {
        super(message);
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.findValue = findValue;
    }

    public ResourceNotFoundException(String message, Throwable cause, String resourceName, String fieldName, long findValue) {
        super(message, cause);
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.findValue = findValue;
    }

    public ResourceNotFoundException(Throwable cause, String resourceName, String fieldName, long findValue) {
        super(cause);
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.findValue = findValue;
    }

    public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String resourceName, String fieldName, long findValue) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.findValue = findValue;
    }

    private long findValue;

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public long getFindValue() {
        return findValue;
    }

    public void setFindValue(long findValue) {
        this.findValue = findValue;
    }

}
