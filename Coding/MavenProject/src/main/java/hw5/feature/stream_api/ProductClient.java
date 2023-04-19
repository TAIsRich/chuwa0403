package hw5.feature.stream_api;

import org.junit.Test;

import java.util.*;
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
    public void toList(){
        List<Product> filteredProducts = productList.stream()
                .filter(product -> product.getStock()>10)
                .collect(Collectors.toList());
    }

    @Test
    public void toSet(){
        Set<String> p = productList.stream()
                .map(Product::getCategory)
                .collect(Collectors.toSet());
    }

    @Test
    public void joining(){
        String allProductName = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining(", "));

        String allNameNewLine = productList.stream()
                .map(Product::getName)
                .collect(Collectors.joining("\n"));
    }

    @Test
    public void counting(){
        Map<String, Long> counts = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    }

    @Test
    public void summingInt(){
        int total = productList.stream()
                .collect(Collectors.summingInt(Product::getStock));
    }

    @Test
    public void groupingBy(){
        Map<String, Integer> category = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.summingInt(Product::getStock)));
        Map<String, Double> average = productList.stream()
                .collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));

    }

    @Test
    public void partitioningBy(){
        Map<Boolean, List<Product>> ans = productList.stream()
                .collect(Collectors.partitioningBy(p -> p.getPrice()>100));
    }

    @Test
    public void mapping(){
        Set<String> names = productList.stream()
                .map(Product::getName)
                .map(String::toUpperCase)
                .collect(Collectors.toSet());
    }

    @Test
    public void match(){
        boolean isExpensive = productList.stream()
                .anyMatch(product -> product.getPrice()>250);
        System.out.println("is there any expensive?" + isExpensive);

        boolean allInStock = productList.stream()
                .allMatch(product -> product.getStock()>0);
        System.out.println("All in stock? "+allInStock);

        boolean noFree = productList.stream()
                .noneMatch(product -> product.getPrice()==0);
        System.out.println("No free? "+noFree);
    }

    @Test
    public void findFirst(){
        Optional<Product> first = productList.stream()
                .filter(product -> product.getPrice()>100)
                .findFirst();
        first.ifPresent(product -> System.out.println("has one with "+product.getPrice()));
    }

    @Test
    public void findAny(){
        Optional<Product> anyLowStock = productList.stream()
                .filter(product -> product.getStock()<10)
                .findAny();
        //not guarantee the first one
        anyLowStock.ifPresent(product -> System.out.println("any low:"+product.getName()));
    }
}
