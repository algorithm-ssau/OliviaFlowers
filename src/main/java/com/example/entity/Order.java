package com.example.entity;

import java.time.LocalDateTime;

public class Order {
    private Long id;  //id заказа
    private Long userId; //id пользователя
    private Long typePostcard; //тип открытки
    private String textPostcard; //текст открытки

    private Boolean toDeliver; //доставка или самовывоз
    private String address; //Адрес доставки заказа

    private LocalDateTime dateTimeDelivery; //время доставки

    private Long sumOrderl; //сумма заказа

    private LocalDateTime datePayment; //время оплаты заказа



}
