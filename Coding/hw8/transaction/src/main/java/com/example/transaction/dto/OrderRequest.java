package com.example.transaction.dto;

import com.example.transaction.entity.Order;
import com.example.transaction.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderRequest {
    private Order order;
    private Payment payment;
}
