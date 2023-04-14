package DesignPattern.PS;

public class WexinUser implements Observer{
    private String name;

    public WexinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " " + message);
    }
}
