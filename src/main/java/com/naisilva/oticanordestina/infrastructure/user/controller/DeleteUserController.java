package com.naisilva.oticanordestina.infrastructure.user.controller;

import com.naisilva.oticanordestina.entity.user.exception.UserNotFoundException;
import com.naisilva.oticanordestina.usecase.user.DeleteUserUsecase;
import com.naisilva.oticanordestina.usecase.user.DeleteUserUsecase.Input;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Deletar Usuario")
public class DeleteUserController {
    private final DeleteUserUsecase deleteUserUsecase;

    public DeleteUserController(DeleteUserUsecase deleteUserUsecase) {
        this.deleteUserUsecase = deleteUserUsecase;
    }

    @GetMapping("/v1/users/delete/{id}")
    @Operation(summary = "Delete a user by Id.", description = "Deleta um usuario por seu ID")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id) throws UserNotFoundException {
        deleteUserUsecase.execute(new Input(id));
    }
}
