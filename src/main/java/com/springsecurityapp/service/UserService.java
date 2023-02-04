package com.springsecurityapp.service;

import com.springsecurityapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getByEmail(String email);
    void registration(User user);
    void saveUser(User user);
}
