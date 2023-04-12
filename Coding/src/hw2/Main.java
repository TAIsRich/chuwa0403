package hw2;

public class Main {

    public static void main(String[] args) {
	   // Encapsulation
        User user = new User();
        user.setUserName("Min He");
        user.setUserPassword("12345");
        user.setUserRole("membership");
        System.out.println("A new user is : " + user.getUserName() + ". Her password is : " + user.getUserPassword() + ", and her role is : " + user.getUserRole());

        Guest guset1 = new Guest("Min He","12345");
        guset1.login(user.getUserName(), user.getUserPassword());
        user.setUserPassword("5555");
        guset1.login(user.getUserName(), user.getUserPassword());

        Guest guest2 = new Guest(user.getUserName(),user.getUserPassword(),user.getUserRole());
        guest2.register("Hao Liu","123");
        /*
        ***output***
        A new user is : Min He. Her password is : 12345, and her role is : membership
        Login  Successful !
        You are a non-member. You need to register first !
        You Register Successful ! Your user name is : Hao Liu, and password is : 123. Your role now is : member
        */
    }
}
