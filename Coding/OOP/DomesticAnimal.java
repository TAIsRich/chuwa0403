package Coding.OOP;

public abstract class DomesticAnimal extends Animal{
    private int domesticationTime;
    protected DomesticAnimal(String species, int lifeRange, int domesticationTime) {
        super(species, lifeRange);
        this.domesticationTime = domesticationTime;
    }

    public void setDomesticationTime(int time) {
        domesticationTime = time;
    }

    public int getDomesticationTime() {
        return domesticationTime;
    }
}
