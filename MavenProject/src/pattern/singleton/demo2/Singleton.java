package MavenProject.src.pattern.singleton.demo2;

// eager - static block
public class Singleton {
    private Singleton() {}

    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    public static Singleton getInstance() {
        return instance;
    }
}
