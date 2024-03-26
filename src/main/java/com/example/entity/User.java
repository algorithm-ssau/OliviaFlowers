package com.example.entity;

import jakarta.persistence.PrePersist;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
    private Long id;
    private String password;
    private String email;
    private String phoneNumber;
    private String name;
    private String surname;
    private Date dateOfBirthday;
    private Boolean isAdministrator;

    private List<Order> orders = new ArrayList<>();
    private LocalDateTime createdDate;

    @PrePersist
    protected void onCreate()
    {
        this.createdDate = LocalDateTime.now();
    }


}
