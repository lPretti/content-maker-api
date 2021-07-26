package com.example.contentmakerapi.service;

public class CharacterServiceException extends RuntimeException{
    public CharacterServiceException(String msg){
        super(String.format("The character Services fail because : %s", msg));
    }
}
