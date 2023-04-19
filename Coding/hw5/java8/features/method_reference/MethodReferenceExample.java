package method_reference;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodReferenceExample {
    public static void main(String[] args) {
        // 1. 静态方法引用
        List<Person> people = Arrays.asList(
                new Person("Bob", 25),
                new Person("Alice", 30),
                new Person("Charlie", 35)
        );
        System.out.println(people);
        // 使用Lambda表达式
        people.sort((p1, p2) -> Person.compareByName(p1, p2));
        System.out.println(people);

        // 使用静态方法引用
        people.sort(Person::compareByName);
        System.out.println(people);

        // 2. 实例方法引用（特定对象的实例方法）
        Comparator<Person> byAgeComparator = Comparator.comparingInt(Person::getAge);
        people.sort(byAgeComparator);
        System.out.println(people);

        // 3. 类的实例方法引用
        // 不要尝试理解Function,将会被stream使用。
        Function<Person, String> getNameFunction = Person::getName;
        List<String> names = Arrays.asList("Bob", "Alice", "Charlie");
        names.sort(String::compareToIgnoreCase);
        System.out.println(names);

        // 4. 构造方法引用
        // 不要尝试理解BiFunction,将会被stream使用。
        BiFunction<String, Integer, Person> personCreator = Person::new;
        Person newPerson = personCreator.apply("David", 40);

        System.out.println(personCreator);
    }
}
