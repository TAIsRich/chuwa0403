package optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, new User("Alice", new Address("Main Street")));
        userMap.put(2, new User("Bob", new Address(null)));

        // Without Optional
        String streetName = "Unknown";
        User user = userMap.get(2);
        if (user != null) {
            Address address = user.getAddress();
            if (address != null) {
                streetName = address.getStreet();
            }
        }
        System.out.println("Street name without Optional: " + streetName);

        // With Optional
        streetName = Optional.ofNullable(userMap.get(2))
                .map(User::getAddress)
                .map(Address::getStreet)
                .orElse("Unknown");
        System.out.println("Street name with Optional: " + streetName);
    }
}
