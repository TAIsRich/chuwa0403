public class Teacher extends Person{
    public Teacher() {
    }

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public void hobby() {
        super.hobby();
        System.out.println(getAge());
    }
}
