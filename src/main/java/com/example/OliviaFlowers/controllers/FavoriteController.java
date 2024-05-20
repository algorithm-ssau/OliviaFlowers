package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.User;
import com.example.OliviaFlowers.secvices.FavoriteService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("/favorite")
    public String profile(Model model, @AuthenticationPrincipal User user) {
        List<Bouquet> favoriteBouquets = favoriteService.getFavoriteBouquetsByUser(user);
        model.addAttribute("favoriteBouquets", favoriteBouquets);
        model.addAttribute("currentUser", user);
        return "favorite";
    }

    @PostMapping("/remove_from_favorites")
    public String removeFromFavorites(@RequestParam Long bouquetId, @RequestParam Long userId) {
        favoriteService.removeFromFavorites(bouquetId, userId);
        return "redirect:/favorite";
    }
}
