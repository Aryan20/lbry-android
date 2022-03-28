package com.aryan.lbrybrowser.exceptions;

public class LbryRequestException extends Exception {
    public LbryRequestException() {
        super();
    }
    public LbryRequestException(String message) {
        super(message);
    }
    public LbryRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
