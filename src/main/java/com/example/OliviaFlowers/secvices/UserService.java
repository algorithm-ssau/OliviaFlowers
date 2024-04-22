package com.example.OliviaFlowers.secvices;

import com.example.OliviaFlowers.models.User;
import com.example.OliviaFlowers.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private static final Logger log = LoggerFactory.getLogger(UserService.class);
    private  UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public boolean createUser (User user){
        String email = user.getEmail();
        if (userRepository.findByEmail(email) != null) return false;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setIsAdministrator(false);
        log.info("Saving new User with email: {}", email);
        userRepository.save(user);
        return true;
    }
}
