package hw5.feature.stream_api;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercise {
    @Test
    public void testMapAndFlatMap(){
        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("word");

        List<String> l = words.stream()
                .flatMap(s -> Arrays.stream(s.split("")))
                .distinct()
                .collect(Collectors.toList());
        l.forEach(System.out::println);

    }

    @Test
    public void test2(){
        List<String> words = new ArrayList<String>();
        words.add("hello");
        words.add("word");

        List<Stream<String>> collect = words.stream()
                .map(s -> Arrays.stream(s.split("")))
                .distinct()
                .collect(Collectors.toList());
        collect.forEach(System.out::println);

        // use map can not achieve
        for (Stream<String> s:collect)
            s.forEach(System.out::println);
    }
}
