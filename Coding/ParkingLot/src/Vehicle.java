public class Vehicle {

    // The length, width, height, and weight of a car.
    private int length = 50, width = 50, height = 50, weight = 50, id;

    public Vehicle() {}

    public Vehicle(int id) {this.id = id;}

    public Vehicle(int id, int length, int width, int height, int weight) {
        this.length = length; this.width = width; this.height = height; this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Check whether this vehicle can park in parking spot x
    public boolean isFit(ParkingSpot x) {
        return this.length <= x.getMaxLength() && this.width <= x.getMaxWidth() && this.height <= x.getMaxHeight() && this.weight <= x.getMaxWeight();
    }
}
