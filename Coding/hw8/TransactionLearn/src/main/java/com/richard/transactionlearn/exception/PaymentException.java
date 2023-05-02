package com.richard.transactionlearn.exception;

/**
 * @Author zhuhaotian
 * @Date 2023/5/1
 */

public class PaymentException extends RuntimeException {

    public PaymentException(String message){
        super(message);
    }
}
