package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.secvices.BouquetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import  org.springframework.ui.Model;
@Controller
@RequiredArgsConstructor
public class BouquetController {
    private final BouquetService bouquetService;

    @GetMapping("/bouquet")
    public String bouquet(Model model){
        model.addAttribute("bouquet", bouquetService.listBouquets());
        return "bouquet";
    }
}
