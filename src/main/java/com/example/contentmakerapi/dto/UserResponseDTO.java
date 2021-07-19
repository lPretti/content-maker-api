package com.example.contentmakerapi.dto;

import com.example.contentmakerapi.entity.User;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserResponseDTO {
    private User user;
}