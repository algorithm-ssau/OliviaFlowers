package com.example.OliviaFlowers.secvices;

import com.example.OliviaFlowers.models.User;
import com.example.OliviaFlowers.models.UserWithoutLink;
import com.example.OliviaFlowers.repositories.UserRepository;
import com.example.OliviaFlowers.repositories.UserWithoutLinkRepository;
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
    private final UserWithoutLinkRepository userWithoutLinkRepository;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, UserWithoutLinkRepository userWithoutLinkRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userWithoutLinkRepository = userWithoutLinkRepository;
    }

    public boolean createUser(UserWithoutLink userWithoutLink){
        String email = userWithoutLink.getEmail();
        if (userRepository.findByEmail(email) != null || userWithoutLinkRepository.findByEmail(email) != null) {
            return false;
        }

        userWithoutLink.setPassword(passwordEncoder.encode(userWithoutLink.getPassword()));
        userWithoutLink.setActivationCode(UUID.randomUUID().toString());

        userWithoutLinkRepository.save(userWithoutLink);

        if(!StringUtils.isEmpty(userWithoutLink.getEmail())) {
            String message = String.format("Здравствуйте, %s! \n\n" +
                            "Добро пожаловать в OliviaFlowers. \n\nПожалуйста, поситите данную ссылку для активации вашего аккаунта: \nhttp://localhost:8080/activate/%s" +
                            "\n\nИли по этой ссылке: http://176.109.100.154:8080/activate/%s",
                    userWithoutLink.getName(),
                    userWithoutLink.getActivationCode(),
                    userWithoutLink.getActivationCode());

            mailSender.send(userWithoutLink.getEmail(), "Activation code", message);
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
        UserWithoutLink userWithoutLink = userWithoutLinkRepository.findByActivationCode(code);
        if (userWithoutLink == null) {
            return false;
        }

        User user = new User();
        user.setEmail(userWithoutLink.getEmail());
        user.setPassword(userWithoutLink.getPassword());
        user.setPhoneNumber(userWithoutLink.getPhoneNumber());
        user.setName(userWithoutLink.getName());
        user.setSurname(userWithoutLink.getSurname());
        user.setDateOfBirthday(userWithoutLink.getDateOfBirthday());
        user.setIsAdministrator(false);
        user.setActivationCode(null);

        userRepository.save(user);
        userWithoutLinkRepository.delete(userWithoutLink);

        return true;
    }
}