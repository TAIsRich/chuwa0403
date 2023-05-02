package factory;

public abstract class Coffee {

    public abstract String getName();

    public void addSugar() {
        System.out.println("jiatang!1");
    }

    public void addMilk() {
        System.out.println("jianai!");
    }
}
