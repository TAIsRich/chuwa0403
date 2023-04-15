package hw2.polymorphism;

public class Main {
    public static void main(String[] args) {
        People p1 = new Student(10);
        People p2 = new People(10);
        People p3 = new Teacher(10);
        Student s1 = new Student(10);
        Teacher t1 = new Teacher(10);

        p1.print();
        p2.print();
        p2.print(3);
        p3.print();
        s1.print();
        t1.print();

        Message m = new Message();
        m.sendToPeople(p2);
        m.sendToPeople(p3);
        m.sendToPeople(t1);

        // m.sendToTeacher(p3);  not available
        m.sendToTeacher(t1);

    }

}

class Message{
    public void sendToPeople(People p){
        System.out.println("send to a people");
        p.print();
    }

    public void sendToTeacher(Teacher t){
        System.out.println("send to a teachar");
        t.print();
    }
}

