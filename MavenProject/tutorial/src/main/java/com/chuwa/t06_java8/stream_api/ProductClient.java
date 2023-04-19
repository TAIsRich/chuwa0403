package com.chuwa.t06_java8.stream_api;

import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ProductClient {
    static List<Product> productList = Arrays.asList(
            new Product(1, "Product 1", "Electronics", 99.99, 20),
            new Product(2, "Product 2", "Electronics", 199.99, 15),
            new Product(3, "Product 3", "Electronics", 299.99, 5),
            new Product(4, "Product 4", "Clothing", 49.99, 30),
            new Product(5, "Product 5", "Clothing", 29.99, 25),
            new Product(6, "Product 6", "Clothing", 59.99, 10),
            new Product(7, "Product 7", "Kitchen", 89.99, 8),
            new Product(8, "Product 8", "Kitchen", 120.99, 2),
            new Product(9, "Product 9", "Kitchen", 60.99, 15)
    );

    @Test
    public void toList() {
        List<Product> filteredProducts = productList.stream()
                .filter(product -> product.getStock() > 10)
                .collect(Collectors.toList());
        System.out.println(filteredProducts);
    }

    @Test
    public void toSet() {
        Set<String> uniqueCategories = productList.stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet());
        System.out.println(uniqueCategories);
    }


    @Test
    public void joining() {
        String allProductNames = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(","));

        String allProductNamesNewLine = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining("\n"));

        System.out.println(allProductNames);
        System.out.println(allProductNamesNewLine);
    }

    @Test
    public void counting() {
        Map<String, Long> categoryCounts = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
        System.out.println(categoryCounts);

        Map<String, Set<String>> map = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.mapping(Product::getName, Collectors.toSet())));

        System.out.println(map);

    }

    @Test
    public void summingInt() {
        int totalStock = productList.stream()
                .collect(Collectors.summingInt(Product::getStock));
        System.out.println();
    }

    @Test
    public void groupingBy() {
        Map<String, Integer> categoryStock = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingInt(Product::getStock)));

        Map<String, Double> categoryAveragePrice = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

        System.out.println(categoryStock);
        System.out.println(categoryAveragePrice);
    }

    @Test
    public void maxBy() {
        Optional<Product> maxPriceProduct = productList.stream()
                .collect(Collectors.maxBy((a, b) -> (int)(a.getPrice()- b.getPrice())));

        Optional<Product> maxPriceProduct2 = productList.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)));
        System.out.println(maxPriceProduct.get());
    }


    @Test
    public void partitioningBy() {
        Map<Boolean, List<Product>> partioningProducts = productList.stream()
                .collect(Collectors.partitioningBy(p -> p.getPrice() > 100));
        System.out.println(partioningProducts);

        Map<Boolean, List<Product>> groupProducts = productList.stream()
                .collect(Collectors.groupingBy(p -> p.getPrice() > 100, Collectors.mapping(Function.identity(), Collectors.toList())));

        System.out.println(groupProducts);
    }

    @Test
    public void map() {
        Set<String> upperCaseNames = productList.stream()
                .map(Product::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
        System.out.println(upperCaseNames);

    }

    @Test
    public void match() {
        boolean isAnyProductExpensive = productList.stream()
                .anyMatch(product -> product.getPrice() > 250);
        System.out.println("Is there any expensive product? " + isAnyProductExpensive);

        // allMatch example
        boolean areAllProductsInStock = productList.stream()
                .allMatch(product -> product.getStock() > 0);
        System.out.println("Are all products in stock? " + areAllProductsInStock);

        // noneMatch example
        boolean areNoProductsFree = productList.stream()
                .noneMatch(product -> product.getPrice() == 0);
        System.out.println("Are there no free products? " + areNoProductsFree);
    }

    @Test
    public void findFirst() {
        Optional<Product> first = productList.stream()
                .filter(product -> product.getPrice() > 100)
                .findFirst();
        first.ifPresent(product -> System.out.println(product.getName()));
    }

    @Test
    public void findAny() {

        // findAny example
        Optional<Product> anyLowStockProduct = productList.stream()
                .filter(product -> product.getStock() < 10)
                .findAny();
        anyLowStockProduct.ifPresent(product -> System.out.println("Any low stock product: " + product.getName()));
    }
}
