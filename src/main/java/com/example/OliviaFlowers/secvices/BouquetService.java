package com.example.OliviaFlowers.secvices;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.repositories.BouquetRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BouquetService {
    @Autowired
    private final BouquetRepository bouquetRepository;

    public BouquetService(BouquetRepository bouquetRepository) {
        this.bouquetRepository = bouquetRepository;
    }

    public List<Bouquet> listAllBouquets(String name){
        if (name != null) return bouquetRepository.findByName(name);
        return bouquetRepository.findAll();
    }

    public void saveBouquet(Bouquet bouquet){
        bouquetRepository.save(bouquet);
    }

    public void deleteBouquet(Long id){
        bouquetRepository.deleteById(id);
    }

    public Bouquet getBouquetByID(Long id){
        return bouquetRepository.findById(id).orElse(null);
    }
}
