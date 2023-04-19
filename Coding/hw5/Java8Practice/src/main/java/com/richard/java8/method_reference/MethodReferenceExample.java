package com.richard.java8.method_reference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @Author zhuhaotian
 * @Date 2023/4/15
 */

public class MethodReferenceExample {

    public static void main(String[] args) {

        //1. 静态方法调用
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );

        // 使用lambda表达式来实现Comparator
        people.sort((p1, p2) -> Person.compareByName(p1, p2));

        // 使用静态方法引用
        people.sort(Person::compareByName);

        // 2. 实例方法引用
        Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge);
        people.sort(byAgeComparator);

        //3. 类的实例方法引用
        Function<Person, String> getNameFunction = Person::getName;
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.sort(String::compareToIgnoreCase);
        System.out.println(names);

        // 4. 构造方法引用
        BiFunction<String, Integer, Person> personCreator = Person::new;
        Person newPerson = personCreator.apply("David", 40);
        System.out.println(newPerson);

        System.out.println(people);
    }

}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int compareByName(Person p1, Person p2) {
        return p1.name.compareTo(p2.name);
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }
}

