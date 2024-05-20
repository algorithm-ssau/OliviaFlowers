package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.User;
import com.example.OliviaFlowers.secvices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class UserController {
    @Autowired
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        //проверка пользователя администратор он или нет
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Пользователь аутентифицирован, можно получить его имя пользователя или другой идентификатор
        String username = authentication.getName(); // Получить имя пользователя
        User user = userService.getUserByEmail(username);
        if (user != null){ model.addAttribute("isAdmin", user.getIsAdministrator());}
        else{ model.addAttribute("isAdmin", false);}

        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        //проверка пользователя администратор он или нет
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Пользователь аутентифицирован, можно получить его имя пользователя или другой идентификатор
        String username = authentication.getName(); // Получить имя пользователя
        User user = userService.getUserByEmail(username);
        if (user != null){ model.addAttribute("isAdmin", user.getIsAdministrator());}
        else{ model.addAttribute("isAdmin", false);}

        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user) {
        userService.createUser(user);
        return "redirect:/login";
    }

}
