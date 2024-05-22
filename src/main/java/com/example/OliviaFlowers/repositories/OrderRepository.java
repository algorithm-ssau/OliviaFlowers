package com.example.OliviaFlowers.repositories;


import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.Image;
import com.example.OliviaFlowers.models.Order;
import com.example.OliviaFlowers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllByUserAndStatus(User user, String status);

    Order findByUserAndStatus(User user, String status);
    List<Order> findAllByStatus(String status);

    List<Order> findByUser(User user);
}
