package com.example.OliviaFlowers.secvices;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.Order;
import com.example.OliviaFlowers.models.Order_has_bouquet;
import com.example.OliviaFlowers.models.order_has_bouquet_key;
import com.example.OliviaFlowers.repositories.BouquetRepository;
import com.example.OliviaFlowers.repositories.OrderRepository;
import com.example.OliviaFlowers.repositories.Order_has_bouquet_Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@Slf4j
public class OrderHasBouquetService {
    @Autowired
    private final Order_has_bouquet_Repository order_has_bouquet_Repository;
    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final BouquetRepository bouquetRepository;

    public OrderHasBouquetService(Order_has_bouquet_Repository order_has_bouquet_Repository, OrderRepository orderRepository, BouquetRepository bouquetRepository  ) {
        this.order_has_bouquet_Repository = order_has_bouquet_Repository;
        this.orderRepository = orderRepository;
        this.bouquetRepository = bouquetRepository;
    }

    public boolean saveOrderHasBouquet(Order_has_bouquet order_has_bouquet) {
        order_has_bouquet_Repository.save(order_has_bouquet);
        return true;
    }

    public boolean saveOrderHasBouquet(Long idOrder, Long idBouquet) {
        order_has_bouquet_key id = new order_has_bouquet_key(idOrder, idBouquet);
        Order_has_bouquet ohb = new Order_has_bouquet();
        ohb.setId(id);
        Bouquet bouquet = bouquetRepository.findById(idBouquet).get();
        Order order = orderRepository.findById(idOrder).get();
        if (bouquet != null && order != null) {
            ohb.setBouquet(bouquet);
            ohb.setOrder(order);
            order_has_bouquet_Repository.save(ohb);
            return true;
        }
        return false;



    }


}
