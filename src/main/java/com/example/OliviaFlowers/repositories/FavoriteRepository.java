package com.example.OliviaFlowers.repositories;

import com.example.OliviaFlowers.models.Favorite;
import com.example.OliviaFlowers.models.Favorite_key;
import com.example.OliviaFlowers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Favorite_key> {
    List<Favorite> findByUser(User user);
    void deleteById(Favorite_key favoriteKey);
}
