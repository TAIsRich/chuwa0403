package hw2.encapsulation;

public class Encapsulation{

    public static void main(String[]args){
        User u = new User(1,"Jone");
        String key = u.getKey();

    }
}

class User{
    private int value;
    private String key;

    User(int v, String k){
        this.value = v;
        this.key = k;
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

}