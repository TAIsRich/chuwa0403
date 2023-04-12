public class Builder {
    /*
     * Defines an instance for creating an object but letting subclasses decide which class to instantiate
     * Refers to the newly created object through a common interface
     * 
     * Pattern:
     * The Builder (abstract) class specifies an abstract interface for creating parts of a Product object.
     * The ConcreteBuilder constructs and puts together parts of the product by implementing the Builder interface. It defines and keeps track of the representation it creates and provides an interface for saving the product.
     * The Director class constructs the complex object using the Builder interface.
     * The Product represents the complex object that is being built.
     */
    public static void main(String[] args) {
        Director director = new Director(new MBuilder());
        Bike bike = director.construct();

        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
    
}




// product
class Bike {

    private String frame;//车架

    private String seat;//车座

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }
}

// builder
abstract class BikeBuilder {

    protected Bike bike = new Bike();

    public abstract void buildFrame();

    public abstract void buildSeat();

    //构建自行车的方法
    public abstract Bike createBike();
}

// concrete builder
class MBuilder extends BikeBuilder {

    @Override
    public void buildFrame() {
        bike.setFrame("c");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("z");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}

class OBuilder extends BikeBuilder {
    @Override
    public void buildFrame() {
        bike.setFrame("l");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("x");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}

// director
class Director {

    private BikeBuilder builder;

    public Director(BikeBuilder builder) {
        this.builder = builder;
    }
    // construct a product by using the build function in Builder
    public Bike construct() {
        builder.buildFrame();
        builder.buildSeat();
        return builder.createBike();
    }
}