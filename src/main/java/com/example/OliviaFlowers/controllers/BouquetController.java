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

    @GetMapping("/abouquet")
    public String bouquets(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("admin", bouquetService.listAllBouquets(name));
        return "admin";
    }

    @GetMapping("/admin")
        public String admin(){
            return "admin";
        }

    @GetMapping("/bouquet")
    public String bouquet(){
        return "bouquet";
    }

    @PostMapping("/admin/create")
    public String createBouquet(Bouquet bouquet){
        bouquetService.saveBouquet(bouquet);
        return "redirect:/admin";
    }

    @PostMapping("/admin/delete/{id}")
    public String deleteBouquet(@PathVariable Long id){
        bouquetService.deleteBouquet(id);
        return "redirect:/admin";
    }
}
