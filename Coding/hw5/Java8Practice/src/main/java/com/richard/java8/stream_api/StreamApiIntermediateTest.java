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
import java.util.stream.IntStream;
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

public class StreamApiIntermediateTest {

    /**
     * 创建Stream的中间操作
     * <p>
     * 一，筛选
     * 1. filter(Predicate p) - 接受lambda, 从流中排出某些元素
     * 2. limit(n) - 截断流，使其元素不超过给定的数量
     * 3. skip(n) - 跳过前n个元素
     * 4. distinct() - 筛选，通过元素的hashcode(), equals()去除重复元素
     * <p>
     * 二，映射
     * 1, map(function f) element -> black box(f) -> new element
     * 2, flatMap(function f)
     * 三， 排序
     * 1, sorted
     */

    static List<Integer> COL = Arrays.asList(1, 2, 3, 4, 5);

    @Test
    public void testFilter() {
        System.out.println("Even numbers in 1~5:");
        COL.stream()
                .filter(t -> t % 2 == 0)
                .forEach(System.out::println);

        System.out.println("********************");

        // 获取员工姓名长度大于3的员工姓名
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> longerThanThree = employees.stream()
                .filter(e -> e.getName().length() > 3)
                .collect(Collectors.toList());
        longerThanThree.forEach(System.out::println);
    }

    @Test
    public void testLimit() {
        COL.stream()
                .limit(3)
                .forEach(System.out::println);
    }

    @Test
    public void testSkip() {
        COL.stream()
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void testDistinct() {
        IntStream st = Arrays.stream(new int[] {1, 2, 3, 4, 4, 2 ,5});
        st.distinct()
                .forEach(System.out::println);
    }

    /**
     * 映射
     * map(Function f)： 使用函数 f 对数据进行处理
     */
    @Test
    public void testMap() {
        // map(Function f) - 接收一个函数作为参数，将元素转换成其它形式或提取信息，该函数会被
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    /**
     * 把两个string里面的数字相加并求和。 1 + 2+ 3 + ... + 9 + 10
     */
    @Test
    public void testFlatMap() {
        // 1. 构造一对二维数组
        List<String> lists1 = Arrays.asList("1", "2", "33", "4", "5");
        List<String> lists2 = Arrays.asList("6", "7", "8", "9", "10");
        List<List<String>> listsOfStrings = new ArrayList<>();
        listsOfStrings.add(lists1);
        listsOfStrings.add(lists2);

        // 2. 分步骤使用flatmap找到最大值
        System.out.println("**** 分步骤使用flatmap找到最大值 *****");
        // 2.1 string flatten为一个string stream对象。 注意flatMap里，input是list, 输出是list转换的stream对象。
        Stream<String> stringStream = listsOfStrings.stream()
                .flatMap(list -> list.stream());
        // 2.1.1 如果是使用普通map，则生成的是Stream<Stream>对象
        Stream<Stream<String>> streamStrean = listsOfStrings.stream()
                .map(list -> list.stream());
        // 2.2 将string 转为int数组，然后找出max值，此时max()方法返回的是Optional<Integer>
        // mapToInt() 返回的是 IntStream
        // max() 是 IntStream 的一个方法
        OptionalInt max = stringStream.mapToInt(Integer::parseInt)
                .max();
        // 2.3 从Optional里拿出int数值。
//        ifPresent() 写法
//        int asInt = -1;
//        if (max.isPresent()) asInt = max.getAsInt();
        int asInt = max.orElse(-1);
        System.out.println(asInt);

        // 2.使用flatmap找到最大值。不分步骤。 日常工作这么写。
        System.out.println("**** 使用flatmap找到最大值。不分步骤。 *****");
        int asInt1 = listsOfStrings.stream()
                .flatMap(list -> list.stream())
                .mapToInt(Integer::parseInt)
                .max()
                .orElse(-1);
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

        // 找出list2中的偶数，并乘以10
        List<Integer> collect = list2.stream()
                .filter(e -> e % 2 == 0)
                .map(e -> e * 10)
                .collect(Collectors.toList());
        list1.addAll(collect);
        System.out.println(list1);
    }

    /**
     * 排序
     * https://www.youtube.com/watch?v=DlHnbbS3bBY&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=679
     */
    @Test
    public void testSorted() {
        List<Integer> list = Arrays.asList(87, 2, 65, 34, 72, 12);
        list.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n***********\n");

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .forEach(System.out::println);

        System.out.println("\n********* equals ***************\n");
        Stream<Employee> stream = employees.stream();
        Stream<Employee> sorted = stream.sorted(Comparator.comparingInt(Employee::getAge));
        sorted.forEach(System.out::println);
    }
}
