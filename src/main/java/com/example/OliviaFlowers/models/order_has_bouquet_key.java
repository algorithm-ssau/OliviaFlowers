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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idOrder == null) ? 0 : idOrder.hashCode());
        result = prime * result + ((idBouquet == null) ? 0 : idBouquet.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        order_has_bouquet_key other = (order_has_bouquet_key) obj;
        if (idOrder == null) {
            if (other.idOrder != null)
                return false;
        } else if (!idOrder.equals(other.idOrder))
            return false;
        if (idBouquet == null) {
            if (other.idBouquet != null)
                return false;
        } else if (!idBouquet.equals(other.idBouquet))
            return false;
        return true;
    }




}
