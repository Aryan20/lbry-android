package com.aryan.lbrybrowser.exceptions;

public class LbryResponseException extends Exception {
    public LbryResponseException() {
        super();
    }
    public LbryResponseException(String message) {
        super(message);
    }
    public LbryResponseException(String message, Throwable cause) {
        super(message, cause);
    }
}
