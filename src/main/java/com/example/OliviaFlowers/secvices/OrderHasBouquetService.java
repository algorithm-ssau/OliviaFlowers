package com.example.OliviaFlowers.secvices;

import com.example.OliviaFlowers.models.*;
import com.example.OliviaFlowers.repositories.BouquetRepository;
import com.example.OliviaFlowers.repositories.OrderRepository;
import com.example.OliviaFlowers.repositories.Order_has_bouquet_Repository;
import com.example.OliviaFlowers.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class OrderHasBouquetService {
    @Autowired
    private final Order_has_bouquet_Repository order_has_bouquet_Repository;
    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final BouquetRepository bouquetRepository;
    @Autowired
    private final UserRepository userRepository;

    public OrderHasBouquetService(Order_has_bouquet_Repository order_has_bouquet_Repository, OrderRepository orderRepository, BouquetRepository bouquetRepository, UserRepository userRepository ) {
        this.order_has_bouquet_Repository = order_has_bouquet_Repository;
        this.orderRepository = orderRepository;
        this.bouquetRepository = bouquetRepository;
        this.userRepository = userRepository;
    }

    public boolean saveOrderHasBouquet(Order_has_bouquet order_has_bouquet) {
        order_has_bouquet_Repository.save(order_has_bouquet);
        return true;
    }

    public List<Bouquet> getbouquetsByOrder(Order order){
        List<Order_has_bouquet> OhBs = order_has_bouquet_Repository.findAllByOrder(order);
        List<Bouquet> bouqlist = new ArrayList<Bouquet>();
        OhBs.forEach(ohb -> {
            bouqlist.add(ohb.getBouquet());
        });
        return  bouqlist;
    }




    public boolean saveOrderHasBouquet(Order order, Bouquet bouquet) {
        Long idOrder = order.getId();
        Long idBouquet = bouquet.getId();
        order_has_bouquet_key id = new order_has_bouquet_key(idOrder, idBouquet);
        Order_has_bouquet ohb = new Order_has_bouquet();
        ohb.setId(id);
        if (bouquet != null && order != null) {
            ohb.setBouquet(bouquet);
            ohb.setOrder(order);
            ohb.setCount((long)1);
            order_has_bouquet_Repository.save(ohb);
            return true;
        }
        return false;



    }

    public User getUserByPrincipal(Principal principal){
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }

    public boolean createOrderHasBouquet(Bouquet bouquet, Principal principal) {
        if (principal == null || bouquet == null) return false;
        Long idUser = getUserByPrincipal(principal).getId();
        if(orderRepository.findByUserAndActive(getUserByPrincipal(principal), (long)1) == null){
            Order order = new Order();
            order.setUser(getUserByPrincipal(principal));
            order.setActive((long)1);

            orderRepository.save(order);
        }
        Order ordere = orderRepository.findByUserAndActive(getUserByPrincipal(principal), (long)1);
        return saveOrderHasBouquet(ordere, bouquet);



    }




}
