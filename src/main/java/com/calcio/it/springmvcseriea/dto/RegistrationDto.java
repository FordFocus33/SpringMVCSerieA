package com.calcio.it.springmvcseriea.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegistrationDto {
    private Long id;
    @NotEmpty(message = "Username must be not empty")
    private String username;
    @NotEmpty(message = "email must be not empty")
    private String email;
    @NotEmpty(message = "password must be not empty")
    private String password;
}
