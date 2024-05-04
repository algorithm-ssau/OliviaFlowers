package com.example.OliviaFlowers.secvices;

import com.example.OliviaFlowers.models.Order_has_bouquet;
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

    public OrderHasBouquetService(Order_has_bouquet_Repository order_has_bouquet_Repository) {
        this.order_has_bouquet_Repository = order_has_bouquet_Repository;
    }

    public boolean saveOrderHasBouquet(Order_has_bouquet order_has_bouquet) {
        order_has_bouquet_Repository.save(order_has_bouquet);
        return true;
    }


}
