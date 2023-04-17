package com.stream.repo;

import com.stream.model.Customer;

import java.util.List;

public interface CustomerRepo {

    public List<Customer> findAll();
}
