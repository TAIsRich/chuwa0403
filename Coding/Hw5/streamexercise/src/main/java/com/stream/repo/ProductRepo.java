package com.stream.repo;

import com.stream.model.Product;

import java.util.List;

public interface ProductRepo {

    public List<Product> findAll();
}
