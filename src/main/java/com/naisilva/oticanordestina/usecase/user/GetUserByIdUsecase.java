package com.naisilva.oticanordestina.usecase.user;

import com.naisilva.oticanordestina.entity.user.exception.UserNotFoundException;
import com.naisilva.oticanordestina.entity.user.gateway.UserGateway;
import com.naisilva.oticanordestina.entity.user.model.User;

public class GetUserByIdUsecase {
    private final UserGateway userGateway;

    public GetUserByIdUsecase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public Output execute(Input input) throws UserNotFoundException {
        var user = userGateway
                .findById(input.id())
                .orElseThrow(UserNotFoundException::new);

        return new Output(user);
    }

    public record Input (Long id) { }
    public record Output(User user) { }
}
