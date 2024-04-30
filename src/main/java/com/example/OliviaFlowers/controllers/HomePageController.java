package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.HomePage;
import com.example.OliviaFlowers.repositories.HomePageRepository;
import org.springframework.ui.Model;
import com.example.OliviaFlowers.models.Bouquet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.OliviaFlowers.secvices.BouquetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class HomePageController {

    @Autowired
    private final BouquetService bouquetService;

    @Autowired
    private final HomePageRepository homePageRepository;

    public HomePageController(BouquetService bouquetService, HomePageRepository homePageRepository) {
        this.bouquetService = bouquetService;
        this.homePageRepository = homePageRepository;
    }

    @GetMapping("/")
    public String home(Model model){

        try {
            // Получить все записи о букетах на главной странице из базы данных
            List<HomePage> homePageBouquets = homePageRepository.findAll();

            // Поместить полученные букеты в модель
            model.addAttribute("homePageBouquets", homePageBouquets);


            // Получить информацию о каждом букете и добавить её в модель
            Bouquet bouquet1 = homePageBouquets.get(0).getBouquet();
            Bouquet bouquet2 = homePageBouquets.get(1).getBouquet();
            Bouquet bouquet3 = homePageBouquets.get(2).getBouquet();

            model.addAttribute("bouquet1", bouquet1);
            model.addAttribute("bouquet2", bouquet2);
            model.addAttribute("bouquet3", bouquet3);

            model.addAttribute("homePageBouquets", homePageBouquets);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Вернуть страницу главного экрана
        return "home";
    }


    @PostMapping("/add_bouquets_to_homepage")
    public String addBouquetsToHomepage(@RequestParam(name = "bouquet1") Long bouquetId1, @RequestParam(name = "description1") String description1,
                                        @RequestParam(name = "bouquet2") Long bouquetId2, @RequestParam(name = "description2") String description2,
                                        @RequestParam(name = "bouquet3") Long bouquetId3, @RequestParam(name = "description3") String description3,
                                        Model model) {

        homePageRepository.deleteAll();

        // Получить информацию о букетах с переданными ID и добавить её в модель
        Bouquet bouquet1 = bouquetService.getBouquetByID(bouquetId1);
        Bouquet bouquet2 = bouquetService.getBouquetByID(bouquetId2);
        Bouquet bouquet3 = bouquetService.getBouquetByID(bouquetId3);


        // Создать новую запись для главной страницы и сохранить её в базе данных
        HomePage homePage1 = new HomePage();
        homePage1.setBouquet(bouquet1);
        homePage1.setDescription(description1);
        homePageRepository.save(homePage1);

        HomePage homePage2 = new HomePage();
        homePage2.setBouquet(bouquet2);
        homePage2.setDescription(description2);
        homePageRepository.save(homePage2);

        HomePage homePage3 = new HomePage();
        homePage3.setBouquet(bouquet3);
        homePage3.setDescription(description3);
        homePageRepository.save(homePage3);

        // Вернуть страницу главного экрана
        return "redirect:/";
    }
}
