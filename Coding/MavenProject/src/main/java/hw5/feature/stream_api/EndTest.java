package hw5.feature.stream_api;

import hw0.help.Employee;
import hw0.help.EmployeeData;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EndTest {
    /*
    Ending:
    匹配和查找：
    allMatch()
    anyMatch()
    noneMatch()

    findFirst
    findAny

    count
    max
    min
    forEach

    归约
    reduce(T identity, BinaryOperator)
    reduce(binaryOperator)

    收集
    collect(Collector c)
     */
    private static final List<Employee> EMPLOYEES = EmployeeData.getEmployees();

    @Test
    public void testCollect(){
        List<Employee> collect = EMPLOYEES.stream().filter(employee -> employee.getId()>10)
                .collect(Collectors.toList());
        Set<Employee> collect2 = EMPLOYEES.stream().filter(employee -> employee.getId()>10)
                .collect(Collectors.toSet());
        collect.forEach(System.out::println);
        collect2.forEach(System.out::println);
    }

    @Test
    public void testMatch(){
        boolean allMatch = EMPLOYEES.stream().allMatch(e -> e.getName().length() > 2);
        System.out.println(allMatch);

        boolean anyMatch = EMPLOYEES.stream().anyMatch(e->e.getName().length()>3);
        System.out.println(anyMatch);

        boolean nonMatch = EMPLOYEES.stream().noneMatch(e->e.getName().startsWith("Yun"));
        System.out.println(nonMatch);
    }

    @Test
    public void testFind(){
        Optional<Employee> employee = EMPLOYEES.stream().findFirst();
        System.out.println(employee);

        Optional<Employee> any = EMPLOYEES.stream().findAny();
        System.out.println(employee);
    }

    @Test
    public void testCountMaxMin(){
        long count = EMPLOYEES.stream().filter(e -> e.getAge()>40).count();
        System.out.println("num: "+count);

        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> max = stream.max(Integer::compare);
        System.out.println("Max "+max);

        Optional<Employee> min = EMPLOYEES.stream()
                .min(Comparator.comparingInt(Employee::getId));
        System.out.println("Min "+min);

        EMPLOYEES.stream()
                .filter(employee -> employee.getAge()>40)
                .map(employee -> employee.getName()+": OLD")
                .forEach(System.out::println);

        List<String> collect = EMPLOYEES.stream()
                .filter(employee -> employee.getAge()>40)
                .map(employee -> employee.getName()+" OLD")
                .collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    @Test
    public void testIteration(){
        EMPLOYEES.stream().forEach(System.out::println);
        EMPLOYEES.forEach(System.out::println);
    }

    @Test
    public void testReduce(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println(reduce);

        Stream<Integer> stream = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce1 = stream.reduce(Integer::sum);
        System.out.println(reduce1);

        Stream<Integer> stream1 = EMPLOYEES.stream().map(Employee::getAge);
        Optional<Integer> reduce2 = stream1.reduce((d1, d2)-> d1+d2);
        System.out.println(reduce2.get());
    }

    @Test
    public void testChain(){
        List<Double> c = EMPLOYEES.stream()
                .filter(employee -> employee.getAge()<40)
                .map(employee -> employee.getSalary()*0.8)
                .collect(Collectors.toList());
        c.forEach(System.out::println);

        Optional<Integer> reduce = EMPLOYEES.stream()
                .filter(employee -> employee.getAge()<40)
                .map(employee -> employee.getSalary()*0.8)
                .map(employee -> {
                    System.out.println(employee);
                    return employee.intValue();
                })
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }

    @Test
    public void testGroupBy(){
        Map<String, Optional<Employee>> collect = EMPLOYEES.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
        System.out.println("Male "+collect.get("male"));
        System.out.println("Female "+collect.get("female"));
    }

    @Test
    public void testToMap(){
        Map<Integer, Double> collect = EMPLOYEES.stream()
                .collect(Collectors.toMap(Employee::getId, Employee::getSalary));
    }

}
