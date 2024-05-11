package com.example.OliviaFlowers.repositories;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.Order;
import com.example.OliviaFlowers.models.Order_has_bouquet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface Order_has_bouquet_Repository extends CrudRepository<Order_has_bouquet, Long> {
    List<Order_has_bouquet> findAllByOrder(Order order);
    Order_has_bouquet findByBouquetAndOrder(Bouquet bouquet, Order order);
    void deleteByBouquetAndOrder(Bouquet bouquet, Order order);
}
