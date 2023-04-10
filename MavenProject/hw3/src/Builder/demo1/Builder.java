package Builder;

public abstract class Builder {
    protected Bike bike = new Bike();
    public abstract  void builderFrame();
    public abstract void builderSeat();
    public abstract Bike createBike();
}
