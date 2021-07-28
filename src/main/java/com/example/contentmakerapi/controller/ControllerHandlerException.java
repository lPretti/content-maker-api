package com.example.contentmakerapi.controller;

import com.example.contentmakerapi.service.CharacterServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerHandlerException {

    @ExceptionHandler(value = {CharacterServiceException.class})
    protected ResponseEntity<String>handleCharacterServiceException(CharacterServiceException e){
        return ResponseEntity.status(ErrorCode.CHARACTER_SERVICE_FAIL.getCode()).body(e.getMessage());
    }


}
