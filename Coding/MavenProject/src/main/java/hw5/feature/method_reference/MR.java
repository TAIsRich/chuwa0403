package hw5.feature.method_reference;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MR {
    public static void main(String[] args) {
        // 1. static function reference
        List<Person> personList = Arrays.asList(
                new Person("a", 10),
                new Person("b", 24),
                new Person("c", 34));
        // use lambda
        personList.sort((p1, p2)-> Person.compareByName(p1, p2));
        // use method reference of static method
        personList.sort(Person::compareByName);

        // 2. instance reference
        Comparator<Person> byAge = Comparator.comparingInt(Person::getAge);
        personList.sort(byAge);

        // 3. class
        // no need
        // Function<Person, String> getNameFunction = Person::getName;
        List<String> names = Arrays.asList("a", "b","c");
        names.sort(String::compareToIgnoreCase);

        // 4. constructor
        // no need
        BiFunction<String, Integer, Person> personCreator = Person::new;
        Person newPerson = personCreator.apply("a",10);
    }
}

class Person{
    private String name;
    private int age;

    Person(String name, int age){
        this.age = age;
        this.name = name;
    }

    static int compareByName(Person p1, Person p2){
        return p1.name.compareTo(p2.name);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return name +": "+age;
    }
}
