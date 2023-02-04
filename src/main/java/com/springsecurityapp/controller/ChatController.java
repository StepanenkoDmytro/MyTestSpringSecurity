package com.springsecurityapp.controller;

import com.springsecurityapp.model.Message;
import com.springsecurityapp.model.Permission;
import com.springsecurityapp.model.Role;
import com.springsecurityapp.model.User;
import com.springsecurityapp.service.MessageService;
import com.springsecurityapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/v1")
public class ChatController {
    MessageService messageService;
    UserService userService;

    @Autowired
    public ChatController(MessageService messageService, UserService userService) {
        this.messageService = messageService;
        this.userService = userService;
    }

    @GetMapping("/chat")
    public String main(@RequestParam(required = false, defaultValue = "") String filter,
                       Model model) {
        Iterable<Message> messages;
        if (filter != null && !filter.isEmpty()) {
            messages = messageService.getByTag(filter);
        } else {
            messages = messageService.getAllMessage();
        }
        model.addAttribute("messages", messages);
        model.addAttribute("filter", filter);

        return "chat";
    }

    @PostMapping("/chat")
    public String add(@AuthenticationPrincipal UserDetails user,
                      @RequestParam String text,
                      @RequestParam String tag,
                      Map<String, Object> model) {

//        System.out.println("Authorities: " + user.getAuthorities().toString());
//        System.out.println("Authorities: " + user.getAuthorities()
//                .stream().map(GrantedAuthority::getAuthority)
//                .collect(Collectors.toSet())
//                .contains("users:write"));

        User author = userService.getByEmail(user.getUsername()).orElseThrow(null);
        Message message = new Message(text, tag, author);
        messageService.saveMessage(message);

        Iterable<Message> messages = messageService.getAllMessage();

        model.put("messages", messages);

//        Set<Permission> permissions = author.getRole().getPermissions();
//        System.out.println(permissions.contains(Permission.USERS_WRITE));

        return "redirect:/api/v1/chat";
    }
}
