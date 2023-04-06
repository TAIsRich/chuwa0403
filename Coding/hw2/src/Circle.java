public class Circle extends TwoDShape<Circle> {
    private double radius;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle (double radius, String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getDiameter() {
        return 2*radius;
    }


    public void printCircle() {
        System.out.println("The circle is created  " + getDateCreated() +
                " and the radius is " + radius);
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimiter() {
        return 2*radius * Math.PI;
    }

    @Override
    public String toString() {
        return " Circle{" +
                "radius=" + radius +
                super.toString() +
                '}';
    }

    @Override
    public int compareTo(Circle o) {
        return Double.compare(this.getArea(), o.getArea());
    }

    @Override
    public boolean equalArea(Circle object1, Circle object2) {
        return object1.getArea() == object2.getArea();
    }

    public Object clone() {
        return new Circle(this.radius, new String(this.getColor()), this.isFilled());
    }
}

