package com.naisilva.oticanordestina.infrastructure.user.controller;

import com.naisilva.oticanordestina.entity.user.exception.UserNotFoundException;
import com.naisilva.oticanordestina.entity.user.model.User;
import com.naisilva.oticanordestina.usecase.user.GetUserByIdUsecase;
import com.naisilva.oticanordestina.usecase.user.GetUserByIdUsecase.Input;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("/users")
public class GetUserByIdController {
    private final GetUserByIdUsecase getUserByIdUsecase;

    public GetUserByIdController (GetUserByIdUsecase getUserByIdUsecase) {
        this.getUserByIdUsecase = getUserByIdUsecase;
    }

    @GetMapping("/{id}")
    public Response getUserById(@PathVariable Long id) throws UserNotFoundException {
        var outPut = getUserByIdUsecase.execute(new Input(id));

        return new Response(outPut.user());
    }

    public record Response(
            User user
    ) { }
}
