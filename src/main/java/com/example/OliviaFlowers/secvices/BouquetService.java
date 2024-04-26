package com.example.OliviaFlowers.secvices;

import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.repositories.BouquetRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor
public class BouquetService {
    private final BouquetRepository bouquetRepository;

    public List<Bouquet> listAllBouquets(String name){
        if (name != null) return bouquetRepository.findByName(name);
        return bouquetRepository.findAll();
    }

    public void saveBouquet(Bouquet bouquet){
        log.info("Creating new {}", bouquet);
        bouquetRepository.save(bouquet);
    }

    public void deleteBouquet(Long id){
        bouquetRepository.deleteById(id);
    }

    public Bouquet getBouquetByID(Long id){
        return bouquetRepository.findById(id).orElse(null);
    }
}
