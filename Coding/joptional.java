public class OptionalDemo {
    public static void main(String[] args) {
        Map<Integer, User> userMap = new HashMap<>();
        userMap.put(1, new User("Alice", new Address("Main Street")));
        userMap.put(2, new User("Bob", null));
        String streetName = "Unknown";
        User user = userMap.get(2);
        if (user != null) {
            Address address = user.getAddress();
            if (address != null)
                streetName = address.getStreet();
        }
        System.out.println("Street name without Optional: " + streetName);
        streetName = Optional.ofNullable(userMap.get(2))
                .map(User::getAddress)
                .map(Address::getStreet)
                .orElse("Unknown");
        System.out.println("Street name with Optional: " + streetName);
    }
}

class Address {
    private String street;
    public Address(String street) {
        this.street = street;
    }
    public String getStreet() {
        return street;
    }
}
class User {
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
public class OptionalMainMethodTest {
    @Test()
    public void testOptionalWithNotHandleException() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);
        employee = null;
        Optional<Employee> optional2 = Optional.of(employee);
    }
    @Test(expected = NullPointerException.class)
    public void test1() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);
        employee = null;
        Optional<Employee> optional2 = Optional.of(employee);
    }

    @Test
    public void testOfNullable() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);
        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);
    }

    @Test
    public void testOrElse() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);
        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);
        Employee employee1 = Optional.ofNullable(employee).orElse(new Employee(1, "JCole", 30, 6666));
        if (employee != null) {
            employee1 = employee;
        } else {
            employee1 = new Employee(1, "JCole", 30, 6666);
        }
        System.out.println(employee1);
    }
    @Test
    public void testOrElseThrow() {
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);
        employee = null;
        Optional<Employee> optional2 = Optional.ofNullable(employee);
        System.out.println(optional2);
        Employee employee1 = Optional.ofNullable(employee).orElseThrow(() -> new RuntimeException("Wow Exception"));
        System.out.println(employee1);
    }
}
class OptionalTest {
    @Test
    void testOf() {
        String value = "Hello, Optional!";
        Optional<String> optional = Optional.of(value);
        assertTrue(optional.isPresent());
        assertEquals(value, optional.get());
    }
    @Test
    void testOfNullable() {
        String value = null;
        Optional<String> optional = Optional.ofNullable(value);
        assertFalse(optional.isPresent());
    }
    @Test
    void testEmpty() {
        Optional<String> optional = Optional.empty();
        assertFalse(optional.isPresent());
    }
    @Test
    void testIfPresent() {
        Optional<String> optional = Optional.of("Hello, Optional!");
        optional.ifPresent(value -> assertEquals("Hello, Optional!", value));
    }
    @Test
    void testOrElse() {
        Optional<String> optional = Optional.empty();
        String result = optional.orElse("Default value");
        assertEquals("Default value", result);
    }
    @Test
    void testOrElseGet() {
        Optional<String> optional = Optional.empty();
        String result = optional.orElseGet(() -> "Default value");
        assertEquals("Default value", result);
    }
    @Test
    void testOrElseThrow() {
        Optional<String> optional = Optional.empty();
        assertThrows(NoSuchElementException.class, optional::orElseThrow);
    }
    @Test
    void testFilter() {
        Optional<Integer> optional = Optional.of(42);
        Optional<Integer> filtered = optional.filter(value -> value % 2 == 0);
        assertTrue(filtered.isPresent());
        assertEquals(42, filtered.get());

        filtered = optional.filter(value -> value % 2 != 0);
        assertFalse(filtered.isPresent());
    }
    @Test
    void testMap() {
        Optional<String> optional = Optional.of("Hello, Optional!");
        Optional<Integer> mapped = optional.map(String::length);
        assertTrue(mapped.isPresent());
        assertEquals(16, mapped.get());
    }
    @Test
    void testFlatMap() {
        Optional<String> optional = Optional.of("Hello, Optional!");
        Optional<Integer> flatMapped = optional.flatMap(value -> Optional.of(value.length()));
        assertTrue(flatMapped.isPresent());
        assertEquals(16, flatMapped.get());
    }
}