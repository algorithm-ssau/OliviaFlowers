package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.Order;
import com.example.OliviaFlowers.models.User;
import com.example.OliviaFlowers.secvices.BouquetService;
import com.example.OliviaFlowers.secvices.FavoriteService;
import com.example.OliviaFlowers.secvices.OrderService;
import com.example.OliviaFlowers.secvices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ProfileController {

    private final FavoriteService favoriteService;
    private final BouquetService bouquetService;
    private final UserService userService;
    private final OrderService orderService;

    @Autowired
    public ProfileController(FavoriteService favoriteService, BouquetService bouquetService, UserService userService, OrderService orderService) {
        this.favoriteService = favoriteService;
        this.bouquetService = bouquetService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/profile")
    public String profile(Model model, @AuthenticationPrincipal User user) {
        List<Order> orders = orderService.findOrdersByUser(user); // Получаем заказы пользователя
        // Фильтруем заказы, оставляя только те, у которых datePayment не равен null
        List<Order> filteredOrders = orders.stream()
                .filter(order -> order.getDatePayment() != null)
                .collect(Collectors.toList());
        model.addAttribute("currentUser", user);
        model.addAttribute("orders", filteredOrders);
        return "profile";
    }

    @PostMapping("/add_to_favorites")
    @PreAuthorize("isAuthenticated()")
    public String addToFavorites(@RequestParam Long bouquetId, @AuthenticationPrincipal User user) {
        Bouquet bouquet = bouquetService.getBouquetByID(bouquetId);
        favoriteService.saveFavorite(user, bouquet);
        return "redirect:/profile";
    }

}
