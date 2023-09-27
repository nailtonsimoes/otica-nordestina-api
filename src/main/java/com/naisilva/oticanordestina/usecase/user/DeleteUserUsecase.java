package com.naisilva.oticanordestina.usecase.user;

import com.naisilva.oticanordestina.entity.user.exception.UserNotFoundException;
import com.naisilva.oticanordestina.entity.user.gateway.UserGateway;
import org.springframework.stereotype.Service;

@Service
public class DeleteUserUsecase {

    private final UserGateway userGateway;

    public DeleteUserUsecase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public void execute(Input input) throws UserNotFoundException {
        var user = userGateway
                .findById(input.id())
                .orElseThrow(UserNotFoundException::new);

        userGateway.delete(user.getId());
    }

    public record Input (Long id) { }
}
