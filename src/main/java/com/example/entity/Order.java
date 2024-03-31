package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //id заказа

    @Column
    private Long userId; //id пользователя

    @Column
    private Long typePostcard; //тип открытки

    @Column
    private String textPostcard; //текст открытки

    @Column
    private Boolean toDeliver; //доставка или самовывоз

    @Column
    private String address; //Адрес доставки заказа

    @Column
    private LocalDateTime dateTimeDelivery; //время доставки

    @Column
    private Long sumOrderl; //сумма заказа

    @Column
    private LocalDateTime datePayment; //время оплаты заказа



}
