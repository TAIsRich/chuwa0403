package hw2.inheritance;

public abstract class People {
    private int age;
    private boolean gender;

    People(int age, boolean gender){
        this.age = age;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public abstract void print();

    public abstract void onlyPeople();

}
