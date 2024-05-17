/*
package com.example.OliviaFlowers.controllers;

import ch.qos.logback.core.model.Model;
import com.example.OliviaFlowers.models.Postcard;
import com.example.OliviaFlowers.secvices.PostcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PostcardController {
    @Autowired
    private final PostcardService postcardService;

    public PostcardController(PostcardService postcardService) {
        this.postcardService = postcardService;
    }

    @GetMapping("/choose_postcard")
    public String admin(org.springframework.ui.Model model){
        model.addAttribute("allPostcard", postcardService.listAllPostcards());
        return "redirect:/order";
    }
}
*/
