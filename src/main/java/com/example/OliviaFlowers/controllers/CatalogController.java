package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.User;
import com.example.OliviaFlowers.secvices.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.OptionalDouble;

@Controller
public class CatalogController {

    private final BouquetService bouquetService;
    private final UserService userService;

    private final PostcardService postcardService;

    private List<Bouquet> bouquets;

    @Autowired
    public CatalogController(BouquetService bouquetService, UserService userService, PostcardService postcardService) {
        this.bouquetService = bouquetService;
        this.userService = userService;
        this.postcardService = postcardService;
    }

    @GetMapping("/catalog")
    public String catalog(Model model){
        bouquets = bouquetService.listAllBouquets();
        model.addAttribute("allBouquets", bouquets);
        model.addAttribute("title", "Все букеты: ");

        // Найти максимальную цену среди всех букетов с использованием потока
        OptionalDouble maxPrice = bouquetService.listAllBouquets().stream()
                .mapToDouble(Bouquet::getPrice)
                .max();
        // Добавить максимальную цену в модель
        model.addAttribute("maxPrice", maxPrice.orElse(0.0));

        OptionalDouble minPrice = bouquetService.listAllBouquets().stream()
                .mapToDouble(Bouquet::getPrice)
                .min();

        model.addAttribute("minPrice", minPrice.orElse(0.0));

        //проверка пользователя администратор он или нет
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Пользователь аутентифицирован, можно получить его имя пользователя или другой идентификатор
        String username = authentication.getName(); // Получить имя пользователя
        User user = userService.getUserByEmail(username);
        if (user != null){ model.addAttribute("isAdmin", user.getIsAdministrator());}
        else{ model.addAttribute("isAdmin", false);}
        return "catalog";
    }

    @GetMapping("/catalogPostcard")
    public String catalogPostcard(Model model){
        model.addAttribute("allPostcards", postcardService.listAllPostcards());
        model.addAttribute("title", "Все букеты: ");

        //проверка пользователя администратор он или нет
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        // Пользователь аутентифицирован, можно получить его имя пользователя или другой идентификатор
        String username = authentication.getName(); // Получить имя пользователя
        User user = userService.getUserByEmail(username);
        if (user != null){ model.addAttribute("isAdmin", user.getIsAdministrator());}
        else { model.addAttribute("isAdmin", false);}
        return "catalog";
    }

    @GetMapping("/authorBouquet")
    public String authorBouquet(Model model, @AuthenticationPrincipal User user) {
        bouquets = bouquetService.listAuthorBouquets();
        model.addAttribute("allBouquets", bouquets); // Получаем заказы пользователя
        model.addAttribute("title", "Авторские букеты: ");

        // Найти максимальную цену среди всех букетов с использованием потока
        OptionalDouble maxPrice = bouquetService.listAuthorBouquets().stream()
                .mapToDouble(Bouquet::getPrice)
                .max();
        // Добавить максимальную цену в модель
        model.addAttribute("maxPrice", maxPrice.orElse(0.0));

        OptionalDouble minPrice = bouquetService.listAuthorBouquets().stream()
                .mapToDouble(Bouquet::getPrice)
                .min();

        model.addAttribute("minPrice", minPrice.orElse(0.0));
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
        bouquets = bouquetService.listBoxBouquets();
        model.addAttribute("allBouquets", bouquets); // Получаем заказы пользователя
        model.addAttribute("title", "Композиции в коробках и корзинах: ");

        // Найти максимальную цену среди всех букетов с использованием потока
        OptionalDouble maxPrice = bouquetService.listBoxBouquets().stream()
                .mapToDouble(Bouquet::getPrice)
                .max();
        // Добавить максимальную цену в модель
        model.addAttribute("maxPrice", maxPrice.orElse(0.0));

        OptionalDouble minPrice = bouquetService.listBoxBouquets().stream()
                .mapToDouble(Bouquet::getPrice)
                .min();

        model.addAttribute("minPrice", minPrice.orElse(0.0));
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
        bouquets = bouquetService.listWeddingBouquets();
        model.addAttribute("allBouquets", bouquets); // Получаем заказы пользователя
        model.addAttribute("title", "Свадебный декор: ");

        // Найти максимальную цену среди всех букетов с использованием потока
        OptionalDouble maxPrice = bouquetService.listWeddingBouquets().stream()
                .mapToDouble(Bouquet::getPrice)
                .max();
        // Добавить максимальную цену в модель
        model.addAttribute("maxPrice", maxPrice.orElse(0.0));

        OptionalDouble minPrice = bouquetService.listWeddingBouquets().stream()
                .mapToDouble(Bouquet::getPrice)
                .min();

        model.addAttribute("minPrice", minPrice.orElse(0.0));
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
            @RequestParam(required = false) String priceRangeSmall,
            @RequestParam(required = false) String priceRangeAverage,
            @RequestParam(required = false) String priceRangeBig,

            Model model,
            @AuthenticationPrincipal User user) {
        Long  min = minPrice != null ? minPrice : Long.MAX_VALUE;
        Long  max = maxPrice != null ? maxPrice : Long.MIN_VALUE;
        Long local_min;
        Long local_max;

        if (priceRangeSmall != null && !priceRangeSmall.isEmpty()) {
            String[] range = priceRangeSmall.split("-");
            local_min = Long.parseLong(range[0]);
            local_max = Long.parseLong(range[1]);
            if (local_min < min){ min = local_min;}
            if (local_max > max){ max = local_max;}
        }
        if (priceRangeAverage != null && !priceRangeAverage.isEmpty()) {
            String[] range = priceRangeAverage.split("-");
            local_min = Long.parseLong(range[0]);
            local_max = Long.parseLong(range[1]);
            if (local_min < min){ min = local_min;}
            if (local_max > max){ max = local_max;}
        }
        if (priceRangeBig != null && !priceRangeBig.isEmpty()) {
            String[] range = priceRangeBig.split("-");
            local_min = Long.parseLong(range[0]);
            local_max = Long.parseLong(range[1]);
            if (local_min < min){ min = local_min;}
            if (local_max > max){ max = local_max;}
        }
        if (min == Long.MAX_VALUE) { min = 0L;}
        if (max == Long.MIN_VALUE) { max = Long.MAX_VALUE;}

        List<Bouquet> sortedBouquets = bouquetService.filterBouquets(sort, min, max, bouquets);
        model.addAttribute("allBouquets", sortedBouquets);



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
