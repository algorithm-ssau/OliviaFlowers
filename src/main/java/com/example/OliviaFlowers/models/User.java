package com.example.OliviaFlowers.models;//package com.example.OliviaFlowers.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
@Data
public class User implements UserDetails {
    @Id
    @Column (name = "idUser")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "password")
    private String password;
    @Column (name = "email", unique = true)
    private String email;
    @Column (name = "phoneNumber", unique = true)
    private String phoneNumber;
    @Column (name = "name")
    private String name;
    @Column (name = "surname")
    private String surname;
    @Column (name = "dateOfBirthday")
    private LocalDate dateOfBirthday;
    @Column (name = "isAdministrator")
    private Boolean isAdministrator;

    @OneToMany(mappedBy = "user")
    Set<Favorite> favorites;

    @OneToMany(mappedBy="user")
    private List<Order> orders = new ArrayList<>();

    public String getEmail() {
        return email;
    }

    public Boolean getIsAdministrator(){
        return isAdministrator;
    }
    public void setIsAdministrator(boolean isAdministrator) {
        this.isAdministrator = isAdministrator;
    }

    public LocalDate getDateOfBirthday() {
        return dateOfBirthday;
    }

    public void setPassword(String password) {
        this.password = password;
    }




    // Security
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}