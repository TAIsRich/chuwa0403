package com.stream.repo;

import com.stream.model.Order;

import java.util.List;

public interface OrderRepo {
    public List<Order> findAll();
}
