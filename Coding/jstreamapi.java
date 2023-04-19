public class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int stock;
    public Product(int id, String name, String category, double price, int stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}
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
        List<Product> filteredProducts = productList.stream().filter(product -> product.getStock() > 10).collect(Collectors.toList());
    }
    @Test
    public void toSet() {
        Set<String> uniqueCategories = productList.stream().map(Product::getCategory).collect(Collectors.toSet());
    }
    @Test
    public void joining() {
        String allProductNames = productList.stream().map(Product::getName).collect(Collectors.joining(", "));
        String allProductNamesNewLine = productList.stream().map(Product::getName).collect(Collectors.joining("\n"));
    }
    @Test
    public void counting() {
        Map<String, Long> categoryCounts = productList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.counting()));
    }
    @Test
    public void summingInt() {
        int totalStock = productList.stream().collect(Collectors.summingInt(Product::getStock));
    }
    @Test
    public void groupingBy() {
        Map<String, Integer> categoryStock = productList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.summingInt(Product::getStock)));
        Map<String, Double> categoryAveragePrice = productList.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.averagingDouble(Product::getPrice)));
    }
    @Test
    public void maxBy() {
        Optional<Product> maxPriceProduct = productList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Product::getPrice)));
    }
    @Test
    public void partitioningBy() {
        Map<Boolean, List<Product>> partitionedProducts = productList.stream().collect(Collectors.partitioningBy(p -> p.getPrice() > 100));
    }
    @Test
    public void mapping() {
        Set<String> upperCaseNames = productList.stream().map(Product::getName).map(String::toUpperCase).collect(Collectors.toSet());
    }
    @Test
    public void match() {
        boolean isAnyProductExpensive = productList.stream().anyMatch(product -> product.getPrice() > 250);
        System.out.println("Is there any expensive product? " + isAnyProductExpensive);
        boolean areAllProductsInStock = productList.stream().allMatch(product -> product.getStock() > 0);
        System.out.println("Are all products in stock? " + areAllProductsInStock);
        boolean areNoProductsFree = productList.stream().noneMatch(product -> product.getPrice() == 0);
        System.out.println("Are there no free products? " + areNoProductsFree);
    }
    @Test
    public void findFirst() {
        Optional<Product> firstExpensiveProduct = productList.stream().filter(product -> product.getPrice() > 100).findFirst();
        firstExpensiveProduct.ifPresent(product -> System.out.println("First expensive product: " + product.getName()));
    }
    @Test
    public void findAny() {
        Optional<Product> anyLowStockProduct = productList.stream().filter(product -> product.getStock() < 10).findAny();
        anyLowStockProduct.ifPresent(product -> System.out.println("Any low stock product: " + product.getName()));
    }
}
public class StreamApiCreationTest {
    @Test
    public void testCollection() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        col.forEach(System.out::println);
        Stream<Integer> stream = col.stream();
        System.out.println("Stream object:      " + stream);
        Stream<Integer> parallelStream = col.parallelStream();
        System.out.println("Parallel Stream object:     " + parallelStream);
    }
    @Test
    public void testArrays() {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(arr);
        System.out.println("Stream object:      " + stream);
        Employee e1 = new Employee(1001, "tom", 20, 2222);
        Employee e2 = new Employee(1002, "Jerry", 18, 5000);
        Employee[] arr1 = new Employee[]{e1, e2};
        Stream<Employee> stream1 = Arrays.stream(arr1);
        System.out.println("Stream object:     " + stream1);
    }
    @Test
    public void testOf() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        System.out.println("Stream object:      " + stream);
    }
    @Test
    public void testIterate() {
        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
    }
    @Test
    public void testGenerate() {
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);
        streamGenerated.forEach(System.out::println);
    }
    @Test
    public void testStreamOfPrimitives() {
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);
        System.out.println("Stream Object:  " + intStream);
        intStream.forEach(System.out::println);
        System.out.println("Stream Object:  " + longStream);
        longStream.forEach(System.out::println);
    }
}
public class StreamApiEndOperation {
    private static final List<Employee> EMPLOYEES = EmployeeData.getEmployees();
    @Test
    public void testCollect() {
        List<Employee> collect = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toList());
        collect.forEach(System.out::println);
        Set<Employee> collect2 = EMPLOYEES.stream().filter(e -> e.getId() > 1002).collect(Collectors.toSet());
        collect2.forEach(System.out::println);
    }
    @Test
    public void testMatch() {
        boolean allMatch = EMPLOYEES.stream().allMatch(e -> e.getName().length() > 2);
        System.out.println(allMatch);
        System.out.println("*************************");
        boolean anyMatch = EMPLOYEES.stream().anyMatch(e -> e.getName().length() > 3);
        System.out.println(anyMatch);
        System.out.println("***********************");
        boolean noneMatch = EMPLOYEES.stream().noneMatch(e -> e.getName().startsWith("Yun"));
        System.out.println(noneMatch);
    }
    @Test
    public void testFind() {
        Optional<Employee> employee = EMPLOYEES.stream().findFirst();
        System.out.println(employee);
        Optional<Employee> any = EMPLOYEES.parallelStream().findAny();
        System.out.println(any);
    }
    @Test
    public void testCountMaxMin() {
        long count = EMPLOYEES.stream().filter(e -> e.getAge() > 40).count();
        System.out.println("num of employees(age > 40): " + count);
        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> max = stream.max(Integer::compare);
        System.out.println("max age is: " + max);
        Optional<Employee> min = EMPLOYEES.stream().min(Comparator.comparingInt(Employee::getId));
        System.out.println("min age is : " + min);
        EMPLOYEES.stream().filter(e -> e.getAge() > 40).map(e -> e.getName() + " ： OLD PPL").forEach(System.out::println);
        List<String> collect = EMPLOYEES.stream().filter(e -> e.getAge() > 40).map(e -> e.getName() + " ： OLD PPL").collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
    @Test
    public void testIteration() {
        EMPLOYEES.stream().forEach(System.out::println);
        System.out.println("\n******************\n");
        EMPLOYEES.forEach(System.out::println);
    }
    @Test
    public void testReduce() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);
        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce1 = stream.reduce(Integer::sum);
        System.out.println(reduce1);
        Stream<Integer> stream2 = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce2 = stream2.reduce((d1, d2) -> d1 + d2);
        System.out.println(reduce2.get());
    }
    @Test
    public void testChain() {
        List<Double> collect = EMPLOYEES.stream().filter(e -> e.getAge() < 40).map(e -> e.getSalary() * 0.8).collect(Collectors.toList());
        collect.forEach(System.out::println);
        System.out.println("**************");
        Optional<Integer> reduce = EMPLOYEES.stream().filter(e -> e.getAge() < 40).map(e -> e.getSalary() * 0.8).map(e -> {System.out.println(e);return e.intValue();}).reduce(Integer::sum);
        System.out.println(reduce.get());
        Optional<Integer> reduce1 = EMPLOYEES.stream().filter(e -> e.getAge() < 40).collect(Collectors.toList()).stream().map(e -> e.getSalary() * 0.8).map(e -> {System.out.println(e);return e.intValue();}).reduce(Integer::sum);
        System.out.println(reduce1.get());
    }
    @Test
    public void testGroupBy() {
        Map<String, Optional<Employee>> collect = EMPLOYEES.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("male max salary: " + collect.get("male"));
        System.out.println("female max salary: " + collect.get("female"));
    }
    @Test
    public void testToMap() {
        Map<Integer, Double> collect = EMPLOYEES.stream().collect(Collectors.toMap(Employee::getId, Employee::getSalary));
    }
}
public class StreamApiIntermediateOperation {
    @Test
    public void testFilter() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        Stream<Integer> stream = col.stream();
        stream.filter(t -> t % 2 == 0).forEach(System.out::println);
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> nameStream = employees.stream().map(Employee::getName);
        nameStream.filter(name -> name.length() > 6).forEach(System.out::println);
    }
    @Test
    public void testLimit() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        col.stream().limit(3).forEach(System.out::println);
    }
    @Test
    public void testSkip() {
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        col.stream().skip(2).forEach(System.out::println);
    }
    @Test
    public void testDistinct() {
        int[] arr = new int[]{1, 2, 3, 4, 4, 2, 5};
        IntStream st = Arrays.stream(arr);
        st.distinct().forEach(System.out::println);
    }
    @Test
    public void testMap() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }
    @Test
    public void testFlatMap() {
        List<String> lists1 = Arrays.asList("1", "2", "33", "4", "5");
        List<String> lists2 = Arrays.asList("6", "7", "8", "9", "10");
        List<List<String>> listsOfStrings = new ArrayList<>();
        listsOfStrings.add(lists1);
        listsOfStrings.add(lists2);
        System.out.println("listsOfStrings: " + listsOfStrings);
        System.out.println("分步骤使用flatmap找到最大值");
        Stream<String> stringStream = listsOfStrings.stream().flatMap(list -> list.stream());
        Stream<Stream<String>> streamStream = listsOfStrings.stream().map(list -> list.stream());
        OptionalInt max = stringStream.mapToInt(Integer::parseInt).max();
        int asInt = max.getAsInt();
        System.out.println(asInt);
        System.out.println("使用flatmap找到最大值。不分步骤。");
        int asInt1 = listsOfStrings.stream().flatMap(list -> list.stream()).mapToInt(Integer::parseInt).max().getAsInt();
        System.out.println(asInt1);
    }
    @Test
    public void testIntermediateOperationChain() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);
        List<Integer> collect = list2.stream().filter(e -> e % 2 == 0).map(e -> e * 10).collect(Collectors.toList());
        list1.addAll(collect);
        System.out.println(list1);
    }
    @Test
    public void testSorted() {
        List<Integer> list = Arrays.asList(87, 2, 65, 34, 72, 12);
        list.stream().sorted().forEach(System.out::println);
        System.out.println("\n***********\n");
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);
        System.out.println("\n********* equals ***************\n");
        Stream<Employee> stream = employees.stream();
        Stream<Employee> sorted = stream.sorted(Comparator.comparingInt(Employee::getAge));
        sorted.forEach(System.out::println);
    }
}
public class StreamExercise {
    @Test
    public void testMapAndFlatMap() {
        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("word");
        List<String> stringList = words.stream().flatMap(word -> Arrays.stream(word.split(""))).distinct().collect(Collectors.toList());
        stringList.forEach(e -> System.out.println(e));
    }
    @Test
    public void testMapAndFlatMap2() {
        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("word");
        List<Stream<String>> collect = words.stream().map(word -> Arrays.stream(word.split(""))).distinct().collect(Collectors.toList());
        collect.forEach(e -> System.out.println(e));
        System.out.println("above are stream objects, below are character");
        for (Stream<String> stringStream : collect)
            stringStream.forEach(System.out::println);
    }
}