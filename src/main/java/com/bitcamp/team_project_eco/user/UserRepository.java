package com.bitcamp.team_project_eco.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, CustomUserRepository {

    Optional<User> findByUserId(String userId);

    Optional<User> findByEmail(String email);
}
