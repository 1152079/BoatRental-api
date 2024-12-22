package com.example.boatrentalApi.dtos;

import com.example.boatrentalApi.dtos.enums.BoatStatus;
import com.example.boatrentalApi.dtos.enums.BoatType;

import java.time.LocalDate;

public record BoatResponse(
        String name,
        String description,
        BoatType type,
        Integer capacity,
        BoatStatus status,
        Double pricePerHour,
        LocalDate createdAt,
        LocalDate repairAt)
{ }
