package inheritance;

public class Student extends Person {

    public Student(String name, String phoneNumber) {
        super(name, phoneNumber);
    }

    public Student() {
        System.out.println("Student constructor");
    }

    @Override
    public boolean signUp() {
        return false;
    }

    @Override
    public void walk() {
        super.walk();
    }

    public void walkable() {
        super.walk();
        super.meeting();
    }

    public static void main(String[] args) {
        Student student = new Student();
        student.walkable();
    }
}
