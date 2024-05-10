package com.example.OliviaFlowers.models;//package com.example.OliviaFlowers.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`order`")
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  //id заказа

    @ManyToOne
    private User user; //id пользователя

    @Column
    private Long typePostcard; //тип открытки

    @Column
    private String textPostcard; //текст открытки

    @Column
    private Boolean toDeliver; //доставка или самовывоз

    @Column
    private String address; //Адрес доставки заказа

    //@Column
    //private LocalDateTime dateTimeDelivery; //время доставки

    @Column
    private Long sumOrderl; //сумма заказа

    //@Column
    //private LocalDateTime datePayment; //время оплаты заказа

    @OneToMany(mappedBy = "order")
    private Set<Order_has_bouquet> amounts;

    @Column
    private Long active; //активный заказ или нет





}