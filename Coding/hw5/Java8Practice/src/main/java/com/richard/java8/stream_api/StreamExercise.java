package com.richard.java8.stream_api;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author zhuhaotian
 * @Date 2023/4/15
 * https://blog.devgenius.io/15-practical-exercises-help-you-master-java-stream-api-3f9c86b1cf82
 * https://github.com/gavinklfong/stream-api-exercises
 */

public class StreamExercise {

    @Test
    public void testMapAndFlatMap() {
        List<String> words = Arrays.asList("hello", "word");

        //将words数组中的元素再按照字符拆分，然后字符去重，最终达到["h", "e", "l", "o", "w", "r", "d"]
        //如果使用map，是达不到直接转化成List<String>的结果
        List<String> stringList = words.stream()
                // 这个地方把两个stream flat过后整合为一个stream
                .flatMap(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());
        stringList.forEach(System.out::println);
    }

    @Test
    public void testMapAndFlatMap2() {
        List<String> words = Arrays.asList("hello", "word");

        //将words数组中的元素再按照字符拆分，然后字符去重，最终达到["h", "e", "l", "o", "w", "r", "d"]
        //如果使用map，是达不到直接转化成List<String>的结果
        List<Stream<String>> collect = words.stream()
                // 把每一个字符串转换成一个stream
                // 每一个stream里面包含的就是这个字符串的所有字符
                // 此时是Stream<Stream<String>>
                .map(word -> Arrays.stream(word.split("")))
                .distinct()
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
        System.out.println("**** above are stream objects, below are character *****");
        for (Stream<String> stringStream : collect) stringStream.forEach(System.out::println);
    }
}
