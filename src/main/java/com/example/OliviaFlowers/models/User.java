package com.example.OliviaFlowers.models;//package com.example.OliviaFlowers.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private Date dateOfBirthday;
    @Column
    private Boolean isAdministrator;

    @OneToMany(mappedBy="user")
    private List<Order> orders = new ArrayList<>();
}