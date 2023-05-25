package Q1.Polymorphism;

public abstract class Animal {
    public void makeSound() {
        System.out.println("The animal makes a sound.");
    }

    public void makeSound(String sound){
        System.out.println("The animal makes a sound: " + sound);
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The dog barks.");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The cat meows.");
    }
}