package com.richard.transactionlearn.payload;

import com.richard.transactionlearn.entity.Order;
import com.richard.transactionlearn.entity.Payment;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author zhuhaotian
 * @Date 2023/5/1
 */

@Getter
@Setter
public class OrderRequest {

    private Order order;

    private Payment payment;
}
