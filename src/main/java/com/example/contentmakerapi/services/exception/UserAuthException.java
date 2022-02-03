package com.example.contentmakerapi.services.exception;

public class UserAuthException extends RuntimeException {
    public UserAuthException(String msg) {
        super(msg);
    }
}
