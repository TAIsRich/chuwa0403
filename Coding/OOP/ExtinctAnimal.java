package Coding.OOP;

public abstract class ExtinctAnimal extends Animal {
    private int extinctionTime;

    protected ExtinctAnimal(String species, int lifeRange, int extinctionTime) {
        super(species, lifeRange);
        this.extinctionTime = extinctionTime;
    }

    public void setExtinctionTime(int time) {
        extinctionTime = time;
    }

    public int setExtinctionTime() {
        return extinctionTime;
    }
}
