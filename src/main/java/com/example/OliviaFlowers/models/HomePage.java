package com.example.OliviaFlowers.models;

import com.example.OliviaFlowers.models.Bouquet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "homepage")
public class HomePage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID записи на главной странице

    @ManyToOne
    @JoinColumn(name = "bouquet_id")
    private Bouquet bouquet; // Ссылка на букет

    @Column
    private String description; // Описание букета
}