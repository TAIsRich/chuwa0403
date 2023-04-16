package coding1;

public class PolymorphismExample {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        animal1.sound();

        Animal animal2 = new Human();
        animal2.sound();
    }
}


abstract class Animal {
    public abstract void sound();

}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Wow");
    }
}

class Human extends Animal {

    @Override
    public void sound() {
        sound("tom");
    }

    public void sound(String word) {
        System.out.println("my name is " + word);
    }
}