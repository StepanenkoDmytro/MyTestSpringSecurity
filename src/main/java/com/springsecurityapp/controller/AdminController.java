package com.springsecurityapp.controller;

import com.springsecurityapp.model.Role;
import com.springsecurityapp.model.User;
import com.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/v1/admin")
@PreAuthorize("hasAuthority('users:write')")
public class AdminController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String userList(Model model){
        List<User> listUsers = userService.getAllUsers();
        model.addAttribute("listUsers", listUsers);
        return "admin-userList";
    }

    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        return "user-edit";
    }

    @PostMapping
    public String userSave(@RequestParam String firstName,
                           @RequestParam Map<String, String> form,
                           @RequestParam("id") User user){
        user.setFirstName(firstName);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        for(String key : form.keySet()){
            String value = form.get(key);
            if(roles.contains(value)){
                user.setRole(Role.valueOf(value));
            }
        }
        userService.saveUser(user);
        return "redirect:/api/v1/admin";
    }
}
