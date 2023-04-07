package hw2;
//Inheritance
public class Guest extends User{
    public String guestName;
    public String guestPassword;
    public String role;


    public Guest(String guestName, String guestPassword) {
        this.guestName = guestName;
        this.guestPassword = guestPassword;

    }

    public Guest(String guestName, String guestPassword, String role) {
        this.guestName = guestName;
        this.guestPassword = guestPassword;
        this.role = role;
    }
  // Polymorphism
    @Override
    public void login(String name, String password) {
        if (guestName.equals(name) && guestPassword.equals(password)) {
            this.role = "member";
            System.out.println("Login  Successful !");
        }else{
            this.role = "non-member";
            System.out.println("You are a " + role + ". You need to register first !");
        }
    }

    @Override
    public void register(String name,String password) {
        guestName = name;
        guestPassword = password;
        this.role = "member";
        System.out.println("You Register Successful ! Your user name is : " + guestName + ", and password is : " + guestPassword + ". Your role now is : " + this.role );

    }
}
