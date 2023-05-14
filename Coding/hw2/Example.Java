import java.util.*;

public class Example {
    public static void main(String[] args) {
        Porsche porsche = new Porsche("Porsche");
        Benz benz = new Benz("Benz");
        porsche.whoAmI();    
        benz.whoAmI();
    }
}

class Vehicle {

    private String brand;

    public Vehicle(String brand_) {
        this.brand = brand_;
    }

    public void whoAmI() {
        System.out.println("Above all.");
    }

    public String getBrand() {
        return this.brand;
    }
}

class Porsche extends Vehicle {
    public Porsche(String brand_) {
        super(brand_);
    }

    @Override
    public void whoAmI() {
        System.out.print(this.getBrand() + " ");
        this.whoAmI("911");
    }

    public int whoAmI(String name) {
        System.out.println(name);
        return 0;
    }
}

class Benz extends Vehicle {
    public Benz(String brand_) {
        super(brand_);
    }

    @Override
    public void whoAmI() {
        System.out.print(this.getBrand() + " ");
        this.whoAmI("GLE");
    }

    public int whoAmI(String name) {
        System.out.println(name);
        return 0;
    }
}