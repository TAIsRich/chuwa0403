package org.example;

public class Main {
    public static void main(String[] args) {
        Shape circle = ShapeFactory.createShape("CIRCLE");
        circle.draw();  // Output: Drawing a circle.

        Shape rectangle = ShapeFactory.createShape("RECTANGLE");
        rectangle.draw();  // Output: Drawing a rectangle.

    }
}