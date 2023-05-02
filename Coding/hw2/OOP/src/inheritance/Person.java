package inheritance;

public abstract class Person {
    private String name;
    private String phoneNumber;

    public Person() {
//        System.out.println("Person non-arguments construtor");
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public abstract boolean signUp();

    public void walk() {
        System.out.println("People Walk");
    }

    public void meeting() {
        System.out.println("People meeting");
    }
}
