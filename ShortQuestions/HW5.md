## 1. What is generic in Java? and type the generic code by yourself.
 It's a feature that allows classes and methods to operate on objects of various type while providing runtime type safety. Please also see coding folder.

## 2. Read those codes and type it one by one by yourself. the push the code to your branch.
Please see coding folder

## 3. practice stream API at least 3 times
Exercise 1 — Obtain a list of products belongs to category “Books” with price > 100
```
List<Product> result = productRepo.findAll()
  .stream()
  .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
  .filter(p -> p.getPrice() > 100)
  .collect(Collectors.toList());

  List<Product> result = productRepo.findAll()
  .stream()
  .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
  .filter(p -> p.getPrice() > 100)
  .collect(Collectors.toList());

  List<Product> result = productRepo.findAll()
  .stream()
  .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
  .filter(p -> p.getPrice() > 100)
  .collect(Collectors.toList());
```

Exercise 2 — Obtain a list of order with products belong to category “Baby”
```
List<Order> result = orderRepo.findAll()
        .stream()
        .filter(o -> 
          o.getProducts()
          .stream()
          .anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby"))
        )
        .collect(Collectors.toList());  
List<Order> result = orderRepo.findAll()
        .stream()
        .filter(o -> 
          o.getProducts()
          .stream()
          .anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby"))
        )
        .collect(Collectors.toList());  
List<Order> result = orderRepo.findAll()
        .stream()
        .filter(o -> 
          o.getProducts()
          .stream()
          .anyMatch(p -> p.getCategory().equalsIgnoreCase("Baby"))
        )
        .collect(Collectors.toList());  
```

Exercise 3 — Obtain a list of product with category = “Toys” and then apply 10% discount
```
List<Product> result = productRepo.findAll()
        .stream()
        .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
        .map(p -> p.withPrice(p.getPrice() * 0.9))
        .collect(Collectors.toList());  
List<Product> result = productRepo.findAll()
        .stream()
        .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
        .map(p -> p.withPrice(p.getPrice() * 0.9))
        .collect(Collectors.toList());  
List<Product> result = productRepo.findAll()
        .stream()
        .filter(p -> p.getCategory().equalsIgnoreCase("Toys"))
        .map(p -> p.withPrice(p.getPrice() * 0.9))
        .collect(Collectors.toList());  
```

Exercise 4 — Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
```
List<Product> result = orderRepo.findAll()
  .stream()
  .filter(o -> o.getCustomer().getTier() == 2)
  .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
  .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
  .flatMap(o -> o.getProducts().stream())
  .distinct()
  .collect(Collectors.toList());
List<Product> result = orderRepo.findAll()
  .stream()
  .filter(o -> o.getCustomer().getTier() == 2)
  .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
  .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
  .flatMap(o -> o.getProducts().stream())
  .distinct()
  .collect(Collectors.toList());
List<Product> result = orderRepo.findAll()
  .stream()
  .filter(o -> o.getCustomer().getTier() == 2)
  .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
  .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 4, 1)) <= 0)
  .flatMap(o -> o.getProducts().stream())
  .distinct()
  .collect(Collectors.toList());
```

Exercise 5 — Get the cheapest products of “Books” category
```
Optional<Product> result = productRepo.findAll()
        .stream()
        .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
        .sorted(Comparator.comparing(Product::getPrice))
        .findFirst();
Optional<Product> result = productRepo.findAll()
        .stream()
        .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
        .sorted(Comparator.comparing(Product::getPrice))
        .findFirst();
Optional<Product> result = productRepo.findAll()
        .stream()
        .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
        .sorted(Comparator.comparing(Product::getPrice))
        .findFirst();
```

Exercise 6 — Get the 3 most recent placed order
```
List<Order> result = orderRepo.findAll()
        .stream()
        .sorted(Comparator.comparing(Order::getOrderDate).reversed())
        .limit(3)
        .collect(Collectors.toList());
List<Order> result = orderRepo.findAll()
        .stream()
        .sorted(Comparator.comparing(Order::getOrderDate).reversed())
        .limit(3)
        .collect(Collectors.toList());
List<Order> result = orderRepo.findAll()
        .stream()
        .sorted(Comparator.comparing(Order::getOrderDate).reversed())
        .limit(3)
        .collect(Collectors.toList());
```

Exercise 7 — Get a list of orders which were ordered on 15-Mar-2021, log the order records to the console and then return its product list
```
List<Product> result = orderRepo.findAll()
    .stream()
    .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
    .peek(o -> System.out.println(o.toString()))
    .flatMap(o -> o.getProducts().stream())
    .distinct()
    .collect(Collectors.toList());
List<Product> result = orderRepo.findAll()
    .stream()
    .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
    .peek(o -> System.out.println(o.toString()))
    .flatMap(o -> o.getProducts().stream())
    .distinct()
    .collect(Collectors.toList());
List<Product> result = orderRepo.findAll()
    .stream()
    .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
    .peek(o -> System.out.println(o.toString()))
    .flatMap(o -> o.getProducts().stream())
    .distinct()
    .collect(Collectors.toList());
```

Exercise 8 — Calculate total lump sum of all orders placed in Feb 2021
```
Double result = orderRepo.findAll()
    .stream()
    .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
    .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
    .flatMap(o -> o.getProducts().stream())
    .mapToDouble(p -> p.getPrice())
    .sum();	
Double result = orderRepo.findAll()
    .stream()
    .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
    .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
    .flatMap(o -> o.getProducts().stream())
    .mapToDouble(p -> p.getPrice())
    .sum();	
Double result = orderRepo.findAll()
    .stream()
    .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 2, 1)) >= 0)
    .filter(o -> o.getOrderDate().compareTo(LocalDate.of(2021, 3, 1)) < 0)
    .flatMap(o -> o.getProducts().stream())
    .mapToDouble(p -> p.getPrice())
    .sum();	
```

Exercise 9 — Calculate order average payment placed on 14-Mar-2021
```
Double result = orderRepo.findAll()
        .stream()
        .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
        .flatMap(o -> o.getProducts().stream())
        .mapToDouble(p -> p.getPrice())
        .average().getAsDouble();
Double result = orderRepo.findAll()
        .stream()
        .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
        .flatMap(o -> o.getProducts().stream())
        .mapToDouble(p -> p.getPrice())
        .average().getAsDouble();
Double result = orderRepo.findAll()
        .stream()
        .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021, 3, 15)))
        .flatMap(o -> o.getProducts().stream())
        .mapToDouble(p -> p.getPrice())
        .average().getAsDouble();
```

Exercise 10 — Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category “Books”
```
DoubleSummaryStatistics statistics = productRepo.findAll()
    .stream()
    .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
    .mapToDouble(p -> p.getPrice())
    .summaryStatistics();
  
  System.out.println(String.format("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f", 
    statistics.getCount(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getSum()));
  
DoubleSummaryStatistics statistics = productRepo.findAll()
    .stream()
    .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
    .mapToDouble(p -> p.getPrice())
    .summaryStatistics();
  
  System.out.println(String.format("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f", 
    statistics.getCount(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getSum()));
  
DoubleSummaryStatistics statistics = productRepo.findAll()
    .stream()
    .filter(p -> p.getCategory().equalsIgnoreCase("Books"))
    .mapToDouble(p -> p.getPrice())
    .summaryStatistics();
  
  System.out.println(String.format("count = %1$d, average = %2$f, max = %3$f, min = %4$f, sum = %5$f", 
    statistics.getCount(), statistics.getAverage(), statistics.getMax(), statistics.getMin(), statistics.getSum()));
  
```

Exercise 11 — Obtain a data map with order id and order’s product count
```
Map<Long, Integer>  result = orderRepo.findAll()
        .stream()
        .collect(
            Collectors.toMap(
                order -> order.getId(),
                order -> order.getProducts().size()
                )
            );
Map<Long, Integer>  result = orderRepo.findAll()
        .stream()
        .collect(
            Collectors.toMap(
                order -> order.getId(),
                order -> order.getProducts().size()
                )
            );
Map<Long, Integer>  result = orderRepo.findAll()
        .stream()
        .collect(
            Collectors.toMap(
                order -> order.getId(),
                order -> order.getProducts().size()
                )
            );
```

Exercise 12 — Produce a data map with order records grouped by customer
```
Map<Customer, List<Order>> result = orderRepo.findAll()
        .stream()
        .collect(
            Collectors.groupingBy(Order::getCustomer)
            );
Map<Customer, List<Order>> result = orderRepo.findAll()
        .stream()
        .collect(
            Collectors.groupingBy(Order::getCustomer)
            );
Map<Customer, List<Order>> result = orderRepo.findAll()
        .stream()
        .collect(
            Collectors.groupingBy(Order::getCustomer)
            );
```

Exercise 13 — Produce a data map with order record and product total sum
```
Map<Order, Double> result = orderRepo.findAll()
        .stream()
        .collect(
          Collectors.toMap(
              Function.identity(), 
              order -> order.getProducts().stream()
                    .mapToDouble(p -> p.getPrice()).sum()
            ) 
          );
Map<Order, Double> result = orderRepo.findAll()
        .stream()
        .collect(
          Collectors.toMap(
              Function.identity(), 
              order -> order.getProducts().stream()
                    .mapToDouble(p -> p.getPrice()).sum()
            ) 
          );
Map<Order, Double> result = orderRepo.findAll()
        .stream()
        .collect(
          Collectors.toMap(
              Function.identity(), 
              order -> order.getProducts().stream()
                    .mapToDouble(p -> p.getPrice()).sum()
            ) 
          );
```

Exercise 14 — Obtain a data map with list of product name by category
```
Map<String, List<String>> result = productRepo.findAll()
        .stream()
        .collect(
            Collectors.groupingBy(
                Product::getCategory,
                Collectors.mapping(product -> product.getName(), Collectors.toList()))
            );
Map<String, List<String>> result = productRepo.findAll()
        .stream()
        .collect(
            Collectors.groupingBy(
                Product::getCategory,
                Collectors.mapping(product -> product.getName(), Collectors.toList()))
            );
Map<String, List<String>> result = productRepo.findAll()
        .stream()
        .collect(
            Collectors.groupingBy(
                Product::getCategory,
                Collectors.mapping(product -> product.getName(), Collectors.toList()))
            );
```

Exercise 15 — Get the most expensive product by category
```
Map<String, Optional<Product>> result = productRepo.findAll()
        .stream()
        .collect(
            Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparing(Product::getPrice))));
Map<String, Optional<Product>> result = productRepo.findAll()
        .stream()
        .collect(
            Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparing(Product::getPrice))));
Map<String, Optional<Product>> result = productRepo.findAll()
        .stream()
        .collect(
            Collectors.groupingBy(
                Product::getCategory,
                Collectors.maxBy(Comparator.comparing(Product::getPrice))));
```

## 4. Practice Optional methods at least 2 times
Please see coding folder

## 5. Write the Singleton design pattern include eager load and lazy load.
- Eager load:
```
public class Singleton {

    private static Singleton instance = new Singleton();
    private Singleton(){

    }
    
    public static Singleton getInstance(){
        return instance;
    }
}
```
- Lazy load:
```
public class Singleton{

    private static volatile Singleton instance;

    private Singleton(){

    }

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
    }
}
```

## 6. What is Runtime Exception? could you give me some examples?
A Runtime Exception is a type of exception in Java that can occur at runtime and does not have to be explicitly declared in a method or constructor's throws clause. This means that the code can compile without handling or declaring it explicitly, but it may still cause the program to terminate abnormally if not properly handled.
- NullPointerException - occurs when you try to access or invoke a method on a null object.

- ArrayIndexOutOfBoundsException - occurs when you try to access an array element at an index that is outside the array bounds.

- IllegalArgumentException - occurs when a method is passed an argument that is illegal or inappropriate for the given method.

- ArithmeticException - occurs when an arithmetic operation results in an overflow or divide-by-zero error.

- ClassCastException - occurs when you try to cast an object to a type that it is not compatible with.

- IllegalStateException - occurs when the state of an object is not as expected, for example, when a method is called on an object in an invalid state.

## 7. Could you give me one example of NullPointerException?
```
public static void main(String[] args) {
        String str = null;
        int length = str.length(); 
}
```

## 8. What is Optional class?
The Optional class is a container object introduced in Java 8 that can contain either a single non-null value or no value at all. It is designed to provide a more elegant way to handle null values in your code, while also avoiding the risk of null pointer exceptions.

## 9. What are the advantages of using the Optional class?
Avoiding null pointer exceptions, Improving code readability, Providing a more fluent API, Encouraging better design

## 10. What is the @FunctionalInterface
 It is an annotation introduced in Java 8 that can be applied to an interface to indicate that it is intended to be a functional interface. A functional interface is an interface that has exactly one abstract method and is used to represent a single function or behavior.

## 11. what is lamda?
In Java, a lambda expression is essentially a shorthand way to define a single-method interface implementation, which can be used wherever a functional interface is expected.

## 12. What is Method Reference?
Method reference is a shorthand syntax introduced in Java 8 that allows you to reference an existing method by name, rather than writing a lambda expression to define a new method implementation.

## 13. What is Java 8 new features?
- Lambda expressions: A new way to write concise and expressive code for functional programming.

- Stream API: A powerful API for processing collections of data in a functional style.

- Date and Time API: A new API for working with dates and times, including improved support for time zones and calendars.

- Default methods: A new way to add methods to interfaces without breaking existing implementations.

- Optional class: A container object to represent the presence or absence of a value.

- Method references: A shorthand syntax for referencing an existing method by name, rather than writing a lambda expression to define a new method implementation.

- Functional interfaces: A new annotation that can be applied to an interface to indicate that it is intended to be a functional interface.

- Nashorn JavaScript engine: A new JavaScript engine that can be used to embed JavaScript in Java applications.

- Parallel streams: A way to process collections of data in parallel, taking advantage of multi-core processors to improve performance.

## 14. Lambda can use unchanged variable outside of lambda? what is the details?
That means lambda can used final variable or effectively final variables.

## 15. Describe the newly added features in Java 8?
- Lambda expressions: A new way to write concise and expressive code for functional programming.

- Stream API: A powerful API for processing collections of data in a functional style.

- Date and Time API: A new API for working with dates and times, including improved support for time zones and calendars.

- Default methods: A new way to add methods to interfaces without breaking existing implementations.

- Optional class: A container object to represent the presence or absence of a value.

- Method references: A shorthand syntax for referencing an existing method by name, rather than writing a lambda expression to define a new method implementation.

- Functional interfaces: A new annotation that can be applied to an interface to indicate that it is intended to be a functional interface.

- Nashorn JavaScript engine: A new JavaScript engine that can be used to embed JavaScript in Java applications.

- Parallel streams: A way to process collections of data in parallel, taking advantage of multi-core processors to improve performance.

## 16. Can a functional interface extend/inherit another interface?
Yes but can only extend a functional interface.

## 17. What is the lambda expression in Java and How does a lambda expression relate to a functional interface?
In Java, a lambda expression is essentially a shorthand way to define a single-method interface implementation, which can be used wherever a functional interface is expected.

## 18. In Java 8, what is Method Reference?
Method reference is a shorthand syntax introduced in Java 8 that allows you to reference an existing method by name, rather than writing a lambda expression to define a new method implementation.

## 19. What does the String::ValueOf expression mean?
The String::valueOf expression is a method reference to the static valueOf method of the String class. This method takes an argument of any type and returns a String type of that value.

## 20. What are Intermediate and Terminal operations?
- Intermediate operations are operations that return a new stream as a result of the operation. The purpose of intermediate operations is to transform or filter the data in the stream before it is consumed by a terminal operation.

- Terminal operations are operations that produce a non-stream result, such as a value or a collection, as a result of the operation. The purpose of terminal operations is to consume the data in the stream and produce some final result. Once a terminal operation is applied to a stream, the stream can no longer be used.

## 21. What are the most commonly used Intermediate operations?
- map(): Transform each element in the stream into another element by applying a function.
- filter(): Filter the elements in the stream by a given predicate.
- distinct(): Remove duplicates from the stream.
- sorted(): Sort the elements in the stream.

## 22. What is the difference between findFirst() and findAny()?
 findFirst() is more deterministic and useful when you need a specific element from the stream, while findAny() is more flexible and useful when you only need to find any element that meets a certain condition.


## 23. How are Collections different from Stream?
collections are data structures that store and manipulate data in memory, while streams are a way to process and manipulate data in a declarative way without explicitly manipulating the data structures themselves.
