package features.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Min He
 * @date 4/16/23 20:50 PM
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1,new User("Alice",new Address("Main Street")));
        userMap.put(2,new User("Bod",null));
        //without Optional
        String streetName = "unKnown";
        User user = userMap.get(2);
        if(user != null){
            Address address = user.getAddress();
            if(address != null){
                streetName = address.getStreet();
            }
        }
        System.out.println("street name without Optional" + streetName);

        //with optional
        streetName = Optional.ofNullable(userMap.get(2))
                .map(User::getAddress)
                .map(Address::getStreet)
                .orElse("Unknown");

        System.out.println("street name with Optional" + streetName);
    }

}
class Address{
    private String street;
    public Address(String street){
        this.street = street;
    }
    public String getStreet(){
        return street;
    }
}
class User{
    private String name;
    private Address address;

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}