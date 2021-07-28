package com.example.contentmakerapi.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    CHARACTER_SERVICE_FAIL(800);

    private final int code;
}
