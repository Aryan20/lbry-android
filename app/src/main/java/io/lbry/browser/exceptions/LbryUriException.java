package com.aryan.lbrybrowser.exceptions;

public class LbryUriException extends Exception {
    public LbryUriException() {
        super();
    }
    public LbryUriException(String message) {
        super(message);
    }
    public LbryUriException(String message, Throwable cause) {
        super(message, cause);
    }
}
