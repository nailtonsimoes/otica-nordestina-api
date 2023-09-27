package com.naisilva.oticanordestina.infrastructure.user.controller;

import com.naisilva.oticanordestina.entity.user.exception.UserNotFoundException;
import com.naisilva.oticanordestina.usecase.user.UpdateUserUsecase;
import com.naisilva.oticanordestina.usecase.user.UpdateUserUsecase.Input;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Atualizar Usuario")
public class UpdateUserController {

    private final UpdateUserUsecase updateUserUsecase;

    public UpdateUserController(UpdateUserUsecase updateUserUsecase) {
        this.updateUserUsecase = updateUserUsecase;
    }

    @PutMapping("/v1/users/update/{id}")
    @Operation(summary = "Update a user by Id.", description = "Atualiza um usuario por seu ID")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser (@PathVariable Long id, @RequestBody Request request) throws UserNotFoundException {
        updateUserUsecase.execute(new Input(id, request.name(), request.email()));
    }


    public record Request(
            @NotNull
            String name,
            @NotNull
            String email) {
    }
}
