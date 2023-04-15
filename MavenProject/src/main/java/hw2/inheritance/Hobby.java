package hw2.inheritance;

public interface Hobby {
    default void getInfo(){
        System.out.println("Hobby info");
    }

    public void addHobby(String h);
}
