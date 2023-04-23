package hw2.inheritance;

public class Main {
    public static void main(String[] args) {
        Student s = new Student(14, false, "A");
        s.addHobby("swimming");
        s.print();
        s.getInfo();
        s.useStaticMethod();

        Worker w = new Worker(40,true);
        w.print();
    }
}
