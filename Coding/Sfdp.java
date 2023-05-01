interface Wheel {
    public float getDiameter();
    public float getWidth();
}
class CarWheel implements Wheel {
    protected float diameter;
    protected float width;
    public CarWheel(float diameter, float width) {
        this.diameter = diameter;
        this.width = width;
    }
    public float getDiameter() {
        return diameter;
    }
    public float getWidth() {
        return width;
    }
}
class WheelFactory {
    public static Wheel makeWheel (float diameter, float width) {
        return new CarWheel(diameter, width);
    }
}
class TestWheelFactory {
    public static void main(String args[]) {
        Wheel carWheel = WheelFactory.makeWheel(15, 215);
        System.out.println(carWheel.getDiameter());
        System.out.println(carWheel.getWidth());
    }
}