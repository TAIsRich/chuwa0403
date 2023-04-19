package com.richard.java8.stream_api;

/**
 * @Author zhuhaotian
 * @Date 2023/4/15
 */

import com.richard.java8.lambda.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
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
 * @author bigo
 */

public class StreamApiCreationTest {

    /**
     * 创建Stream的方式
     * 1. 通过集合
     * 2. 通过数组Arrays
     * 3. 通过Stream的Of()
     * 4. 创建无限流
     * 5. 通过Builder
     * 6. Stream of Primitives
     */

    /**
     * list.stream();
     */
    @Test
    public void testCollection() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list.forEach(System.out::println);

        // 返回一个顺序流
        Stream<Integer> stream = list.stream();
        System.out.println("Stream Object: " + stream);

        // 返回一个并行流
        Stream<Integer> parallelStream = list.parallelStream();
        System.out.println("Parallel Stream Object: " + parallelStream);
    }

    /**
     * Arrays.stream(arr);
     */
    @Test
    public void testArrays() {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6};
        IntStream stream = Arrays.stream(arr);
        stream.forEach(System.out::println);
        System.out.println("Stream Object: " + stream);

        System.out.println("---------------------------");

        Employee e1 = new Employee(1001, "tom", 20, 2222);
        Employee e2 = new Employee(1002, "Jerry", 18, 5000);
        Stream<Employee> stream1 = Arrays.stream(new Employee[] {e1, e2});
        stream1.forEach(System.out::println);
        System.out.println("Stream Object: " + stream1);
    }

    @Test
    public void testOf() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.forEach(System.out::println);
        System.out.println("Stream object: " + stream);
    }

    /**
     *  ######################  上面部分是重点，下面部分是非重点  ##################
     */
    // ----------------------  华丽分割线  ------------------------------------

    @Test
    public void testIterate() {
        /**
         * 遍历前10个偶数
         * seed : 0, means t's initial value is 0
         * then t is updated every time
         * limit(10) means that it only produce 10 elements then stop.
         */

        Stream.iterate(0, t -> t + 2).limit(10).forEach(System.out::println);
    }

    @Test
    public void testGenerate() {
        /**
         * call Math.random() 10 times
         * limit(10)
         */

        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }

    @Test
    public void testStreamOfPrimitives() {
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.range(1, 3);

        System.out.println("IntStream Object: " + intStream);
        intStream.forEach(System.out::println);

        System.out.println("LongStream Object: " + longStream);
        longStream.forEach(System.out::println);
    }

}
