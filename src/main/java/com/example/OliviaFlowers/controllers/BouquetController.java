package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.Order;
import com.example.OliviaFlowers.secvices.BouquetService;
import com.example.OliviaFlowers.secvices.OrderHasBouquetService;
import com.example.OliviaFlowers.secvices.OrderService;
import com.example.OliviaFlowers.secvices.PostcardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@Controller

public class BouquetController {
    @Autowired
    private final BouquetService bouquetService;
    @Autowired
    private final OrderHasBouquetService orderHasBouquetService;
    @Autowired
    private final OrderService orderService;
    @Autowired
    private final PostcardService postcardService;

    public BouquetController(BouquetService bouquetService, OrderHasBouquetService orderHasBouquetService, OrderService orderService, PostcardService postcardService) {
        this.bouquetService = bouquetService;
        this.orderHasBouquetService = orderHasBouquetService;
        this.orderService = orderService;
        this.postcardService = postcardService;

    }

    @GetMapping("/find_bouquet_by_name")
    public String bouquets(@RequestParam(name = "name", required = false) String name, Model model){
        model.addAttribute("foundBouquetsByName", bouquetService.listAllBouquetsByName(name));
        model.addAttribute("allBouquets", bouquetService.listAllBouquets());
        return "admin";
    }
    @GetMapping("/catalog")
    public String catalog(Model model){
        model.addAttribute("allBouquets", bouquetService.listAllBouquets());
        return "catalog";
    }

    @GetMapping("/admin")
        public String admin(Model model){
        model.addAttribute("allBouquets", bouquetService.listAllBouquets());
        model.addAttribute("allPostcards", postcardService.listAllPostcards());
        model.addAttribute("toDeliverOrders", orderService.ListAllOrdersToDeliver());
        model.addAttribute("toDeliverBouquets", orderHasBouquetService.getPendingBouquets(orderService.ListAllOrdersToDeliver()));
        model.addAttribute("toDeliverAmounts", orderHasBouquetService.getPendingamount(orderService.ListAllOrdersToDeliver()));


        return "admin";
    }

    /*@GetMapping("/getbouquetsbyorder/{id}")
    public String findbouquets(@PathVariable Long id, Model model){
        Order order = orderService.getOrderByID(id);
        model.addAttribute("bouquetsorderful",orderHasBouquetService.getbouquetsByOrder(order));
        model.addAttribute("amountsorderful",orderHasBouquetService.getAmountsByOrder(order));
        return "admin";
    }*/



    @GetMapping("/bouquet/{id}")
    public String bouquet(@PathVariable Long id, Model model){
        Bouquet bouquet = bouquetService.getBouquetByID(id);
        model.addAttribute("bouquet", bouquet);
        return "bouquet";
    }

    @PostMapping("/bouquet_create")
    public String createBouquet(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                              @RequestParam("file3") MultipartFile file3, Bouquet bouquet,
                                              RedirectAttributes redirectAttributes) throws IOException {
        try {
            bouquetService.saveBouquet(bouquet, file1, file2, file3);
            redirectAttributes.addFlashAttribute("message", "Букет успешно сохранен");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при сохранении букета");
        }
        return "redirect:/admin";
    }


    @PostMapping("/bouquet_delete/{id}")
    public String deleteBouquet(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            bouquetService.deleteBouquet(id);
            redirectAttributes.addFlashAttribute("message", "Букет успешно удален");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при удалении букета");
        }
        return "redirect:/admin";
    }

    @PostMapping("/bouquet_addcar/{id}")
    public String addToCart(@PathVariable Long id, Principal principal, RedirectAttributes redirectAttributes) {
        try{
            Bouquet bouquet = bouquetService.getBouquetByID(id);
            orderHasBouquetService.createOrderHasBouquet(bouquet, principal);
            redirectAttributes.addFlashAttribute("message", "Успешно добавлено в корзину");
        }catch (Exception e){
            redirectAttributes.addFlashAttribute("error", "Ошибка при добавлении в корзину");
        }


        return "redirect:/bouquet/{id}";

    }

    @PostMapping("deliver_order/{id}")
    public String finishOrder(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try{
            Order order = orderService.getOrderByID(id);
            LocalDateTime delivered = LocalDateTime.now();
            orderService.DeliverOrder(order, delivered);
            redirectAttributes.addFlashAttribute("message", "Заказ отмечен как доставленный");
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("message", "Ошибка при доставке заказа");
        }

        return"redirect:/admin";
    }

    @PostMapping("cancel_order/{id}")
    public String cancelOrder(@PathVariable Long id, RedirectAttributes redirectAttributes){
        try{
            Order order = orderService.getOrderByID(id);
            orderService.CancelOrder(order);

            redirectAttributes.addFlashAttribute("message", "Заказ отменён");
        }catch(Exception e){
            redirectAttributes.addFlashAttribute("message", "Ошибка при отмене заказа");
        }

        return"redirect:/admin";
    }


}
