package com.naisilva.oticanordestina.infrastructure.config.user.controller;

import com.naisilva.oticanordestina.usecase.user.CreateUserUsecase;
import com.sun.istack.NotNull;
import lombok.experimental.NonFinal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController("/v1/users")
public class CreateUserController {

    private final CreateUserUsecase createUser;

    public CreateUserController (CreateUserUsecase createUser) {
        this.createUser = createUser;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser (@RequestBody Request request) {
        createUser.execute( new CreateUserUsecase.Input(request.name(), request.email()));
    }

    public  record Request(
            @NotNull
            String name,
            @NotNull
            String email) { }
}
