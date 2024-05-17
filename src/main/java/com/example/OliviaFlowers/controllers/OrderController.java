package com.example.OliviaFlowers.controllers;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.Image;
import com.example.OliviaFlowers.models.Order;
import com.example.OliviaFlowers.secvices.BouquetService;
import com.example.OliviaFlowers.secvices.OrderHasBouquetService;
import com.example.OliviaFlowers.secvices.OrderService;
import com.example.OliviaFlowers.secvices.PostcardService;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class OrderController {
    @Autowired
    public final OrderService orderService;
    @Autowired
    public final OrderHasBouquetService orderHasBouquetService;

    @Autowired
    private final PostcardService postcardService;


    @Autowired
    private BouquetService bouquetService;

    public OrderController(OrderService orderService, OrderHasBouquetService orderHasBouquetService,
                           PostcardService postcardService) {
        this.orderService = orderService;
        this.orderHasBouquetService = orderHasBouquetService;
        this.postcardService = postcardService;
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
        try {

            // Получение текущей даты
            LocalDate minDate = LocalDate.now();

            // Получение текущей даты плюс три месяца
            LocalDate maxDate = minDate.plus(3, ChronoUnit.MONTHS);

            model.addAttribute("acBouquets", orderHasBouquetService.getbouquetsByOrder(orderService.HaveActiveOrderByPrincipal(principal)));

            model.addAttribute("inacOrders", orderService.ListOrdersInactive(principal));
            model.addAttribute("acAmounts", orderHasBouquetService.getAmountsByOrder(orderService.HaveActiveOrderByPrincipal(principal)));
            model.addAttribute("acOrder", orderService.HaveActiveOrderByPrincipal(principal));
            model.addAttribute("allPostcards", postcardService.listAllPostcards());

            model.addAttribute("minDate", minDate);
            model.addAttribute("maxDate", maxDate);

        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public String Checkoutbouquet(@RequestParam(name = "typePostcard") Long typePostcard,
                                  @RequestParam(name = "textPostcard") String textPostcard,
                                  @RequestParam(name = "addressDelivery") String addressDelivery,
                                  @RequestParam(name = "dateDelivery") LocalDate dateDelivery,
                                  @RequestParam(name = "timeDelivery") String timeDelivery,
                                  @RequestParam(name = "dataPostcardId") String dataPostcardId,
                                  Principal principal, RedirectAttributes redirectAttributes){
        LocalDateTime datePayment = LocalDateTime.now();
        //даже не спрашивайте , что это. Только так работает
        if(typePostcard == 0){
            char secondChar = dataPostcardId.charAt(0);
            // Преобразование char в String
            String secondCharAsString = String.valueOf(secondChar);
            // Преобразование String в Long
            typePostcard = Long.parseLong(secondCharAsString) - 1;
        }
        if(textPostcard == ""){
            textPostcard = null;
        }
        if(textPostcard == ""){
            textPostcard = null;
        }
        try{
            orderService.CheckoutOrder(principal, typePostcard, textPostcard, addressDelivery, datePayment, dateDelivery, timeDelivery);
            redirectAttributes.addFlashAttribute("message", "Оформлено, будет доставлено по адресу " + addressDelivery);
        }catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Ошибка при оформлении заказа");
        }

        return "redirect:/order";
    }





}
