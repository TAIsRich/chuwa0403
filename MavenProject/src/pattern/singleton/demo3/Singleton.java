package MavenProject.src.pattern.singleton.demo3;

// lazy - thread safe - lower performance
public class Singleton {
    private Singleton() {}

    private static Singleton instance;

    public static synchronized Singleton getInstance() {
        if (instance == null)
            instance = new Singleton();
        return instance;
    }
}
