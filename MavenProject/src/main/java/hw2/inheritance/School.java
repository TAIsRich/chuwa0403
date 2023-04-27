package hw2.inheritance;

public interface School {
    void setSchool(String s);

    default void getInfo(){
        System.out.println("School info");
    }
    static void info(){
        System.out.println(" static info");
    }
}
