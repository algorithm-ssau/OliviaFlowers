package com.example.OliviaFlowers.models;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class BouquetHasFlower {
    @Id
    private Long idOrderidBouquet; //id букета
    @Id
    private Long idFlower; //id цветка
    @Column
    private Long count; //Количество цветов
}
