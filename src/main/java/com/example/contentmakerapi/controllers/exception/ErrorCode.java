package com.example.contentmakerapi.controllers.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    CHARACTER_SERVICE_FAIL(800),
    NICKNAME_ALREADY_TAKEN(801);

    private final int code;
}
