package com.chuwa.learn.method_reference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceExample {

    public static void main(String[] args) {

        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));

        // use lambda expression
        people.sort((p1,p2)->Person.compareByName(p1,p2));

        // static method reference
        people.sort(Person::compareByName);

        // instance method reference
        Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge);
        people.sort(byAgeComparator);

        // class instance method reference
        Function<Person, String> getNameFunction = Person::getName;
        List<String> names = Arrays.asList("Alice","Bob","Charlie");
        names.sort(String::compareToIgnoreCase);

        BiFunction<String, Integer, Person> personCreator = Person::new;
        Person newPerson = personCreator.apply("David",40);

        System.out.println(people);
    }
}

class Person{

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static int compareByName(Person p1, Person p2){
        return p1.name.compareTo(p2.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

}