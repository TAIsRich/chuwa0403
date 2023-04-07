public class InheritanceExample{
    public static void main(String[] args) {
        C car = new C("Mini Cooper", "Coupe");
        car.honk();
        car.drive();
    }
}

class V {
    protected String brand;

    public V(String brand) {
        this.brand = brand;
    }

    public void honk() {
        System.out.println("Honk honk!");
    }
}

class C extends V {
    private String model;

    public C(String brand, String model) {
        super(brand);
        this.model = model;
    }
    public void drive() {
        System.out.println("Driving the " + brand + " " + model);
    }
}


