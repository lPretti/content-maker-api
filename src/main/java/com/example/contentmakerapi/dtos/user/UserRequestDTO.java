package com.example.contentmakerapi.dtos.user;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    private String username;
    private String password;
}
