package Coding.OOP;

public class Cat extends DomesticAnimal{

    public Cat(String species, int lifeRange, int domesticationTime) {
        super(species, lifeRange, domesticationTime);
    }

    @Override
    public String makeSound() {
        return "meow";
    }
}