package com.example.OliviaFlowers.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class order_has_bouquet_key implements Serializable {

    @Column(name = "order_id")
    Long idOrder;

    @Column(name = "bouquet_id")
    Long idBouquet;




}
