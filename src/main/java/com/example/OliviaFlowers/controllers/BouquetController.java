package com.example.OliviaFlowers.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class BouquetController {
    @GetMapping("/bouquet")
    public String bouquet(){
        return "bouquet";
    }
}
