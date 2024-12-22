package com.example.boatrentalApi.dtos;


import com.example.boatrentalApi.dtos.enums.BoatStatus;
import com.example.boatrentalApi.dtos.enums.BoatType;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;


public record BoatRequest(
        @NotBlank(message = "Название для лодки обязательно")
        String name,
        @NotBlank(message = "Описание для лодки обязательно")
        String description,
        @NotBlank(message = "Тип для лодки обязателен")
        BoatType type,
        @NotBlank(message = "Вместительность для лодки обязательна")
        Integer capacity,
        @NotBlank(message = "Статус для лодки обязателен")
        BoatStatus status,
        @NotBlank(message = "Цена аренды для лодки обязательна")
        Double pricePerHour,
        LocalDate createdAt,
        LocalDate repairAt
) { }
