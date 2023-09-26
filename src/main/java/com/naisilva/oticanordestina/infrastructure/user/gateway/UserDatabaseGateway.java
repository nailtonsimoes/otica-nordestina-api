package com.naisilva.oticanordestina.infrastructure.user.gateway;

import com.naisilva.oticanordestina.entity.user.gateway.UserGateway;
import com.naisilva.oticanordestina.entity.user.model.User;
import com.naisilva.oticanordestina.infrastructure.config.db.repository.UserRepository;
import com.naisilva.oticanordestina.infrastructure.config.db.schema.UserSchema;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDatabaseGateway implements UserGateway {

    private final UserRepository userRepository;

    public UserDatabaseGateway(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(new UserSchema(null, user.getName(), user.getEmail()));
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository
                .findById(id)
                .map((userSchema -> new User(
                        userSchema.getId(),
                        userSchema.getName(),
                        userSchema.getEmail()
                )));
    }

    @Override
    public void update(User user) {
        userRepository.save(new UserSchema(user.getId(), user.getName(), user.getEmail()));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
