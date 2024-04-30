package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.secvices.BouquetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.IOException;

@Controller

public class BouquetController {
    @Autowired
    private final BouquetService bouquetService;

    public BouquetController(BouquetService bouquetService) {
        this.bouquetService = bouquetService;
    }

    @GetMapping("/find_bouquet_by_name")
    public String bouquets(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("foundBouquetsByName", bouquetService.listAllBouquetsByName(name));
        model.addAttribute("allBouquets", bouquetService.listAllBouquets());
        return "admin";
    }

    @GetMapping("/admin")
        public String admin(Model model){
        model.addAttribute("allBouquets", bouquetService.listAllBouquets());
        return "admin";
    }

    @GetMapping("/bouquet/{id}")
    public String bouquet(@PathVariable Long id, Model model){
        Bouquet bouquet = bouquetService.getBouquetByID(id);
        model.addAttribute("bouquet", bouquet);
        return "bouquet";
    }

    @PostMapping("/bouquet_create")
    public String createBouquet(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3, Bouquet bouquet,
                                RedirectAttributes redirectAttributes) throws IOException {
        try {
            bouquetService.saveBouquet(bouquet, file1, file2, file3);
            redirectAttributes.addFlashAttribute("message", "Букет успешно сохранен");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при сохранении букета");
        }
        return "redirect:/admin";
    }


    @PostMapping("/bouquet_delete/{id}")
    public String deleteBouquet(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            bouquetService.deleteBouquet(id);
            redirectAttributes.addFlashAttribute("message", "Букет успешно удален");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при удалении букета");
        }
        return "redirect:/admin";
    }


}
