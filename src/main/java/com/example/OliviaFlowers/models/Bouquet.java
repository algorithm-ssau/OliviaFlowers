package com.example.OliviaFlowers.models;//package com.example.OliviaFlowers.models;

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
@Table(name = "bouquet")
public class Bouquet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //id букета

    @Column(name = "name")
    private String name; //название

    @Column(name = "composition", columnDefinition = "text")
    private String composition;

    @Column(name = "price")
    private Long price; //цена

    @OneToMany
    private List<Image> images = new ArrayList<>();
    private Long previewImageID;

}
