package com.naisilva.oticanordestina.infrastructure.config.db.repository;

import com.naisilva.oticanordestina.infrastructure.config.db.schema.UserSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserSchema, Long> {
}
