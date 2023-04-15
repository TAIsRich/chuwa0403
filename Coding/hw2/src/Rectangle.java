public class Rectangle extends TwoDShape<Rectangle>{

    private double width;
    private double height;

    public Rectangle() {

    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        this.width = width;
        this.height = height;
        setColor(color);
        setFilled(filled);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return " Rectangle{" +
                "width=" + width +
                ", height=" + height +
                super.toString() +
                '}';
    }

    @Override
    public double getArea() {
        return width*height;
    }

    @Override
    public double getPerimiter() {
        return 2*(width+height);
    }

    @Override
    public int compareTo(Rectangle o) {
        return Double.compare(this.getArea(), o.getArea());
    }

    @Override
    public boolean equalArea(Rectangle object1, Rectangle object2) {
        return object1.getArea() == object2.getArea();
    }
}