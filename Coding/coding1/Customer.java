import java.util.ArrayList;

public class Customer {
    private String name;
    private String password;
    private boolean gender;
    private int age;

    private ArrayList<Vehicle> cars;

    Customer(){
        cars = new ArrayList<>();
    }

    Customer(String n, String p){
        this();
        name = n;
        password = p;
    }

    public boolean login(String name, String password){
        if(name==getName() && password==getPassword()){
            System.out.println("welcome");
            return true;
        }else{
            System.out.println("wrong info");
            return false;
        }
    }

    public void addCar(Vehicle v){
        cars.add(v);
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    


}
