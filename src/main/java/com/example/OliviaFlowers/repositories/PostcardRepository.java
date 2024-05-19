package com.example.OliviaFlowers.repositories;

import com.example.OliviaFlowers.models.Order;
import com.example.OliviaFlowers.models.Postcard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostcardRepository  extends JpaRepository<Postcard, Long> {
}
