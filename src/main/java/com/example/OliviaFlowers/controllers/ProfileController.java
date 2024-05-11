package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.secvices.BouquetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProfileController {

    private final BouquetService bouquetService;

    @Autowired
    public ProfileController(BouquetService bouquetService) {
        this.bouquetService = bouquetService;
    }

    @GetMapping("/profile")
    public String profile(Model model) {
        List<Bouquet> allBouquets = bouquetService.listAllBouquets();
        model.addAttribute("allBouquets", allBouquets);
        return "profile";
    }
}
