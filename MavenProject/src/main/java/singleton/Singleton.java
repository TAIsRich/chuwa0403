package singleton;

public class Singleton {
    // Private static variable to hold the single instance of the class
    private static Singleton instance;

    // Private constructor to prevent external instantiation
    private Singleton() {
        // Optional: initialization code
    }

    // Public static method to get the single instance of the class
    public static Singleton getInstance() {
        // If the instance has not yet been created, create it
        if(instance == null) {
            instance = new Singleton();
        }
        // Return the single instance
        return instance;
    }
}
