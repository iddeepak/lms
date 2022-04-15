package com.java.lms.util;

public class ErrorMessage {
    private String status;
    private String message;

    public ErrorMessage() {

    }

    public ErrorMessage(String status, String message) {
        this.status = status;
        this.message = message;

    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
