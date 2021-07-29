package com.example.contentmakerapi.service.exception;

public class ServiceException extends RuntimeException{

    public ServiceException(String msg){
        super(String.format("Reason for failure: %s", msg));

    }


}
