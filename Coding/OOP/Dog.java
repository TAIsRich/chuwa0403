package Coding.OOP;

public class Dog extends DomesticAnimal{

    public Dog(String species, int lifeRange, int domesticationTime) {
        super(species, lifeRange, domesticationTime);
    }

    @Override
    public String makeSound() {
        return "bak";
    }
}
