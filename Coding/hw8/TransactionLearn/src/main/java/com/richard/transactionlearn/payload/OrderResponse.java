package com.richard.transactionlearn.payload;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author zhuhaotian
 * @Date 2023/5/1
 */

@Getter
@Setter
public class OrderResponse {

    private String orderTrackingNumber;

    private String status;

    private String message;
}
