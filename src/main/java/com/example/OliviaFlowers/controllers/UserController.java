package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.User;
import com.example.OliviaFlowers.models.UserWithoutLink;
import com.example.OliviaFlowers.secvices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.getUserByEmail(username);
        model.addAttribute("isAdmin", user != null && user.getIsAdministrator());
        return "login";
    }

    @GetMapping("/registration")
    public String registration(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User user = userService.getUserByEmail(username);
        model.addAttribute("isAdmin", user != null && user.getIsAdministrator());
        return "registration";
    }
    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);
        model.addAttribute("message", isActivated ? "Пользователь активирован" : "Код не найден");
        return "login";
    }

    @PostMapping("/registration")
    public String createUser(UserWithoutLink userWithoutLink) {
        if (!userService.createUser(userWithoutLink)) {
            return "redirect:/registration?error";
        }
        model.addAttribute("message", "Сейчас вам на электронную почту придет код для активации");

        return "redirect:/login";
    }

}
