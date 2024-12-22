package com.example.boatrentalApi.controllers;

import com.example.boatrentalApi.dtos.BoatRequest;
import com.example.boatrentalApi.dtos.BoatResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "boats")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface BoatApi {

    @Operation(summary = "Получить список всех лодок")
    @GetMapping(value = "/api/boats", produces = MediaType.APPLICATION_JSON_VALUE)
    List<BoatResponse> getAllBoats();

    @Operation(summary = "Создать новую лодку")
    @PostMapping(value = "/api/boats", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    BoatResponse createBoat(@Valid @RequestBody BoatRequest newBoat);

    @Operation(summary = "Получить лодку по имени")
    @GetMapping(value = "/api/boats/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    BoatResponse getBoatByName(@PathVariable("name") String name);

    @Operation(summary = "Обновить информацию о лодке")
    @PutMapping(value = "/api/boats/{name}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    BoatResponse updateBoat(@PathVariable("name") String name, @Valid @RequestBody BoatRequest boatRequest);

    @Operation(summary = "Удалить лодку по имени")
    @DeleteMapping(value = "/api/boats/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteBoat(@PathVariable("name") String name);
}
