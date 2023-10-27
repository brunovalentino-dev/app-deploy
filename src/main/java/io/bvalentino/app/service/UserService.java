package io.bvalentino.app.service;

import io.bvalentino.app.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();

}
