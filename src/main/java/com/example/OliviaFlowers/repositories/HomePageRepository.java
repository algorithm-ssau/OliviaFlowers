package com.example.OliviaFlowers.repositories;

import com.example.OliviaFlowers.models.HomePage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomePageRepository extends JpaRepository<HomePage, Long> {
    // Здесь могут быть объявлены дополнительные методы для работы с сущностью HomePage
}
