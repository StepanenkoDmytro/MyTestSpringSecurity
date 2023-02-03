package com.springsecurityapp.controller;

import com.springsecurityapp.model.User;
import com.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/auth")
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model) {
        Optional<User> userFromDb = userService.getByEmail(user.getEmail());
        if (userFromDb.isPresent()) {
            model.put("message", "User exists!");
            return "registration";
        }
        userService.registration(user);
        return "redirect:/auth/login";
    }
}
