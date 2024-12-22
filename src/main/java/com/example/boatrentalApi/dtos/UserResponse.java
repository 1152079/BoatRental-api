package com.example.boatrentalApi.dtos;

import com.example.boatrentalApi.dtos.enums.Role;

import java.time.LocalDate;

public record UserResponse(
        String name,
        String email,
        String phone,
        String password,
        Role role,
        LocalDate registrationDate
)
{ }

