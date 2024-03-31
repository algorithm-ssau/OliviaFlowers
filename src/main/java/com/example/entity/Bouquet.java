package com.example.entity;

import jakarta.persistence.*;
import jdk.jfr.Name;
import lombok.Data;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Bouquet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //id цветка

    @Column
    private String name; //название

    @Column
    private String foto; //фотография

    @Column
    private Long price; //цена

    @Column
    private List composition; //состав

}
