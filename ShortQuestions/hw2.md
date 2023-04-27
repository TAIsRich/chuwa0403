### 1. Write up Example code to demonstrate the three foundmental concepts of OOP. (reference Code Demo repo as example)
```
1. Encapsulation
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String setName() {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
```
```
2. Polymorphism
class Animal {
    public void makeSound() {
        System.out.println("Animal is making a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog is barking");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Cat is meowing");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal animal1 = new Animal();
        Animal animal2 = new Dog();
        Animal animal3 = new Cat();
        
        animal1.makeSound(); // Output: "Animal is making a sound"
        animal2.makeSound(); // Output: "Dog is barking"
        animal3.makeSound(); // Output: "Cat is meowing"
    }
}
```
```
3. Inheritance
class Animal {
    public void makeSound() {
        System.out.println("Animal is making a sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Dog is barking");
    }
}

public class Main {
    public static void main(String[] args) {       
        Animal animal = new Animal();
        animal.makeSound(); // Output: "Animal is making a sound"
        
        Dog dog = new Dog();
        dog.makeSound(); // Output: "Dog is barking"
    }
}
```

### 2. What is wrapper class in Java and Why we need wrapper class?
A wrapper class is a class that encapsulates a primitive data type into an object, such as Byte, Short, Integer, Long, Float, Double, Boolean, Character.

### 3. What is the difference between HashMap and HashTable?
1.Synchronize: HashTable is synchronized, therefore thread-safe, while HashMap is not.

2.HashMap allows null key and null values, while HashTable does not. Trying to insert a null key or null value in HashTable will result in a NullPointerException.

3.HashMap is generally faster than HashTable because of synchronization.

### 4. What is String pool in Java and why we need String pool?
String pool is a storage area allocated to store the string literals. When a string is needed, the JVM searches the string pool to check if an identical string already exists. If it does, the JVM simply returns a reference instead of creating a new string object. By reusing string literals, our program becomes more efficient and memory saved. String is immutable in Java, which helps ensure consistency and prevent errors in the program.

### 5. What is Java garbage collection?
Garbage collection in Java is a mechanism to manage the object lifecycle. When an object has no reference, the GC recycle the memory.

### 6. What are access modifiers and their scopes in Java?
Access modifiers are keywords restrict the access scope to class, methods and variables. There are four types of them in Java.
Public:	visible everywhere
Default: only visible within the package (package private)
Protected: visible within the package or all subclasses
Private: only visible within the class

### 7. What is final key word? (Fields, Method, Class)
Final variables: The value cannot be changed once it is assigned. Used to define constants.
Final methods: Cannot be overridden in the subclass.
Final classes: Prevent from been inherited.

### 8. What is static keyword? (Fields, Method, Class). When do we usually use it?
When we use static to modify variables, they belongs to the class instead of an instance. We can access static variables directly using the class name without creating an instance of the class.
When we use static to modify methods, they belongs to the class instead of an instance.Just like the static variables, we can access static variables directly using the class name without creating an instance of the class.
A static inner class is a nested class which is a static member of the outer class. A static nested class does not have access to the instance variables and methods of the outer class. 

### 9. What is the differences between overriding and overloading?
| overriding | overloading |
|----------|----------|
| runtime | compile time |
| Private and final methods can NOT be overridden | Private and final methods can be overloaded |
| Return type must be the same | Return type does not matter|
| Arguments must be the same | Arguments must be different |
| In the subclass | In the same class |

### 10. What is the differences between super and this?
Super is used to refer to the super or parent class while this is used to refer to the current class or object. Super can also be used to call the constructor of the parent class.

### 11. What is the Java load sequence?
Java load sequence is generally devided into these phases.
Loading: The JVM loads the class files into memory.
Linking: The JVM performs three operations on the loaded class: verification, preparation, and resolution. Verification checks whether the bytecode of the class is valid and conforms to the Java language specification. Preparation allocates memory for the class variables and initializes them to their default values. Resolution resolves any symbolic references in the bytecode to their corresponding memory addresses.
Initialization: The JVM initializes the static initialization blocks and static variable of the class in the order they appear in the code. This phase is executed only once per class, when the class is first loaded.

### 12. What is Polymorphism ? And how Java implements it ?
Polymorphism refers to an object take on different forms and behaviors.Polymorphism is implemented with method overloading and method overriding.

Static Polymorphism - Overload (same class) - compile time
Dynamic Polymorphism - Override (child class) - run time

### 13. What is Encapsulation ? How Java implements it? And why we need encapsulation?
Encapsulation refers to binding data and the methods to malipulate it within a single unit(class). We need encapsulation because of these reasons.
Abstraction: Encapsulation allows the implementation details of a class to be hidden, only provides limited access interfaces.
Data security: Encapsulation helps to protect the data of a class from unwanted access and manipulation by external code.

### 14. What is Interface and what is abstract class? What are the differences between them?

| Interface | Abstract class |
|----------|----------|
| Implements | Extends |
| Can implement more than one interfaces | Can extends only one Abstract class |
| Does not have access modifiers, public | Can have access modifiers |
| Have default and static methods, can provide default implementations for its methods using the default keyword | Can provide implementations for default methods |
| static or final variables | any type of variables |
| Can **NOT** have constructors | Can have constructors |

### 15. (OOD) Design a parking lot (put the code to codingQuestions/coding1 folder, )
1. If you have no ability to design it, please find the solution in internet, then understand it, and re-type it.(Do NOT just copy and paste)
```
public class ParkingLot {
    private final List<ParkingSpot> spots;

    public ParkingLot(int numSpots) {
        this.spots = new ArrayList<>(numSpots);
        for (int i = 0; i < numSpots; i++) {
            spots.add(new ParkingSpot());
        }
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.canParkVehicle(vehicle)) {
                spot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public void unparkVehicle(Vehicle vehicle) {
        for (ParkingSpot spot : spots) {
            if (spot.isOccupied() && spot.getVehicle().equals(vehicle)) {
                spot.unparkVehicle();
            }
        }
    }
}

public class ParkingSpot {
    private Vehicle vehicle;
    private boolean occupied;

    public boolean canParkVehicle(Vehicle vehicle) {
        return !occupied && vehicle.canFitInSpot(this);
    }

    public void parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        occupied = true;
    }

    public void unparkVehicle() {
        this.vehicle = null;
        occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}

public abstract class Vehicle {
    private final String licensePlate;
    private final int spotsNeeded;

    public Vehicle(String licensePlate, int spotsNeeded) {
        this.licensePlate = licensePlate;
        this.spotsNeeded = spotsNeeded;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getSpotsNeeded() {
        return spotsNeeded;
    }

    public abstract boolean canFitInSpot(ParkingSpot spot);
}

public class Motorcycle extends Vehicle {
    public Motorcycle(String licensePlate) {
        super(licensePlate, 1);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return true;
    }
}

public class Car extends Vehicle {
    public Car(String licensePlate) {
        super(licensePlate, 1);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        return !spot.isOccupied();
    }
}

public class Bus extends Vehicle {
    public Bus(String licensePlate) {
        super(licensePlate, 5);
    }

    @Override
    public boolean canFitInSpot(ParkingSpot spot) {
        if (spot.isOccupied()) {
            return false;
        }
        int numSpotsNeeded = getSpotsNeeded();
        for (int i = 1; i < numSpotsNeeded; i++) {
            if (!spot[i].canParkVehicle(this)) {
                return false;
            }
        }
        return true;
    }
}
```
The ParkingLot class contains a list of ParkingSpots. The ParkingSpot class represents a single parking spot and contains the Vehicle object that occupies the spot. The Vehicle class is an abstract class that defines the basic attributes of a vehicle, such as license plate and number of spots needed, and provides an abstract method to check if a vehicle can fit in a parking spot. The Motorcycle, Car, and Bus classes extend the Vehicle class and provide concrete implementations of the canFitInSpot method for each vehicle type. The ParkingLot class provides methods to park and unpark vehicles. The parkVehicle method iterates over the list of parking spots and finds the first available spot that can fit the vehicle. The unparkVehicle method iterates over the list of parking.

### 16. What are Queue interface implementations and what are the differences and when to use what?
The Queue interface defines a set of FIFO collections.
LinkedList: LinkedList is a doubly linked list implementation of the Queue interface in Java. It provides efficient insertion and removal of elements at both ends of the queue, which makes it suitable for use cases where elements are frequently added and removed from both ends of the queue. LinkedList also allows null elements and maintains the insertion order of elements.
ArrayDeque: A resizeable array to store elements. ArrayDeque does not allow null elements and maintains the insertion order of elements. It is suitable for use cases where elements are frequently added and removed from both ends of the queue and the size of the queue is known in advance. 
PriorityQueue: The PriorityQueue class is part of the Java Collections framework and implements the Queue interface. It represents a queue where the elements are ordered based on their natural order or according to a specified Comparator. PriorityQueue does not allow null elements, and it does not maintain the insertion order of elements.
