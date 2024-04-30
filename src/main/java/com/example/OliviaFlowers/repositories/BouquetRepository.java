package com.example.OliviaFlowers.repositories;

import com.example.OliviaFlowers.models.Bouquet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BouquetRepository extends JpaRepository<Bouquet, Long> {
    List<Bouquet> findByName(String name);
}
