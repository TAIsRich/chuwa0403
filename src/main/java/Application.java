public class Application {
    public static void main(String[] args) {
        Person p=new Person("Allen",25);
        /**
         * Encapsulation
         */
        System.out.println(p.getAge());
        System.out.println(p.getName());
        /**
         * Inheritance
         */
        Student s=new Student();
        s.hobby();
        /**
         *Polymorphism
         */
        Person t=new Teacher();
        t.hobby();
    }
}
