package hw5.feature.stream_api;

import hw0.help.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class CreationTest {
    @Test
    public void testCollection(){
        List<Integer> col = Arrays.asList(1,2,3,4,5);
        col.forEach(System.out::println);

        Stream<Integer> stream = col.stream();
        System.out.println("Stream: "+stream);

        Stream<Integer> parallelStream = col.parallelStream();
        System.out.println("Parallel: "+parallelStream);

    }

    @Test
    public void testArrays(){
        int[] arr = new int[]{1, 2, 3, 4, 5};
        IntStream stream = Arrays.stream(arr);
        System.out.println("Stream: "+stream);

        Employee e1 = new Employee(1001, "tom", 20, 2222);
        Employee e2 = new Employee(1002, "Jerry", 18, 5000);
        Employee[] arr1 = new Employee[]{e1, e2};

        Stream<Employee> stream1 = Arrays.stream(arr1);
        System.out.println("Stream " + stream1);
    }

    @Test
    public void testOf(){
        Stream<Integer> stream = Stream.of(1,2,3,4,5);
        System.out.println("Stream: " + stream);
    }

    @Test
    public void testIterate(){
        Stream.iterate(0, t-> t+2).limit(10).forEach(System.out::println);
    }

    @Test
    public void testGenerate(){
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        Stream<String> stream = Stream.generate(()->"element").limit(10);
        stream.forEach(System.out::println);
    }

    @Test
    public void testPrimitive(){
        IntStream intStream = IntStream.range(1,3);
        LongStream longStream = LongStream.rangeClosed(1,3);

        System.out.println("Stream: "+intStream);
        intStream.forEach(System.out::println);

        System.out.println("Stream: "+longStream);
        longStream.forEach(System.out::println);
    }


}
