package Q1.Inheritance;

public class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + " is eating.");
    }
}
class Mammal extends Animal {
    public Mammal(String name) {
        super(name);
    }

    public void walk() {
        System.out.println(name + " is walking.");
    }
}

class Dog extends Mammal {
    public Dog(String name) {
        super(name);
    }

    public void bark() {
        System.out.println(name + " is barking.");
    }
}

class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Super.Super Animal");
        Mammal mammal = new Mammal("Super Mammal");
        Dog dog = new Dog("Dog1");

        animal.eat();
        mammal.eat();
        mammal.walk();
        dog.eat();
        dog.walk();
        dog.bark();
    }
}