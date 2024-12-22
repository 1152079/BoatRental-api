package com.example.boatrentalApi.dtos;

import com.example.boatrentalApi.dtos.enums.BookingStatus;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BookingRequest(
        @NotNull
        UUID id,
        @NotNull
        UUID userId,
        @NotNull
        UUID boatId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        BookingStatus status,
        BigDecimal totalPrice,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) { }
