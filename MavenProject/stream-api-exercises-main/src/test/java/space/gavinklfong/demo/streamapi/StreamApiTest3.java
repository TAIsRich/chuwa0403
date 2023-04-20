package space.gavinklfong.demo.streamapi;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import space.gavinklfong.demo.streamapi.models.Customer;
import space.gavinklfong.demo.streamapi.models.Order;
import space.gavinklfong.demo.streamapi.models.Product;
import space.gavinklfong.demo.streamapi.repos.CustomerRepo;
import space.gavinklfong.demo.streamapi.repos.OrderRepo;
import space.gavinklfong.demo.streamapi.repos.ProductRepo;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
@DataJpaTest
public class StreamApiTest3 {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProductRepo productRepo;

    @Test
    @DisplayName("Obtain a list of product with category = \"Books\" and price > 100")
    public void exercise1() {
        List<Product> result = productRepo.findAll()
                .stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .filter(product -> product.getPrice() > 100)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("Obtain a list of order with product category = \"Baby\"")
    public void exercise2() {
        List<Order> result = orderRepo.findAll()
                .stream()
                .filter(order -> order.getProducts()
                        .stream().
                        anyMatch(product -> product.getCategory().equalsIgnoreCase("Baby"))
                )
                .collect(Collectors.toList());

    }

    @Test
    @DisplayName("Obtain a list of product with category = “Toys” and then apply 10% discount\"")
    public void exercise3() {
        List<Product> result = productRepo.findAll()
                .stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Toys"))
                .map(product -> product.withPrice(product.getPrice() * 0.9))
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021")
    public void exercise4() {
        List<Product> result = orderRepo.findAll()
                .stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                .filter(order -> order.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("Get the 3 cheapest products of \"Books\" category")
    public void exercise5() {
        List<Product> result = productRepo.findAll()
                .stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .sorted(Comparator.comparing(Product::getPrice))
                .limit(3)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("Get the 3 most recent placed order")
    public void exercise6() {
        List<Order> result = orderRepo.findAll()
                .stream()
                .sorted(Comparator.comparing(Order::getOrderDate).reversed())
                .limit(3)
                .collect(Collectors.toList());
    }

    @Test
    @DisplayName("Get a list of products which was ordered on 15-Mar-2021")
    public void exercise7() {
        List<Product> result = orderRepo.findAll()
                .stream()
                .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
                .flatMap(order -> order.getProducts().stream())
                .distinct()
                .collect(Collectors.toList());
    }


    @Test
    @DisplayName("Calculate the total lump of all orders placed in Feb 2021")
    public void exercise8() {
        double totalPrice = orderRepo.findAll()
                .stream()
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
                .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .sum();
    }

    @Test
    @DisplayName("Calculate the average price of all orders placed on 15-Mar-2021")
    public void exercise9() {
        double averagePrice = orderRepo.findAll()
                .stream()
                .filter(order -> order.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(Product::getPrice)
                .average()
                .orElse(0.0);

    }

    @Test
    @DisplayName("Obtain statistics summary of all products belong to \"Books\" category")
    public void exercise10() {
        DoubleSummaryStatistics statistics = productRepo.findAll()
                .stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("Books"))
                .mapToDouble(Product::getPrice)
                .summaryStatistics();
    }

    @Test
    @DisplayName("Obtain a mapping of order id and the order's product count")
    public void exercise11() {
        Map<Long, Integer> map = orderRepo.findAll()
                .stream()
                .collect(
                        Collectors.toMap(
                                Order::getId,
                                order -> order.getProducts().size()
                        )
                );
    }

    @Test
    @DisplayName("Obtain a data map of customer and list of orders")
    public void exercise12() {
        Map<Customer, List<Order>> result =  orderRepo.findAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Order::getCustomer,
                                Collectors.mapping(
                                        Function.identity(),
                                        Collectors.toList()
                                )
                        )
                );
    }

    @Test
    @DisplayName("Obtain a data map of customer_id and list of order_id(s)")
    public void exercise12a() {
        Map<Long, List<Long>> result = orderRepo.findAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                order -> order.getCustomer().getId(),
                                Collectors.mapping(
                                        Order::getId,
                                        Collectors.toList()
                                )
                        )
                );
    }

    @Test
    @DisplayName("Obtain a data map with order and its total price")
    public void exercise13() {
        Map<Order, Double> map = orderRepo.findAll()
                .stream()
                .collect(
                        Collectors.toMap(
                                Function.identity(),
                                order -> order.getProducts()
                                        .stream()
                                        .mapToDouble(Product::getPrice)
                                        .sum()
                        )
                );
    }


    @Test
    @DisplayName("Obtain a data map of product name by category")
    public void exercise14() {
        Map<String, List<String>> map = productRepo.findAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.mapping(
                                        Product::getName,
                                        Collectors.toList()
                                )
                        )
                );
    }

    @Test
    @DisplayName("Get the most expensive product per category")
    void exercise15() {
        Map<String, Product> map = productRepo.findAll()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparing(Product::getPrice)),
                                        optionalProduct -> optionalProduct.orElse(null)
                                )

                        )
                );
    }
}
