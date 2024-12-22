package com.example.boatrentalApi.dtos;

import com.example.boatrentalApi.dtos.enums.BookingStatus;
import org.hibernate.validator.constraints.UUID;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BookingResponse(
        UUID id,
        UUID userId,
        UUID boatId,
        LocalDateTime startTime,
        LocalDateTime endTime,
        BookingStatus status,
        BigDecimal totalPrice,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
