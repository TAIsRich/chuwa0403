package hw5.feature.lambda;

public class LambdaLearn {
    public static void main(String[] args) {

        // before Java 8
        Foo foo = new Foo(){
            public String method(String s){
                return "foo"+s;
            }
        };
        String sf=foo.method("a");
        //  new foo is an anonymous class to override method

        // use lambda to simplify overriding the method
        // but only for the functional interface
        // only one abstract function and the lambda will become the method
        Foo fooLam = parameter -> "foo"+ parameter;
        String sfl = fooLam.method("d");

    }

    public void testEffectivelyFinal(){
        String s = "local";
        int i = 0;
        Emp e = new Emp();

        // s = "a"; // cannot use s in method
        e.setAge(10); // using function is okay
        // e = new Emp(); // reassign changes the location

        Foo foo = p -> {return i+p+s+e.getAge();};
        // i = 9; // cannot use i in method
        // Foo foo = p -> p+s;
        // s = "a"; // cannot use s in method

    }
}
@FunctionalInterface
interface Foo{
    String method(String s);

    default String defaultContent(){
        return "foo";
    }


}
class Emp{
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
