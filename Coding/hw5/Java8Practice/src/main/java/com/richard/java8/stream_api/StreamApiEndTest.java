package com.richard.java8.stream_api;

/**
 * @Author zhuhaotian
 * @Date 2023/4/15
 */

import com.richard.java8.lambda.Employee;
import com.richard.java8.lambda.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Collections 讲的是数据，Stream讲的是计算（CPU）
 * 1. Stream 自己不会存储元素
 * 2. Stream 不会改变源对象，相反，他们会返回一个持有结果的新stream
 * 3. Stream操作是延迟执行的，这意味着他们会等到需要结果的时候才执行。
 * Stream执行流程：
 * 1. 创建Stream： 获取一个数据源
 * 2. 中间操作： 一个操作链： 对数据进行处理
 * 3. 终止操作： 一旦执行中止操作，则会开始执行中间操作链，并产生结果。之后，不会再被使用。
 */

public class StreamApiEndTest {

    /**
     * 终止操作
     * 一， 匹配与查找
     * 1， allMatch(Predicate p) - 检查是否匹配所有的元素
     * 2， anyMatch(Predicate p) - 检查是否至少匹配一个元素
     * 3， noneMatch(Predicate p) - 检查是否没有匹配的元素
     * 4, findFirst - 返回第一个元素
     * 5， findAny - 返回当前流中的任意元素
     * 6, count - 返回流中元素的个数
     * 7, max(Comparator c) - 返回流中的最大值
     * 8, min(Comparator c) - 返回流中的最小值
     * 9, forEach(Consumer c) - 内部迭代
     * <p>
     * 二，归约
     * 1, reduce(T identity, BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
     * 2, reduce(BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
     * <p>
     * 三， 收集
     * 1, collect(Collector c)
     */

    private static final List<Employee> EMPLOYEES = EmployeeData.getEmployees();

    /**
     * collect最重要
     */
    @Test
    public void testCollect() {
        List<Employee> list = EMPLOYEES.stream()
                .filter(e -> e.getId() > 1002)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("\n********************************\n");

        Set<Employee> set = EMPLOYEES.stream()
                .filter(e -> e.getId() > 1002)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);
    }

    /**
     * 1， allMatch(Predicate p) - 检查是否匹配所有的元素
     * 2， anyMatch(Predicate p) - 检查是否至少匹配一个元素
     * 3， noneMatch(Predicate p) - 检查是否没有匹配的元素
     */
    @Test
    public void testMatch() {
        // 1， allMatch(Predicate p) - 检查是否匹配所有的元素
        boolean allMatch = EMPLOYEES.stream()
                .allMatch(e -> e.getName().length() > 2);
        System.out.println("All names are longer than 2? " + allMatch);

        System.out.println("***************************");

        // 2， anyMatch(Predicate p) - 检查是否至少匹配一个元素
        boolean anyMatch = EMPLOYEES.stream()
                .anyMatch(e -> e.getName().length() > 3);
        System.out.println("Is there a name longer than 3? " + anyMatch);

        System.out.println("***************************");

        // 3， noneMatch(Predicate p) - 检查是否没有匹配的元素
        boolean noneMatch = EMPLOYEES.stream()
                .noneMatch(e -> e.getName().startsWith("Yun"));
        System.out.println("Is none of them called Yun? " + noneMatch);

    }

    /**
     * 4, findFirst - 返回第一个元素
     * 5， findAny - 返回当前流中的任意元素
     */
    @Test
    public void testFind() {
        // 4, findFirst - 返回第一个元素
        Optional<Employee> findFirst = EMPLOYEES.stream()
                .filter(e -> e.getSalary() > 300000)
                .findFirst();
        findFirst.ifPresent(System.out::println);

        System.out.println("\n********************************\n");

        // 5. findAny - 返回当前流中的任意元素
        Optional<Employee> findAny = EMPLOYEES.stream()
                .filter(e -> e.getGender().equals("Female"))
                .findAny();
        findAny.ifPresent(System.out::println);
    }

    /**
     * 6, count - 返回流中元素的个数
     * 7, max(Comparator c) - 返回流中的最大值
     * 8, min(Comparator c) - 返回流中的最小值
     */
    @Test
    public void testCountMaxMin() {
        // 6, count - 返回流中元素的个数
        long count = EMPLOYEES.stream()
                .filter(e -> e.getAge() > 40)
                .count();
        System.out.println("The number of employees aged above 40 is: " + count);

        System.out.println("\n********************************\n");

        // 7, max(Comparator c) - 返回流中的最大值
        Optional<Integer> oldestAge = EMPLOYEES.stream()
                .map(Employee::getAge)
                .max(Integer::compare);
        oldestAge.ifPresent(System.out::println);

        System.out.println("\n********************************\n");

        // 8. min(Comparator c) - 返回流中的最小值
        Optional<Integer> youngestAge = EMPLOYEES.stream()
                .map(Employee::getAge)
                .min(Integer::compareTo);
        youngestAge.ifPresent(System.out::println);

        System.out.println("\n********************************\n");

        System.out.println("Employees who are older than 40:");
        EMPLOYEES.stream()
                .filter(e -> e.getAge() > 40)
                .map(e -> e.getName() + " : OLD PPL")
                .forEach(System.out::println);

        System.out.println("\n********************************\n");

        System.out.println("Using a list to store these employees:");
        List<String> collect = EMPLOYEES.stream()
                .filter(e -> e.getAge() > 40)
                .map(e -> e.getName() + " : OLD PPL")
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    /**
     * 9, forEach(Consumer c) - 内部迭代
     * 使用集合的迭代
     */
    @Test
    public void testIteration() {
        // 9, forEach(Consumer c) - 内部迭代
        EMPLOYEES.stream()
                .forEach(System.out::println);

        System.out.println("\n********************************\n");

        // 使用集合的迭代
        EMPLOYEES.forEach(System.out::println);
    }

    @Test
    public void testReduce() {
        // 1, reduce(T identity, BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // collect.(Collectors.summingInt()) 貌似也可以
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        // 2, reduce(BinaryOperator) - 可以将流中的元素反复结合起来，得到一个值
        // Using method reference
        Optional<Integer> optional = EMPLOYEES.stream()
                .map(Employee::getAge)
                .reduce(Integer::sum);
        optional.ifPresent(System.out::println);

        // Using lambda
        Optional<Integer> optional1 = EMPLOYEES.stream()
                .map(Employee::getAge)
                .reduce((d1, d2) -> d1 + d2);
        optional1.ifPresent(System.out::println);
    }

    /**
     * map是必须要有return的
     */
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
        reduce.ifPresent(System.out::println);

        System.out.println("********************");

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
        reduce1.ifPresent(System.out::println);
    }

    /**
     * 获得员工中，男性员工中最高工资的人，以及女性员工中最高工资的人
     */
    @Test
    public void testGroupBy() {
        Map<String, Optional<Employee>> maxSalary = EMPLOYEES.stream()
                .collect(Collectors
                        .groupingBy(
                                Employee::getGender,
                                Collectors.maxBy(Comparator.comparing(Employee::getSalary))
                        ));
        maxSalary.entrySet().forEach(e -> {
                    System.out.println(e.getKey() + " max salary: " + e.getValue());
                });
    }

    /**
     * 构建一个map, key是员工ID，value是员工的工资。
     */
    @Test
    public void testToMap() {
        Map<Integer, Double> idSalary = EMPLOYEES.stream()
                .collect(Collectors.toMap(
                        Employee::getId,
                        Employee::getSalary
                ));
        idSalary.entrySet().forEach(System.out::println);
    }

}
