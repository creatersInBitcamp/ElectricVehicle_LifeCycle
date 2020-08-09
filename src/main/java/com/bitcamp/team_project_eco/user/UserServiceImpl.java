package com.bitcamp.team_project_eco.user;

import com.amazonaws.services.apigateway.model.Op;
import com.bitcamp.team_project_eco.utils.JpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

interface UserService extends JpaService<User> {
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

    @Override
    public Optional<User> findById(String id) {
        return userRepository.findById((long) Integer.parseInt(id));
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public int count() {
        return (int) userRepository.count();
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public boolean exists(String id) {
        return false;
    }
}
