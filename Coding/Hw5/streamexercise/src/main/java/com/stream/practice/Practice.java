package com.stream.practice;

import com.stream.model.Customer;
import com.stream.model.Order;
import com.stream.model.Product;
import com.stream.repo.CustomerRepo;
import com.stream.repo.OrderRepo;
import com.stream.repo.ProductRepo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Practice {
    public static ProductRepo productRepo;
    public static CustomerRepo customerRepo;
    public static OrderRepo orderRepo;
    public void practice1() {
//        Obtain a list of products belongs to category “Books” with price > 100
        List<Product> res = productRepo.findAll().stream()
                .filter(book -> book.getCategory().equalsIgnoreCase("book") &&
                        book.getPrice() > 100)
                .collect(Collectors.toList());
    }

    public void practice2() {
//        Obtain a list of order with products belong to category “Baby”
        List<Order> res = orderRepo.findAll().stream()
                .filter(order -> {
                    return order.getProducts().stream().map(Product::getCategory).filter(c -> c.equalsIgnoreCase("baby")).findAny().isEmpty();
                }).collect(Collectors.toList());
        List<Order> result = orderRepo.findAll()
                .stream()
                .filter(o ->
                        o.getProducts()
                                .stream()
                                .anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby"))
                )
                .collect(Collectors.toList());
    }

    public void practice3() {
//        Obtain a list of product with category = “Toys” and then apply 10% discount
        productRepo.findAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase(("Toys")))
                .forEach(p -> p.setPrice(p.getPrice() * 0.9));
    }

    public void pratice4() {
//        Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
        List<Product> res = orderRepo.findAll().stream()
                .filter(o -> o.getCustomer().getTier() == 2 &&
                        o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1))> 0 &&
                        o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) < 0)
                .flatMap(o -> o.getProducts().stream()).distinct().collect(Collectors.toList());
    }

    public void pratice5() {
//        Get the cheapest products of “Books” category
        Product res = productRepo.findAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("books"))
                .sorted(Comparator.comparingDouble(Product::getPrice)).findFirst().get();
    }

    public void pratice6() {
//        Get the 3 most recent placed order
        List<Order> res = orderRepo.findAll().stream()
                .sorted((o1, o2) -> o2.getOrderDate().compareTo(o1.getOrderDate()))
                .limit(3)
                .collect(Collectors.toList());
    }

    public void pratice7() {
//        Get a list of orders which were ordered on 15-Mar-2021,
//        log the order records to the console and then return its product list
        List<Product> res = orderRepo.findAll().stream()
                .filter(o -> o.getOrderDate().equals(LocalDate.of(2021, 3, 15)))
                .peek(o -> System.out.println(o.toString()))
                .flatMap(o -> o.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());

//        peek() allows execution of system logic as part of a stream flow.
    }

    public void practice8() {
//        Calculate total lump sum of all orders placed in Feb 2021
        double res = orderRepo.findAll().stream()
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1))> 0 &&
                        o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(p -> p.getPrice())
                .sum();
    }

    public void pratice9() {
//        Calculate order average payment placed on 14-Mar-2021
        double res = orderRepo.findAll().stream()
                .filter(o -> o.getOrderDate().equals(LocalDate.of(2021, 3, 15)))
                .flatMap(o -> o.getProducts().stream())
                .mapToDouble(p -> p.getPrice())
                .average().getAsDouble();
    }

    public void practice10() {
//        Obtain a collection of statistic figures (i.e. sum, average, max, min, count)
//        for all products of category “Books”
        DoubleSummaryStatistics statistics = productRepo.findAll().stream()
                .filter(p -> p.getCategory().equalsIgnoreCase("books"))
                .mapToDouble(p -> p.getPrice())
                .summaryStatistics();
    }

    public void practice11() {
//        Obtain a data map with order id and order’s product count
        Map<Long, Integer> res = orderRepo.findAll().stream()
                .collect(Collectors.toMap(
                        o -> o.getId(),
                        o -> o.getProducts().size()
                ));
    }

    public void pratice12() {
//        Produce a data map with order records grouped by customer
        Map<Customer, List<Order>> res = orderRepo.findAll().stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
    }

    public void practice13() {
//        Produce a data map with order record and product total sum
        Map<Order, Double> res = orderRepo.findAll().stream()
                .collect(Collectors.toMap(
                        o -> o,
                        o -> o.getProducts().stream().mapToDouble(Product::getPrice).sum()
                ));
    }

    public void pratice14() {
//        Obtain a data map with list of product name by category
        Map<String, List<String>> res = productRepo.findAll().stream()
                .collect(Collectors.groupingBy(
                        o -> o.getCategory(),
                        Collectors.mapping(Product::getName, Collectors.toList())
                ));
    }

    public void pratice15() {
//        Get the most expensive product by category
        Map<String, Optional<Product>> res = productRepo.findAll().stream()
                .collect(Collectors.groupingBy(
                        o -> o.getCategory(),
                        Collectors.maxBy(Comparator.comparingDouble(Product::getPrice))
                ));
    }




}
