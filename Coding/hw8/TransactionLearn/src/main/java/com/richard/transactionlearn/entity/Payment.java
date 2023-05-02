package com.richard.transactionlearn.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * @Author zhuhaotian
 * @Date 2023/5/1
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private String cardName;
    private String cardNumber;
    private int expireYear;
    private int expireMonth;
    private int cvc;

    private Long orderId;
}
