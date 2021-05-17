package com.paypal.bfs.test.employeeserv;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

public class ValidationError {
	private final int status;
    private final String message;
    private List<FieldError> fieldErrors = new ArrayList<>();

    ValidationError(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void addFieldError(String path, String message) {
        FieldError error = new FieldError(path, message, message);
        fieldErrors.add(error);
    }

    public List<FieldError> getFieldErrors() {
        return fieldErrors;
    }
}
