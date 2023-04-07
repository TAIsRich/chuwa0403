public class Example {
    public static void main(String[] args) {
        Animal animal = new Animal("Generic Animal", 5, "generic sound");
        animal.makeSound();
        animal.eat();

        Dog dog = new Dog("Fido", 3);
        dog.makeSound();
        dog.eat();
        dog.bark();

        Cat cat = new Cat("Fluffy", 2);
        cat.makeSound();
        cat.eat();
        cat.purr();
    }

    public static class Animal {
        private String name;
        private int age;
        private String sound;

        public Animal(String name, int age, String sound) {
            this.name = name;
            this.age = age;
            this.sound = sound;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getSound() {
            return sound;
        }

        public void makeSound() {
            System.out.println(name + " says " + sound);
        }

        public void eat() {
            System.out.println(name + " is eating.");
        }
    }

    public static class Dog extends Animal {
        public Dog(String name, int age) {
            super(name, age, "woof");
        }

        public void bark() {
            System.out.println(super.getName() + " is barking.");
        }
    }

    public static class Cat extends Animal {
        public Cat(String name, int age) {
            super(name, age, "meow");
        }

        public void purr() {
            System.out.println(super.getName() + " is purring.");
        }
    }

}


