package hw2.inheritance;

public class Worker extends People{

    Worker(int age, boolean gender) {
        super(age, gender);
    }

    @Override
    public void print() {
        System.out.println("I am a worker");
    }
}
