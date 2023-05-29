package hw5.feature.stream_api;

import hw0.help.Employee;
import hw0.help.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IntermediateOperationTest {
    /*
    筛选
    filter
    limit
    skip
    distinct

    映射
    map
    flatMap

    排序
    sorted
     */

    @Test
    public void testFiler(){
        List<Integer> col = Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = col.stream();
        stream.filter(t -> t %2 == 0).forEach(System.out::println);

        List<Employee> e = EmployeeData.getEmployees();
        Stream<String> nameStream = e.stream().map(Employee::getName);
        nameStream.filter(name->name.length()>7).forEach(System.out::println);

    }

    @Test
    public void testLimit(){
        List<Integer> col = Arrays.asList(1, 2,3 ,4, 5);
        col.stream().limit(3).forEach(System.out::println);
    }

    @Test
    public void testSkip(){
        List<Integer> col = Arrays.asList(1, 2, 3, 4, 5);
        col.stream().skip(2).forEach(System.out::println);
    }

    @Test
    public void testDistinct(){
        List<Integer> col = Arrays.asList(1, 2, 3,3, 4, 5);
        col.stream().distinct().forEach(System.out::println);
    }

    @Test
    public void testMap(){
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    @Test
    public void testFlatMap(){
        List<String> lists1 = Arrays.asList("1", "2", "33", "4", "5");
        List<String> lists2 = Arrays.asList("6", "7", "8", "9", "10");
        List<List<String>> listsOfStrings = new ArrayList<>();
        listsOfStrings.add(lists1);
        listsOfStrings.add(lists2);
        System.out.println(listsOfStrings);

        // find maximum by flatmap
        Stream<String> stream = listsOfStrings.stream().flatMap(l->l.stream());

        Stream<Stream<String>> streamByMap = listsOfStrings.stream().map(l->l.stream());
        OptionalInt max = stream.mapToInt(Integer::parseInt).max();

        int max_i = max.getAsInt();
        System.out.println(max_i);

        // better one:
        int ans = listsOfStrings.stream()
                .flatMap(l->l.stream())
                .mapToInt(Integer::parseInt)
                .max().getAsInt();
    }

    @Test
    public void testChain(){
        ArrayList<Integer> list1= new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

        List<Integer> collect = list2.stream()
                .filter(e -> e%2 == 0)
                .map(e -> e*10)
                .collect(Collectors.toList());
        list1.addAll(collect);
        System.out.println(list1);

    }

    @Test
    public void testSorted(){
        List<Integer> list = Arrays.asList(87, 2, 65, 34, 72, 12);
        list.stream().sorted().forEach(System.out::println);

        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted(Comparator.comparingInt(Employee::getAge)).forEach(System.out::println);

        Stream<Employee> stream = employees.stream();
        Stream<Employee> sorted = stream.sorted(Comparator.comparingInt(Employee::getAge));
        sorted.forEach(System.out::println);
    }
}
