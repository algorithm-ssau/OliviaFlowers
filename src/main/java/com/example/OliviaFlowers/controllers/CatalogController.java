package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.Order;
import com.example.OliviaFlowers.models.User;
import com.example.OliviaFlowers.secvices.BouquetService;
import com.example.OliviaFlowers.secvices.FavoriteService;
import com.example.OliviaFlowers.secvices.OrderService;
import com.example.OliviaFlowers.secvices.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CatalogController {

    private final BouquetService bouquetService;
    private final UserService userService;

    @Autowired
    public CatalogController(BouquetService bouquetService, UserService userService) {
        this.bouquetService = bouquetService;
        this.userService = userService;
    }

    @GetMapping("/lookAll")
    public String lookAll(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("allBouquets", bouquetService.listAllBouquets()); // Получаем заказы пользователя
        //проверка пользователя администратор он или нет
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Пользователь аутентифицирован, можно получить его имя пользователя или другой идентификатор
        String username = authentication.getName(); // Получить имя пользователя
        User user1 = userService.getUserByEmail(username);
        if (user1 != null){ model.addAttribute("isAdmin", user.getIsAdministrator());}
        else{ model.addAttribute("isAdmin", false);}
        return "catalog";
    }

    @GetMapping("/authorBouquet")
    public String authorBouquet(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("allBouquets", bouquetService.listAuthorBouquets()); // Получаем заказы пользователя
        //проверка пользователя администратор он или нет
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Пользователь аутентифицирован, можно получить его имя пользователя или другой идентификатор
        String username = authentication.getName(); // Получить имя пользователя
        User user1 = userService.getUserByEmail(username);
        if (user1 != null){ model.addAttribute("isAdmin", user.getIsAdministrator());}
        else{ model.addAttribute("isAdmin", false);}
        return "catalog";
    }

    @GetMapping("/boxBouquet")
    public String boxBouquet(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("allBouquets", bouquetService.listBoxBouquets()); // Получаем заказы пользователя
        //проверка пользователя администратор он или нет
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Пользователь аутентифицирован, можно получить его имя пользователя или другой идентификатор
        String username = authentication.getName(); // Получить имя пользователя
        User user1 = userService.getUserByEmail(username);
        if (user1 != null){ model.addAttribute("isAdmin", user.getIsAdministrator());}
        else{ model.addAttribute("isAdmin", false);}
        return "catalog";
    }

    @GetMapping("/weddingBouquet")
    public String weddingBouquet(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("allBouquets", bouquetService.listWeddingBouquets()); // Получаем заказы пользователя
        //проверка пользователя администратор он или нет
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Пользователь аутентифицирован, можно получить его имя пользователя или другой идентификатор
        String username = authentication.getName(); // Получить имя пользователя
        User user1 = userService.getUserByEmail(username);
        if (user1 != null){ model.addAttribute("isAdmin", user.getIsAdministrator());}
        else{ model.addAttribute("isAdmin", false);}
        return "catalog";
    }

    @GetMapping("/filterBouquets")
    public String filterBouquets(
            @RequestParam(required = false) int sort,
            @RequestParam(required = false) Long minPrice,
            @RequestParam(required = false) Long maxPrice,
            @RequestParam(required = false) String priceRange,
            Model model,
            @AuthenticationPrincipal User user
    ) {

        Long min = minPrice != null ? minPrice : 0;
        Long max = maxPrice != null ? maxPrice : Long.MAX_VALUE;

        if (priceRange != null && !priceRange.isEmpty()) {
            String[] range = priceRange.split("-");
            min = Long.parseLong(range[0]);
            max = Long.parseLong(range[1]);
        }

        List<Bouquet> bouquets = bouquetService.filterBouquets(sort, min, max);
        model.addAttribute("allBouquets", bouquets);

        // Проверка пользователя, администратор он или нет
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Получить имя пользователя
        User user1 = userService.getUserByEmail(username);
        if (user1 != null) {
            model.addAttribute("isAdmin", user.getIsAdministrator());
        } else {
            model.addAttribute("isAdmin", false);
        }

        return "catalog";
    }


}
