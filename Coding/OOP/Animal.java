package Coding.OOP;

public abstract class Animal {
    protected String species;
    protected int lifeRange;

    protected Animal(String name, int age) {
        this.species = name;
        this.lifeRange = age;
    }

    public void setName(String name) {
        this.species = name;
    }

    public void setAge(int age) {
        this.lifeRange = age;
    }

    public String getName() {
        return species;
    }

    public int getAge() {
        return lifeRange;
    }

    public abstract String makeSound();

}
