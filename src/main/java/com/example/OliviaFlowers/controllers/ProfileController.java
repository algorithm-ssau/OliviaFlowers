package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.User;
import com.example.OliviaFlowers.secvices.BouquetService;
import com.example.OliviaFlowers.secvices.FavoriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProfileController {

    private final FavoriteService favoriteService;
    private final BouquetService bouquetService;

    @Autowired
    public ProfileController(FavoriteService favoriteService, BouquetService bouquetService) {
        this.favoriteService = favoriteService;

        this.bouquetService = bouquetService;
    }

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal User user) {
        List<Bouquet> favoriteBouquets = favoriteService.getFavoriteBouquetsByUser(user);
        model.addAttribute("favoriteBouquets", favoriteBouquets);
        model.addAttribute("currentUser", user);
        return "profile";
    }

    @PostMapping("/remove_from_favorites")
    public String removeFromFavorites(@RequestParam Long bouquetId, @RequestParam Long userId) {
        favoriteService.removeFromFavorites(bouquetId, userId);
        return "redirect:/profile";
    }


}
