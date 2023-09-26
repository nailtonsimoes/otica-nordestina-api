package com.naisilva.oticanordestina.entity.user.gateway;

import com.naisilva.oticanordestina.entity.user.model.User;

import java.util.List;
import java.util.Optional;

public interface UserGateway {
    void create(User user);
    Optional<User> findById(Long id);
    void update(User user);
    void delete(Long id);
    List<User> findAll();
}
