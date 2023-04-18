package hw5.stream_exercise.exercises;

import hw5.stream_exercise.data_model.*;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercise {
    List<Product> products = Arrays.asList(
            new Product(1L,"A","Books",10.0,null),
            new Product(2L,"B","Toys",10.0,null)
    );
    List<Order> orders = new ArrayList<>();
    List<Customer> customers = new ArrayList<>();
    // Obtain a list of products belongs to category “Books” with price > 100
    public List<Product> ex1(){
        List<Product> ans = products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .filter(product -> product.getPrice()>100)
                .collect(Collectors.toList());
        return ans;
    }

    // Obtain a list of order with products belong to category “Baby”
    public List<Order> ex2(){
        return orders.stream().filter(
                order -> order.getProducts().stream().anyMatch(
                        product -> product.getCategory().equalsIgnoreCase("Baby")
                )
        ).collect(Collectors.toList());
    }

    //Obtain a list of product with category = “Toys” and then apply 10% discount
    @Test
    public void ex3(){
        List<Product> ans = products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Toys"))
                .map(product -> {
                    product.setPrice(product.getPrice()*0.9);
                    return product;
                })
                .collect(Collectors.toList());
        ans.forEach(product -> System.out.println(product.getPrice()));
        products.forEach(product -> System.out.println(product.getPrice()));
        // already change the original product list
        // if don't want change, should use product-> new Product(xxx)
    }

    // Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
    public List<Product> ex4(){
        List<Product> productList = orders.stream()
                .filter(order -> order.getCustomer().getTier()==2)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021,2,1))>=0)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021,4,1))<=0)
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
        return productList;

    }

    // Get the cheapest products of “Books” category
    public Optional<Product> ex5(){
        Optional<Product> ans = products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .sorted(Comparator.comparing(Product::getPrice))
                .findFirst();
        return ans;
        // or just use min(Comparator.comparing(product::getPrice))

    }

    // Get the 3 most recent placed order
    public List<Order> ex6(){
        List<Order> ans = orders.stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
        return ans;
    }

    // Get a list of orders which were ordered on 15-Mar-2021,
    // log the order records to the console and then return its product list
    public List<Product> ex7(){
        List<Product> ans = orders.stream()
                .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
                .peek(System.out::println)
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
        return ans;
    }

    // Calculate total lump sum of all orders placed in Feb 2021
    public double ex8(){
        Double res = orders.stream()
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021,2,1))>=0)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021,3,1))< 0)
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
        return res;
    }

    // Calculate order average payment placed on 14-Mar-2021
    public double ex9(){
        Double res = orders.stream()
                .filter(order -> order.getOrderDate().equals(LocalDate.of(2021,3,14)))
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .average().getAsDouble();
        return res;
    }

    // Obtain a collection of statistic figures (i.e. sum, average, max, min, count)
    // for all products of category “Books”
    public void ex10(){
        DoubleSummaryStatistics summaryStatistics = products.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();
        System.out.println(String.format("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f",
                summaryStatistics.getCount(), summaryStatistics.getAverage(), summaryStatistics.getMax(),
                summaryStatistics.getMin(), summaryStatistics.getSum()));

    }

    //  Obtain a data map with order id and order’s product count
    public Map<Long, Integer> ex11(){
        Map<Long, Integer> ans = orders.stream()
                .collect(Collectors.toMap(Order::getId, order -> order.getProducts().size()));
        return ans;
    }

    // Produce a data map with order records grouped by customer
    public Map<Customer, List<Order>> ex12(){
        return orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomer));
    }

    //  Produce a data map with order record and product total sum
    public Map<Order, Double> ex13(){
        return orders.stream()
                .collect(Collectors.toMap(Function.identity(),
                        order -> order.getProducts().stream().mapToDouble(Product::getPrice).sum()));
    }

    //  Obtain a data map with list of product name by category
    public Map<String, List<String>> ex14(){
        return products.stream()
                .collect(Collectors.groupingBy(Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())));
    }

    //  Get the most expensive product by category
    public Map<String, Optional<Product>> ex15(){
        return products.stream()
                .collect(
                        Collectors.groupingBy(Product::getCategory,
                                Collectors.maxBy(Comparator.comparing(Product::getPrice)))
                );
    }





}
