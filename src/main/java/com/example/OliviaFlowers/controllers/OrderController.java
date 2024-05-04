package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.secvices.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class OrderController {
    @GetMapping("/order")
    public String order(){
        return "order";
    }

    @Autowired
    public final OrderService orderService;
}
