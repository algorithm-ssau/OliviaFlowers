package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.User;
import com.example.OliviaFlowers.secvices.BouquetService;
import com.example.OliviaFlowers.secvices.FavoriteService;
import com.example.OliviaFlowers.secvices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProfileController {

    private final FavoriteService favoriteService;
    private final BouquetService bouquetService;
    private final UserService userService;

    @Autowired
    public ProfileController(FavoriteService favoriteService, BouquetService bouquetService, UserService userService) {
        this.favoriteService = favoriteService;
        this.bouquetService = bouquetService;
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal User user) {
        List<Bouquet> favoriteBouquets = favoriteService.getFavoriteBouquetsByUser(user);
        model.addAttribute("favoriteBouquets", favoriteBouquets);
        model.addAttribute("currentUser", user);

        //проверка пользователя администратор он или нет
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Пользователь аутентифицирован, можно получить его имя пользователя или другой идентификатор
        String username = authentication.getName(); // Получить имя пользователя
        User user1 = userService.getUserByEmail(username);
        if (user1 != null){ model.addAttribute("isAdmin", user.getIsAdministrator());}
        else{ model.addAttribute("isAdmin", false);}

        return "profile";
    }

    @PostMapping("/remove_from_favorites")
    public String removeFromFavorites(@RequestParam Long bouquetId, @RequestParam Long userId) {
        favoriteService.removeFromFavorites(bouquetId, userId);
        return "redirect:/profile";
    }

    @PostMapping("/add_to_favorites")
    @PreAuthorize("isAuthenticated()")
    public String addToFavorites(@RequestParam Long bouquetId, @AuthenticationPrincipal User user) {
        Bouquet bouquet = bouquetService.getBouquetByID(bouquetId);
        favoriteService.saveFavorite(user, bouquet);
        return "redirect:/profile";
    }

}
