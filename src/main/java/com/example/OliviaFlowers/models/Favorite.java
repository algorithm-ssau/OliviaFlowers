package com.example.OliviaFlowers.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Favorite {
    @EmbeddedId
    Favorite_key id;

    @ManyToOne
    @MapsId("idUser")
    @JoinColumn(name = "user_id")
    User user; //заказ

    @ManyToOne
    @MapsId("idBouquet")
    @JoinColumn(name = "bouquet_id")
    Bouquet bouquet; //id букета

    @Column
    private boolean isFavorite; //Любимый букет или нет
}
