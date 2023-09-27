package com.naisilva.oticanordestina.infrastructure.user.controller;

import com.naisilva.oticanordestina.usecase.user.CreateUserUsecase;
import com.naisilva.oticanordestina.usecase.user.CreateUserUsecase.Input;
import com.sun.istack.NotNull;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Criar Usuario")
public class CreateUserController {

    private final CreateUserUsecase createUser;

    public CreateUserController (CreateUserUsecase createUser) {
        this.createUser = createUser;
    }

    @PostMapping("/v1/users/create")
    @Operation(summary = "Create User", description = "Cria um usuario aparti do seu nome e email.")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser (@RequestBody Request request) {
        createUser.execute( new Input(request.name(), request.email()));
    }

    public  record Request(
            @NotNull
            String name,
            @NotNull
            String email) { }
}
