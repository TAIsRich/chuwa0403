package coding1;

public class EncapsulationExample {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Tom");
        person.setAge(10);
        person.setWeight(120);
        person.setHeight(180);
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getWeight());
        System.out.println(person.getHeight());
    }
}

class Person {
    private String name;
    private int age;
    private int weight;
    private int height;

    public Person() {
    }

    public Person(String name, int age, int weight, int height) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}