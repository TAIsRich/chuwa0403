package MavenProject.src.pattern.singleton.demo1;

// eager - static variable
public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){}

    public static Singleton getInstance() {
        return instance;
    }
}
