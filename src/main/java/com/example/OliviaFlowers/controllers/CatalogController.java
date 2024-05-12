package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.CatalogPage;
import com.example.OliviaFlowers.models.HomePage;
import com.example.OliviaFlowers.repositories.CatalogPageRepository;
import com.example.OliviaFlowers.repositories.HomePageRepository;
import org.springframework.ui.Model;
import com.example.OliviaFlowers.models.Bouquet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.OliviaFlowers.secvices.BouquetService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class CatalogController {
   @GetMapping("/catalog")
    public String catalog(){
        return "catalog";
    }

   /* @Autowired
    private final BouquetService bouquetService;

    @Autowired
    private final CatalogPageRepository catalogPageRepository;

    public CatalogController(BouquetService bouquetService, CatalogPageRepository catalogPageRepository) {
        this.bouquetService = bouquetService;
        this.catalogPageRepository = catalogPageRepository;
    }

    @GetMapping("/")
    public String catalog(Model model){

        try {
            // Получить все записи о букетах на главной странице из базы данных
            List<CatalogPage> catalogPageBouquets = catalogPageRepository.findAll();

            // Поместить полученные букеты в модель
            model.addAttribute("catalogPageBouquets", catalogPageBouquets);

            if (catalogPageBouquets.size() == 3) {
                Bouquet bouquet1 = catalogPageBouquets.get(0).getBouquet();
                Bouquet bouquet2 = catalogPageBouquets.get(1).getBouquet();
                Bouquet bouquet3 = catalogPageBouquets.get(2).getBouquet();

                model.addAttribute("bouquet1", bouquet1);
                model.addAttribute("bouquet2", bouquet2);
                model.addAttribute("bouquet3", bouquet3);
            } else {
                // Логика для обработки случая, когда список пустой
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        // Вернуть страницу главного экрана
        return "catalog";
    }


    @PostMapping("/add_bouquets_to_catalog")
    public String addBouquetsToCatalogpage(@RequestParam(name = "bouquet1", required = false) Long bouquetId1, @RequestParam(name = "description1", required = false) String description1,
                                        @RequestParam(name = "bouquet2", required = false) Long bouquetId2, @RequestParam(name = "description2", required = false) String description2,
                                        @RequestParam(name = "bouquet3", required = false) Long bouquetId3, @RequestParam(name = "description3", required = false) String description3,
                                        Model model, RedirectAttributes redirectAttributes) {
        if (bouquetId1 != null && bouquetId2 != null && bouquetId3 != null
            && description1 != null && description2 != null && description3 != null) {
            catalogPageRepository.deleteAll();

            // Получить информацию о букетах с переданными ID и добавить её в модель
            Bouquet bouquet1 = bouquetService.getBouquetByID(bouquetId1);
            Bouquet bouquet2 = bouquetService.getBouquetByID(bouquetId2);
            Bouquet bouquet3 = bouquetService.getBouquetByID(bouquetId3);


            // Создать новую запись для главной страницы и сохранить её в базе данных
            CatalogPage catalogPage1 = new CatalogPage();
            catalogPage1.setBouquet(bouquet1);
            catalogPage1.setDescription(description1);
            catalogPageRepository.save(catalogPage1);

            CatalogPage catalogPage2 = new CatalogPage();
            catalogPage2.setBouquet(bouquet2);
            catalogPage2.setDescription(description2);
            catalogPageRepository.save(catalogPage2);

            CatalogPage catalogPage3 = new CatalogPage();
            catalogPage3.setBouquet(bouquet3);
            catalogPage3.setDescription(description3);
            catalogPageRepository.save(catalogPage3);

            return "redirect:/";

        } else {
            redirectAttributes.addFlashAttribute("error", "Вы заполнили не все данные. Операция отклонена.");
            return "redirect:/admin";
        }

    }*/
}
