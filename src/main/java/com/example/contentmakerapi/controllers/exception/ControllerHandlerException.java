package com.example.contentmakerapi.controllers.exception;

import com.example.contentmakerapi.services.exception.ServiceException;
import com.example.contentmakerapi.services.exception.UserAuthException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerHandlerException {

    @ExceptionHandler(value = {ServiceException.class})
    protected ResponseEntity<String>handleServiceException(ServiceException e){
        return ResponseEntity.status(ErrorCode.CHARACTER_SERVICE_FAIL.getCode()).body(e.getMessage());
    }

    @ExceptionHandler(value = {UserAuthException.class})
    protected ResponseEntity<String>handleAuthServiceException(UserAuthException e){
        return ResponseEntity.status(ErrorCode.NICKNAME_ALREADY_TAKEN.getCode()).body(e.getMessage());
    }

}
