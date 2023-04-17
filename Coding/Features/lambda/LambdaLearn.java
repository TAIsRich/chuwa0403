package Coding.Features.lambda;

import org.junit.Test;
import java.util.*;

public class LambdaLearn {

    @Test
    public void overrideFoo() {
        Foo fooByIC = new Foo() {
            @Override
            public String aMethod(String string) {
                return string + " from foo";
            }
        };

        String hello = fooByIC.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo() {
        Foo foo = a -> a + " from Foo";

        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void lamdaFoo2() {
        Foo foo = a -> a.toUpperCase() + " from foo";

        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void testFinal() {
        final String localVar = "local";
        Foo foo = a -> {
            return a + " " + localVar;
        };

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testEffectivelyFinal() {
        String localVar = "local";
        Foo foo = a -> {
            return a + " " + localVar;
        };

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal121() {
        // String localVariable = "Local";
        // localVariable = "new Local";

        Foo foo = a -> {
            //return a + "" + localVariable;
            return "something " + a;
        };

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal122() {
        //String localVariable = "Local";

        Foo foo = a -> {
            //return a + "" + localVariable;
            return "something " + a;
        };
        //localVariable = "L";
        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal3() {
        List<Employee> employees = EmployeeData.getEmployees();
        Employee employee = employees.get(0);
        employee.setAge(55);
        Foo foo = parameter -> {
            return parameter + " " + employee.getAge();
        };

        System.out.println(foo.aMethod("hello"));

    }

}
