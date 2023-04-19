public class singleton {
    private static final singleton singletonInst = new singleton();
    private String message = "";
    private singleton() {
    }
    public static singleton getInstance(){
        return singletonInst;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
public class singleton {
    private static singleton singletonInst;
    private String message = "";
    private singleton() {
        System.out.println("Singleton instance.");
    }
    public static singleton getInstance(){
        if(singletonInst==null){
            singletonInst = new singleton();
            System.out.println("SingletonCls instance.");
        }
        return singletonInst;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}