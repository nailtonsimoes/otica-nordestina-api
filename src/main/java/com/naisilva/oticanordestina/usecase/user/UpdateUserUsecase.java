package com.naisilva.oticanordestina.usecase.user;

import com.naisilva.oticanordestina.entity.user.exception.UserNotFoundException;
import com.naisilva.oticanordestina.entity.user.gateway.UserGateway;
import org.springframework.stereotype.Service;


@Service
public class UpdateUserUsecase {
    private final UserGateway userGateway;

    public UpdateUserUsecase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public void execute (Input input) throws UserNotFoundException {
        var user = userGateway
                .findById(input.id())
                .orElseThrow(UserNotFoundException::new);

        user.setName(input.name());
        user.setEmail(input.email());

        userGateway.update(user);
    }

    public record Input(Long id, String name, String email) { }
}
