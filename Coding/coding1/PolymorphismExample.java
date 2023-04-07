public class PolymorphismExample{
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle();
        shapes[1] = new Square();
        shapes[2] = new Triangle();

        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}

//The Shape class is the parent class, and the Circle, Square and Triangle classes are its child classes.
//All child classes inherit the draw() method from the Shape class.
//Each child class provides its own implementation of the draw() method using the @Override annotation. This allows the Circle class to draw a circle, the Square class to draw a square, and the Triangle class to draw a triangle, instead of just drawing a generic shape.
class Shape {
    public void draw() {
        System.out.println("Drawing a shape");
    }
}

class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Square extends Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a square");
    }
}

class Triangle extends Shape{
    @Override
    public void draw(){
        System.out.println("Drawing a triangle");
    }
}

