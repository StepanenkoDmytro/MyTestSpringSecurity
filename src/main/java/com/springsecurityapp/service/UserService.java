package com.springsecurityapp.service;

import com.springsecurityapp.model.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getByEmail(String email);
    void registration(User user);
}
