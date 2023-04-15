package builder;

public class Client {
    public static void main(String[] args){
        Director dir = new Director(new MobileBuilder());

        Bike bike = dir.construct();

        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());

    }
}
