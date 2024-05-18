package com.example.OliviaFlowers.controllers;

import ch.qos.logback.core.model.Model;
import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.Postcard;
import com.example.OliviaFlowers.secvices.PostcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class PostcardController {
    @Autowired
    private final PostcardService postcardService;

    public PostcardController(PostcardService postcardService) {
        this.postcardService = postcardService;
    }

    @PostMapping("/add_postcard")
    public String admin(@RequestParam("file") MultipartFile file, Postcard postcard, RedirectAttributes redirectAttributes) throws IOException {
        try {
            postcardService.savePostcard(postcard, file);
            redirectAttributes.addFlashAttribute("message", "Открытка успешно сохранена");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при сохранении открытки");
        }
        return "redirect:/admin";
    }

    @PostMapping("/postcard_delete/{id}")
    public String deletePostcard(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            postcardService.deletePostcard(id);
            redirectAttributes.addFlashAttribute("message", "Открытка успешно удалена");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при удалении открытки");
        }
        return "redirect:/admin";
    }
}

