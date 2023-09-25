package com.naisilva.oticanordestina.usecase.user;

import com.naisilva.oticanordestina.entity.user.gateway.UserGateway;
import com.naisilva.oticanordestina.entity.user.model.User;
import org.springframework.stereotype.Service;

@Service
public class CreateUserUsecase {
    private final UserGateway userGateway;

    public CreateUserUsecase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public void execute (Input input) {
        var user = new User(input.name(), input.email());

        userGateway.create(user);
    }

    public record Input(String name, String email) { }
}
