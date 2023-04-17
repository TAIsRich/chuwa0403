package feature.method_reference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReference {
    public static void main(String [] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35));

        people.sort((p1, p2) -> Person.compareByName(p1, p2));

        people.sort(Person::compareByName);

        people.sort(Comparator.comparingInt(Person::getAge));

        Function<Person, String> getNameFunction = Person::getName;
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.sort(String::compareToIgnoreCase);

        BiFunction<String, Integer, Person> bi = Person::new;
        Person p = bi.apply("David", 50);

        System.out.println(people);
    }
}
