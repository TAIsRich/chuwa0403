
public class Main {

    public static void main(String[] args) {

        Circle circle1 = new Circle(1, "red", true);
        Circle circle2 = new Circle(2, "blue", false);
        Circle circle3 = new Circle(2, "green", true);

        System.out.println(circle1.toString());
        System.out.println(circle2.toString());
        System.out.println(circle3.toString());

        System.out.println("The area of circle1: " + circle1.getArea());
        System.out.println("The area of circle2: " + circle2.getArea());
        System.out.println("The area of circle3: " + circle3.getArea());
        System.out.println("Circle3 compared to circle2: " + circle3.compareTo(circle2));
        System.out.println("Circle1 and circle2 equal or not: " + circle1.equalArea(circle1, circle2));

        String s = new String("123");
    }
}
