package com.bitcamp.team_project_eco.user;

import com.amazonaws.services.apigateway.model.Op;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
interface UserService {
    Optional<User> findUserByUserId(String user);
}

@Service
public class UserServiceImpl implements UserService{

    @Autowired UserRepository userRepository;

    @Override
    public Optional<User> findUserByUserId(String user) {
        Optional<User> idCheck = userRepository.findByUserId(user);
        return idCheck;
    }
}
