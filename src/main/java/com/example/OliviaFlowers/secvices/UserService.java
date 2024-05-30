package com.example.OliviaFlowers.secvices;

import com.example.OliviaFlowers.models.User;
import com.example.OliviaFlowers.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private MailSender mailSender;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean createUser(User user){
        String email = user.getEmail();
        if (userRepository.findByEmail(email) != null) return false;
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setIsAdministrator(false);
        user.setActivationCode(UUID.randomUUID().toString());

        userRepository.save(user);
        if(!StringUtils.isEmpty(user.getEmail()))
        {
            String message = String.format("Здравствуйте, %s! \n\n" +
                            "Добро пожаловать в OliviaFlowers. \n\nПожалуйста, поситите данную ссылку для активации вашего аккаунта: \nhttp://localhost:8080/activate/%s",
                    user.getUsername1(),
                    user.getActivationCode());


            mailSender.send(user.getEmail(), "Activation code", message);
        }
        return true;
    }

    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public User getUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

    public void save(User user) {
        userRepository.save(user);  // Сохраняем изменения в базе данных
    }

    public List<User> listAllUsers(){
        return userRepository.findAll();
    }


    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);
        if (user == null){
            return false;
        }
        user.setActivationCode(null);
        userRepository.save(user);
        return true;
    }
}