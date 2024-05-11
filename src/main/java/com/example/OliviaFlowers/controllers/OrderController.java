package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.Order;
import com.example.OliviaFlowers.secvices.BouquetService;
import com.example.OliviaFlowers.secvices.OrderHasBouquetService;
import com.example.OliviaFlowers.secvices.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class OrderController {
    @Autowired
    public final OrderService orderService;
    @Autowired
    public final OrderHasBouquetService orderHasBouquetService;
    @Autowired
    private BouquetService bouquetService;

    public OrderController(OrderService orderService, OrderHasBouquetService orderHasBouquetService) {
        this.orderService = orderService;
        this.orderHasBouquetService = orderHasBouquetService;
    }

//    @GetMapping("/order")
//    public String order(){
//        return "order";
//    }

    @GetMapping("/order/add")
    public String addOrder(Order order, Principal principal) throws IOException {
        orderService.saveOrder(principal, order);
        return "redirect:/order";
    }

    @GetMapping("/getorders")
    public String getOrders(Principal principal, Model model){
        model.addAttribute("orders", orderService.ListOrders());
        model.addAttribute("user", orderService.getUserByPrincipal(principal));
        return "order";
    }

    @GetMapping("/order")
    public String getBouqordersAc(Principal principal,Model model){

        model.addAttribute("acBouquets", orderHasBouquetService.getbouquetsByOrder(orderService.HaveActiveOrderByPrincipal(principal)));

        model.addAttribute("inacOrders", orderService.ListOrdersInactive(principal));
        model.addAttribute("acAmounts", orderHasBouquetService.getAmountsByOrder(orderService.HaveActiveOrderByPrincipal(principal)));
        model.addAttribute("acOrder", orderService.HaveActiveOrderByPrincipal(principal));
        return "order";
    }

    @PostMapping("/order_delete/{id}")
    public String deleteOrderBouquet(@PathVariable Long id, Principal principal, RedirectAttributes redirectAttributes){
        try {
            Bouquet bouquet = bouquetService.getBouquetByID(id);
            orderHasBouquetService.removeOrderHasBouquet(bouquet, principal);
            redirectAttributes.addFlashAttribute("message", "Букет удалён из заказа");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при удалении букета из заказа");
        }

        return "redirect:/order";
    }

    @PostMapping("/order_amountchange/{id}")
    public String changebouquetcount(@PathVariable Long id, @RequestParam(name = "count") Long count, Principal principal, RedirectAttributes redirectAttributes){
        try{
            Bouquet bouquet = bouquetService.getBouquetByID(id);
            orderHasBouquetService.changeAmount(bouquet, principal, count);
        }catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при изменении стоимости");
        }

        return "redirect:/order";


    }

    @PostMapping("/order_checkout")
    public String Checkoutbouquet(@RequestParam(name = "typepostcard") Long typepostcard,@RequestParam(name = "textpostcard") String textpostcard,
                                  @RequestParam(name = "toDeliver") Long toDeliver, @RequestParam(name = "address") String address,  Principal principal, RedirectAttributes redirectAttributes){
        Boolean todel = true;
        if(toDeliver == 1) todel = false;
        LocalDateTime pay = LocalDateTime.now();
        if (todel == true || address == null) address = "дефолтный магазина на самовывоз";
        try{
            orderService.CheckoutOrder(principal, typepostcard, textpostcard, todel, address, pay);
            redirectAttributes.addFlashAttribute("message", "Оформлено, будет доставлено по адресу " + address);
        }catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при оформлении заказа");
        }

        return "redirect:/order";
    }










}
