package Builder;

public class Director {
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }
    public Bike construct(){
        builder.builderFrame();
        builder.builderSeat();
        return builder.createBike();
    }
}
