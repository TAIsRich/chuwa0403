package com.chuwa.t06_java8.stream_api;

import com.chuwa.t06_java8.Employee;
import com.chuwa.t06_java8.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamApiEndOperation {
    private static final List<Employee> EMPLOYEES = EmployeeData.getEmployees();

    private static final List<Employee> EMPLOYEES_EMPTY = new ArrayList<>();

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
        boolean anyMatch = EMPLOYEES.stream().anyMatch(e -> e.getName().length() > 3);
        System.out.println(anyMatch);
        boolean noneMatch = EMPLOYEES.stream().noneMatch(e -> e.getName().startsWith("Yun"));
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
        long count = EMPLOYEES.stream()
                .filter(e -> e.getAge() > 40)
                .count();
        System.out.println("num of employees(age > 40): " + count);

        Optional<Integer> max = EMPLOYEES.stream()
                .map(Employee::getAge)
                .max(Integer::compare);
        System.out.println("max age is: " + max);

        Optional<Employee> max2 = EMPLOYEES.stream()
                .max(Comparator.comparingInt(Employee::getAge));
        System.out.println("max age is: " + max2);

        Optional<Integer> max3 = EMPLOYEES.stream()
                .max(Comparator.comparingInt(Employee::getAge))
                .map(Employee::getAge);
        System.out.println("max age is: " + max3);
    }

    @Test
    public void testIteration() {
        EMPLOYEES.stream().forEach(System.out::println);
        EMPLOYEES.forEach(System.out::println);
    }

    @Test
    public void testReduce() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        Integer reduce = list.stream().reduce(100, Integer::sum);

        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce1 = stream.reduce(Integer::sum);
        System.out.println(reduce1);

        Stream<Integer> stream2 = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce2 = stream2.reduce((d1, d2) -> d1 + d2);
        System.out.println(reduce2.get());

    }

    @Test
    public void testChain() {
        List<Double> collect = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .map(e -> e.getSalary() * 0.8)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("********************");

        Optional<Integer> reduce = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .map(e -> e.getSalary() * 0.8)
                .map(e -> {
                    System.out.println(e);
                    return e.intValue();
                })
                .reduce(Integer::sum);
        System.out.println(reduce.get());

        System.out.println("********************");
        // 在终止操作后，可以继续跟一个新的.stream()来构建chain.
        Optional<Integer> reduce1 = EMPLOYEES.stream()
                .filter(e -> e.getAge() < 40)
                .collect(Collectors.toList())
                .stream()
                .map(e -> e.getSalary() * 0.8)
                .map(e -> {
                    System.out.println(e);
                    return e.intValue();
                })
                .reduce(Integer::sum);
        System.out.println(reduce1.get());
    }

    @Test
    public void testGroupBy() {
        Map<String, Optional<Employee>> collect = EMPLOYEES
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

        System.out.println(collect);

        Map<String, Double> collect2 = EMPLOYEES
                .stream()
                .collect(Collectors.groupingBy(Employee::getGender,
                        Collectors.collectingAndThen(Collectors.maxBy(
                                Comparator.comparingDouble(Employee::getSalary)), e -> e.map(Employee::getSalary).orElse(0.0))));

        System.out.println(collect2);


        Map<String, Double> collect3 = EMPLOYEES
                .stream()
                .collect(Collectors.toMap(
                        Employee::getGender,
                        Employee::getSalary,
                        Double::max
                ));

        System.out.println(collect3);
    }

    @Test
    public void testToMap() {
        Map<Integer, Double> collect = EMPLOYEES.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Employee::getSalary
                ));
        System.out.println(collect);

        Map<String, List<Double>> collect2 = EMPLOYEES.stream()
                .filter(employee -> employee.getSalary() > 50000)
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.mapping(Employee::getSalary, Collectors.toList())
                ));

        Map<String, List<Employee>> collect3 = EMPLOYEES.stream()
                .filter(employee -> employee.getSalary() > 50000)
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.mapping(Function.identity(), Collectors.toList())
                ));


        System.out.println(collect2);
        System.out.println(collect3);

    }
}
