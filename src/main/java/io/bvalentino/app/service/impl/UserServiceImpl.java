package io.bvalentino.app.service.impl;

import io.bvalentino.app.model.User;
import io.bvalentino.app.repository.UserRepository;
import io.bvalentino.app.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        var users = new ArrayList<User>();
        userRepository.findAll().forEach(users::add);

        return users;
    }

}
