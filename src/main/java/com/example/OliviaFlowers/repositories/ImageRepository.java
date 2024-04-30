package com.example.OliviaFlowers.repositories;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional

public interface ImageRepository extends JpaRepository<Image, Long> {
    void deleteByBouquetId(Long id);
}