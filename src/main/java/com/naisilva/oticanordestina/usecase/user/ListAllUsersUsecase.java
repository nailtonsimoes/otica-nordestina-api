package com.naisilva.oticanordestina.usecase.user;

import com.naisilva.oticanordestina.entity.user.exception.UserNotFoundException;
import com.naisilva.oticanordestina.entity.user.gateway.UserGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListAllUsersUsecase {

    private final UserGateway userGateway;

    public ListAllUsersUsecase(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public List<Output> execute() {
        var users = userGateway.findAll();

        return users.stream().map(
                user -> new Output(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                )
        ).toList();
    }

    public record Output(Long id, String name, String email) {
    }
}
