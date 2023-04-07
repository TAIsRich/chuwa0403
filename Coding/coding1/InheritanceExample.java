package coding1;

public class InheritanceExample {
    public void main(String[] args) {
        Car car = new Car("Alice", 100, 20, 10);
        Bus bus = new Bus("Alex", 50, 5, 4);

        car.leakageTotal(20);
        bus.evaporationTotal(50);
    }

    abstract class Vehicle {
        protected String ownerName;
        protected int oilQuantity;
        protected int age;

        public Vehicle(String ownerName, int oilQuantity, int age) {
            this.ownerName = ownerName;
            this.oilQuantity = oilQuantity;
            this.age = age;
        }

        public void remainOil(int usage) {
            oilQuantity = oilQuantity - usage;
        }

        public void currentOil(int increase) {
            oilQuantity = oilQuantity + increase;
        }
    }

    class Car extends Vehicle{
        private int oilLeakage;

        public Car(String ownerName, int oilQuantity, int age, int oilLeakage) {
            super(ownerName, oilQuantity, age);
            this.oilLeakage = oilLeakage;
        }

        public void leakageTotal(int leakage){
            oilLeakage = oilLeakage + leakage;
        }
    }

    class Bus extends Vehicle{
        private int oilEvaporation;

        public Bus(String ownerName, int oilQuantity, int age, int oilEvaporation) {
            super(ownerName, oilQuantity, age);
            this.oilEvaporation = oilEvaporation;
        }

        public void evaporationTotal(int evaporation){
            oilEvaporation = oilEvaporation + evaporation;
        }
    }
}
