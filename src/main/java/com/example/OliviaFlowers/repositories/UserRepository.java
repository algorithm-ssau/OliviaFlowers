package com.example.OliviaFlowers.repositories;


import com.example.OliviaFlowers.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    User findByActivationCode(String code);
}

