package com.example.boatrentalApi.controllers;

import com.example.boatrentalApi.dtos.BookingRequest;
import com.example.boatrentalApi.dtos.BookingResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Tag(name = "bookings")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface BookingApi {

    @Operation(summary = "Получить список всех бронирований")
    @GetMapping(value = "/api/bookings", produces = MediaType.APPLICATION_JSON_VALUE)
    List<BookingResponse> getAllBookings();

    @Operation(summary = "Создать новое бронирование")
    @PostMapping(value = "/api/bookings", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    BookingResponse createBooking(@Valid @RequestBody BookingRequest newBooking);

    @Operation(summary = "Найти бронирование по ID")
    @GetMapping(value = "/api/bookings/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    BookingResponse getBookingById(@PathVariable("id") UUID id);

    @Operation(summary = "Обновить информацию о бронировании")
    @PutMapping(value = "/api/bookings/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    BookingResponse updateBooking(@PathVariable("id") UUID id, @Valid @RequestBody BookingRequest bookingRequest);

    @Operation(summary = "Удалить бронирование по ID")
    @DeleteMapping(value = "/api/bookings/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteBooking(@PathVariable("id") UUID id);
}
