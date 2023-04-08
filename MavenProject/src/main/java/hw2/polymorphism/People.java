package hw2.polymorphism;

public class People {
    private int age;
    private boolean gender;

    People(int age){
        this.age = age;
    }

    People(int age, boolean gender){
        this(age);
        this.gender = gender;
    }

    public void print(){
        System.out.println("I am a people");
    }

    public void print(int num){
        System.out.println("I am a people -"+num);
    }
}

class Student extends People {
    private int grade;

    Student(int age){
        super(age);
    }

    Student(int age, boolean gender){
        super(age, gender);
    }

    Student(int age, boolean gender, int grade){
        this(age, gender);
        this.grade = grade;
    }

    public void print(){
        System.out.println("I am a student");
    }
    public void print(int a){

        System.out.println("I am a student -"+ a);
    }
    public void onlyStudent(){
        System.out.println("only student");
    }

}

class Teacher extends People {
    private int salary;

    Teacher(int age){
        super(age);
    }

    Teacher(int age, boolean gender){
        super(age, gender);
    }

    Teacher(int age, boolean gender, int salary){
        this(age, gender);
        this.salary = salary;
    }

    public void print(){
        System.out.println("I am a teacher");
    }
    public void print(int a){
        System.out.println("I am a teacher -"+a);
    }
    public void onlyTeacher(){
        System.out.println("only student");
    }

}