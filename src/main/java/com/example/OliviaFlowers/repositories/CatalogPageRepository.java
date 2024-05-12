package com.example.OliviaFlowers.repositories;
import com.example.OliviaFlowers.models.CatalogPage;
import com.example.OliviaFlowers.models.HomePage;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CatalogPageRepository extends JpaRepository<CatalogPage, Long> {
    // Здесь могут быть объявлены дополнительные методы для работы с сущностью CatalogPage
}