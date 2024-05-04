package com.example.OliviaFlowers.secvices;

import com.example.OliviaFlowers.repositories.OrderRepository;
import com.example.OliviaFlowers.models.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private final OrderRepository orderRepository;





}
