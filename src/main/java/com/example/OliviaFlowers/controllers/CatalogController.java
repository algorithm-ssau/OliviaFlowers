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

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

@Controller
public class CatalogController {

    private final BouquetService bouquetService;
    private final UserService userService;

    private final PostcardService postcardService;

    private List<Bouquet> bouquets;

    private String title;
    private String roses = null;
    private String peonies = null;
    private String ranunculus = null;
    private String eustoma = null;
    private String hortensia = null;
    private String alstroemeria = null;
    private String daisies = null;
    private String chrysanthemums = null;
    private String gypsophila = null;
    private String carnation = null;
    private String tulips = null;

    private String priceRangeSmall = null;
    private String priceRangeAverage = null;
    private String priceRangeBig = null;

    private int selectedSort = 0;

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
        title = "Все букеты: ";
        model.addAttribute("title", title);
        model.addAttribute("selectedSort", 0);




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
        title = "Открытки: ";
        model.addAttribute("title", title);
        model.addAttribute("selectedSort", selectedSort);


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
        else { model.addAttribute("isAdmin", false);}
        return "catalog";
    }

    @GetMapping("/authorBouquet")
    public String authorBouquet(Model model, @AuthenticationPrincipal User user) {
        bouquets = bouquetService.listAuthorBouquets();
        model.addAttribute("allBouquets", bouquets); // Получаем заказы пользователя
        title = "Авторские букеты: ";
        model.addAttribute("title", title);
        model.addAttribute("selectedSort", selectedSort);


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
        title = "Композиции в коробках и корзинах: ";
        model.addAttribute("title", title);
        model.addAttribute("selectedSort", selectedSort);


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
        title = "Свадебный декор: ";
        model.addAttribute("title", title);
        model.addAttribute("selectedSort", selectedSort);


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
            @RequestParam(required = false) String roses,
            @RequestParam(required = false) String peonies,
            @RequestParam(required = false) String ranunculus,
            @RequestParam(required = false) String eustoma,
            @RequestParam(required = false) String hortensia,
            @RequestParam(required = false) String alstroemeria,
            @RequestParam(required = false) String daisies,
            @RequestParam(required = false) String chrysanthemums,
            @RequestParam(required = false) String gypsophila,
            @RequestParam(required = false) String carnation,
            @RequestParam(required = false) String tulips,

            Model model,
            @AuthenticationPrincipal User user) {
        Long  min = minPrice != null ? minPrice : Long.MAX_VALUE;
        Long  max = maxPrice != null ? maxPrice : Long.MIN_VALUE;
        Long local_min;
        Long local_max;
        List<String> flowerstosearch = new ArrayList<String>();

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

        if (roses != null) {
            flowerstosearch.add(roses);
            this.roses = roses;
        } else {this.roses = null;}

        if (peonies != null) {
            flowerstosearch.add(peonies);
            this.peonies = peonies;
        } else {this.peonies = null;}

        if (ranunculus != null) {
            flowerstosearch.add(ranunculus);
            this.ranunculus = ranunculus;
        } else {this.ranunculus = null;}

        if (eustoma != null) {
            flowerstosearch.add(eustoma);
            this.eustoma = eustoma;
        } else {this.eustoma = null;}

        if (hortensia != null) {
            flowerstosearch.add(hortensia);
            this.hortensia = hortensia;
        } else {this.hortensia = null;}

        if (alstroemeria != null) {
            flowerstosearch.add(alstroemeria);
            this.alstroemeria = alstroemeria;
        } else {this.alstroemeria = null;}

        if (daisies != null) {
            flowerstosearch.add(daisies);
            this.daisies = daisies;
        } else {this.daisies = null;}

        if (chrysanthemums != null) {
            flowerstosearch.add(chrysanthemums);
            this.chrysanthemums = chrysanthemums;
        } else {this.chrysanthemums = null;}

        if (gypsophila != null) {
            flowerstosearch.add(gypsophila);
            this.gypsophila = gypsophila;
        } else {this.gypsophila = null;}

        if (carnation != null) {
            flowerstosearch.add(carnation);
            this.carnation = carnation;
        } else {this.carnation = null;}

        if (tulips != null) {
            flowerstosearch.add(tulips);
            this.tulips = tulips;
        } else {this.tulips = null;}




        if (priceRangeSmall != null) {
            this.priceRangeSmall = priceRangeSmall;
        } else {this.priceRangeSmall = null;}

        if (priceRangeAverage != null) {
            this.priceRangeAverage = priceRangeAverage;
        } else {this.priceRangeAverage = null;}

        if (priceRangeBig != null) {
            this.priceRangeBig = priceRangeBig;
        } else {this.priceRangeBig = null;}

        List<Bouquet> sortedBouquets;
        if(priceRangeSmall != null && priceRangeBig != null){
            List<Bouquet> sortedBouquets1 = bouquetService.filterBouquets(sort, 0L, 2000L, flowerstosearch, bouquets);
            List<Bouquet> sortedBouquets2 = bouquetService.filterBouquets(sort, 4000L, Long.MAX_VALUE, flowerstosearch, bouquets);
            sortedBouquets = new ArrayList<>(sortedBouquets1);
            sortedBouquets.addAll(sortedBouquets2);
            model.addAttribute("allBouquets", sortedBouquets);
        }
        else{
            sortedBouquets = bouquetService.filterBouquets(sort, min, max, flowerstosearch, bouquets);
            model.addAttribute("allBouquets", sortedBouquets);
        }

        model.addAttribute("title", title);

        model.addAttribute("roses", roses);
        model.addAttribute("peonies", peonies);
        model.addAttribute("ranunculus", ranunculus);
        model.addAttribute("eustoma", eustoma);
        model.addAttribute("hortensia", hortensia);
        model.addAttribute("alstroemeria", alstroemeria);
        model.addAttribute("daisies", daisies);
        model.addAttribute("chrysanthemums", chrysanthemums);
        model.addAttribute("gypsophila", gypsophila);
        model.addAttribute("carnation", carnation);
        model.addAttribute("tulips", tulips);

        model.addAttribute("priceRangeSmall", priceRangeSmall);
        model.addAttribute("priceRangeAverage", priceRangeAverage);
        model.addAttribute("priceRangeBig", priceRangeBig);

        selectedSort = sort;
        model.addAttribute("selectedSort", selectedSort);



        // Найти максимальную цену среди всех букетов с использованием потока
        OptionalDouble maxPriceBouquets = sortedBouquets.stream()
                .mapToDouble(Bouquet::getPrice)
                .max();
        // Добавить максимальную цену в модель
        model.addAttribute("maxPrice", maxPriceBouquets.orElse(0.0));

        OptionalDouble minPriceBouquets = sortedBouquets.stream()
                .mapToDouble(Bouquet::getPrice)
                .min();

        model.addAttribute("minPrice", minPriceBouquets.orElse(0.0));



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
