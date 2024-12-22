package com.example.boatrentalApi.dtos;


import com.example.boatrentalApi.dtos.enums.Role;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record UserRequest(
        @NotBlank(message = "Имя для пользователя обязательно")
        String name,
        @NotBlank(message = "Почта для пользователя обязательна")
        String email,
        String phone,
        @NotBlank(message = "Пароль для пользователя обязателен")
        String password,
        Role role,
        LocalDate registrationDate
)
{ }

