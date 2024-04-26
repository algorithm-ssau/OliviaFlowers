package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.secvices.BouquetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class BouquetController {
    private final BouquetService bouquetService;

    @GetMapping("/")
    public String bouquets(Model model){
        model.addAttribute("bouquets", bouquetService.listAllBouquets());
        return "bouquets";
    }
    @GetMapping("/bouquet")
    public String bouquet(){
        return "bouquet";
    }

    @PostMapping("/bouquet/create")
    public String createBouquet(Bouquet bouquet){
        bouquetService.saveBouquet(bouquet);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteBouquet(@PathVariable Long id){
        bouquetService.deleteBouquet(id);
        return "redirect:/";
    }
}
