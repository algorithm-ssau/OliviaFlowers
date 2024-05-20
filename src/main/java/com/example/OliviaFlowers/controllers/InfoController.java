package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.User;
import com.example.OliviaFlowers.secvices.BouquetService;
import com.example.OliviaFlowers.secvices.FavoriteService;
import com.example.OliviaFlowers.secvices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class InfoController {
    private final FavoriteService favoriteService;
    private final BouquetService bouquetService;
    private final UserService userService;

    @Autowired
    public InfoController(FavoriteService favoriteService, BouquetService bouquetService, UserService userService) {
        this.favoriteService = favoriteService;
        this.bouquetService = bouquetService;
        this.userService = userService;
    }

    @GetMapping("/info")
    public String profile(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("currentUser", user);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            // Пользователь аутентифицирован, можно получить его имя пользователя или другой идентификатор
            String username = authentication.getName(); // Получить имя пользователя
            User user1 = userService.getUserByEmail(username);
            model.addAttribute("isAdmin", user1.getIsAdministrator());
        }

        return "info";
    }

    @PostMapping("/info/update")
    public String updateProfile(@AuthenticationPrincipal User currentUser,
                                @RequestParam String name,
                                @RequestParam String surname,
                                Model model) {
        currentUser.setName(name);
        currentUser.setSurname(surname);
        userService.save(currentUser);  // Make sure your UserService has a save method to update the user
        model.addAttribute("currentUser", currentUser);
        return "redirect:/info";  // Redirect to avoid form resubmission
    }
}
