package com.example.contentmakerapi.auth;

class UserAuthException extends RuntimeException {

    public UserAuthException(String failField) {
        super(String.format(" Authentication fail because %s", failField));
    }

    public UserAuthException() {

    }
}
