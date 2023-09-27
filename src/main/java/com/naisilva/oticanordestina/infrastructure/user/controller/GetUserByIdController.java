package com.naisilva.oticanordestina.infrastructure.user.controller;

import com.naisilva.oticanordestina.entity.user.exception.UserNotFoundException;
import com.naisilva.oticanordestina.entity.user.model.User;
import com.naisilva.oticanordestina.usecase.user.GetUserByIdUsecase;
import com.naisilva.oticanordestina.usecase.user.GetUserByIdUsecase.Input;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@Tag(name = "Buscar usuario por ID")
public class GetUserByIdController {
    private final GetUserByIdUsecase getUserByIdUsecase;

    public GetUserByIdController (GetUserByIdUsecase getUserByIdUsecase) {
        this.getUserByIdUsecase = getUserByIdUsecase;
    }


    @GetMapping("/v1/users/{id}")
    @Operation(summary = "Get user by Id.", description = "Faz a busca de um usuario por seu ID")
    @ResponseStatus(HttpStatus.OK)
    public Response getUserById(@PathVariable Long id) throws UserNotFoundException {
        var outPut = getUserByIdUsecase.execute(new Input(new Request(id).id()));

        return new Response(outPut.user());
    }

    public record Response(
            User user
    ) { }

    public record Request(
            @NotNull
            Long id
    ) { }
}
