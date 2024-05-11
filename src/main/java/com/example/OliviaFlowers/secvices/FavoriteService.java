package com.example.OliviaFlowers.secvices;


import com.example.OliviaFlowers.models.Bouquet;
import com.example.OliviaFlowers.models.Favorite;
import com.example.OliviaFlowers.models.User;
import com.example.OliviaFlowers.repositories.FavoriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    @Autowired
    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public List<Bouquet> getFavoriteBouquetsByUser(User user) {
        List<Favorite> favorites = favoriteRepository.findByUser(user);
        return favorites.stream().map(Favorite::getBouquet).toList();
    }
}

