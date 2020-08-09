package com.bitcamp.team_project_eco.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

interface UserService {
    Optional<User> findUserByUserId(String user);
}

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserByUserId(String user) {
        Optional<User> idCheck = userRepository.findByUserId(user);
        return idCheck;
    }
}
