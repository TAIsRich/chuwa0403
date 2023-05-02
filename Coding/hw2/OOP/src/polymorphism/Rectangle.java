package polymorphism;

class Rectangle extends Shape {   // extended form the Shape class

    private double width;
    private double height;

    public Rectangle(double width, double heigh) {
        this.width = width;
        this.height = heigh;
    }

    @Override
    public double getArea() {
        return width * height;
    }

}
