package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // Polymorphism: Treating objects of different classes as if they're of the same type
        Animal animal1 = new Animal("Generic Animal");
        Animal animal2 = new Cat("Whiskers");

        animal1.speak();  // Output: The animal speaks.
        animal2.speak();  // Output: Meow!

        System.out.println(animal1.getName());  // Output: Generic Animal
        System.out.println(animal2.getName());  // Output: Whiskers
    }

    // Encapsulation: Using a class to encapsulate related data and behavior
    static class Animal {
        private String name;

        public Animal(String name) {
            this.name = name;
        }

        public void speak() {
            System.out.println("The animal speaks.");
        }

        public String getName() {
            return name;
        }
    }

    // Inheritance: Creating a subclass that inherits from a superclass
    static class Cat extends Animal {
        public Cat(String name) {
            super(name);
        }

        @Override
        public void speak() {
            System.out.println("Meow!");
        }
    }




}