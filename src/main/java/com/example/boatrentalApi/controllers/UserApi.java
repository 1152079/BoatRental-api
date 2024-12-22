package com.example.boatrentalApi.controllers;

import com.example.boatrentalApi.dtos.UserRequest;
import com.example.boatrentalApi.dtos.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Tag(name = "users")
@ApiResponses({
        @ApiResponse(responseCode = "200", description = "Успешная обработка запроса"),
        @ApiResponse(responseCode = "400", description = "Ошибка валидации"),
        @ApiResponse(responseCode = "404", description = "Ресурс не найден"),
        @ApiResponse(responseCode = "500", description = "Внутренняя ошибка сервера")
})
public interface UserApi {

    @Operation(summary = "Получить всех пользователей")
    @GetMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    List<UserResponse> getAllUsers();

    @Operation(summary = "Создать пользователя")
    @PostMapping(value = "/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
    UserResponse createUser(@Valid @RequestBody UserRequest newUserRequest);

    @Operation(summary = "Найти пользователя по email")
    @GetMapping(value = "/api/users/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserResponse getUserByEmail(@PathVariable("email") String email);

    @Operation(summary = "Обновить информацию о пользователе")
    @PutMapping(value = "/api/users/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    UserResponse updateUser(
            @PathVariable("email") String email,
            @Valid @RequestBody UserRequest userRequest);

    @Operation(summary = "Удалить пользователя")
    @DeleteMapping(value = "/api/users/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
    Map<String, Object> deleteUser(@PathVariable("email") String email);
}
