package com.example.contentmakerapi.controller.exception;

import com.example.contentmakerapi.service.exception.ServiceException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerHandlerException {

    @ExceptionHandler(value = {ServiceException.class})
    protected ResponseEntity<String>handleCharacterServiceException(ServiceException e){
        return ResponseEntity.status(ErrorCode.CHARACTER_SERVICE_FAIL.getCode()).body(e.getMessage());
    }


}
