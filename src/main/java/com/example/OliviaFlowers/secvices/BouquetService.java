package com.example.OliviaFlowers.secvices;

import com.example.OliviaFlowers.models.Bouquet;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BouquetService {
    private List<Bouquet> bouquets = new ArrayList<>();
    {
        bouquets.add(new Bouquet(Long.valueOf(1),"Букет","",Long.valueOf(2000) ));
        bouquets.add(new Bouquet(Long.valueOf(2),"Букет","",Long.valueOf(3000) ));
    }

    public List<Bouquet> listBouquets() {return bouquets;}
}
