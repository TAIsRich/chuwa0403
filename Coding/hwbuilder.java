import jdk.jshell.JShell;

public class hwbuilder {
}
public abstract class builder{
    protected  Bike bike = new Bike();
    public abstract void buildFrame();
    public abstract void buildSeat():
    public abstract Bike createBike();
}
public class MobileBuilder extends Builder {
    public void buildFrame(){
        bike.setFrame("carbon");
    }
    public void buildSeat(){
        bike.setSeat("leather");
    }
    public Bike createBike(){
        return bike;
    }
}
public class ofoBuilder extends Builder {
    public void buildFrame(){
        bike.setFrame("steel");
    }
    public void buildSeat(){
        bike.setSeat("cloth");
    }
    public Bike createBike(){
        return bike;
    }
}
public class Director{
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }
    public Bike construct(){
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}
public class Client{
    public static void main(String[] args){
        Director director = new Director(new MobileBuilder());
        Bike bike = director.construct();
        System.out.print(bike.getFrame());
    }
}