package com.example.contentmakerapi.service;

import com.example.contentmakerapi.controller.BadRequestException;

class UserServiceException extends BadRequestException {

    public UserServiceException(String failField) {
        super(String.format("The Services fail because : %s", failField));
    }
}
