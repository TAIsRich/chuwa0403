package hw2.inheritance;

import java.util.ArrayList;
import java.util.Arrays;

public class Student extends People implements School, Hobby{
    private String school;
    private ArrayList<String> hobbies;
    public Student(int age, boolean gender, String school){
        super(age, gender);
        setSchool(school);
        hobbies = new ArrayList<>();
    }

    @Override
    public void print() {
        int i = 0;
        System.out.println("I am a student");
    }

    @Override
    public void setSchool(String s) {
        this.school = s;
    }

    @Override
    public void getInfo() {
        School.super.getInfo();
        System.out.println(this.school);
        Hobby.super.getInfo();
        System.out.println(Arrays.toString(hobbies.toArray()));
    }


    @Override
    public void addHobby(String h) {
        hobbies.add(h);
    }

    public void useStaticMethod(){
        School.info();
    }
}
