package com.springsecurityapp.service.impl;

import com.springsecurityapp.model.Role;
import com.springsecurityapp.model.Status;
import com.springsecurityapp.model.User;
import com.springsecurityapp.repository.UserRepository;
import com.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;
    UserDetailsService userDetailsService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService) {
        this.userRepository = userRepository;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void registration(User user) {
        user.setRole(Role.USER);
        user.setStatus(Status.ACTIVE);
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        userRepository.save(user);
        System.out.println(user);
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(12);
    }
}
