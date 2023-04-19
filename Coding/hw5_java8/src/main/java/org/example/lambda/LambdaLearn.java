package org.example.lambda;
import org.junit.Test;

import java.util.List;
public class LambdaLearn {
    @Test
    public void overrideFoo(){
        Foo footest1 = new Foo(){
            @Override
            public String aMethod(String s){
                return s + "from footest1";
            }
        };
        String hello = footest1.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void lambdaFoo(){
        //lambda provide method body for abstract method
        Foo foo = parameter -> parameter + " from Foo";

        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }
    @Test
    public void lambdaFoo2() {
        // implement any method body
        Foo foo = parameter -> parameter.toUpperCase() + " from Foo";

        String hello = foo.aMethod("hello");
        System.out.println(hello);
    }

    @Test
    public void testFinal() {
        final String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.aMethod("hello"));
    }
    /**
     * Use “Effectively Final” Variables
     * 当variable只赋值一次，没有任何变动的时候，Java默认是final。
     * 注意，在lambda expression的前后都不能被改变
     */
    @Test
    public void testEffectivelyFinal() {
        String localVariable = "Local";
        Foo foo = parameter -> {
            return parameter + " " + localVariable;
        };

        System.out.println(foo.aMethod("hello"));
    }
    /**
     * 换object会报错，因为换了内存地址
     */
    @Test
    public void testFinal21() {
        String localVariable = "Local";
        localVariable = "LOCAL"; // 新的内存地址

        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
            return parameter;
        };

        System.out.println(foo.aMethod("hello"));
    }

    @Test
    public void testFinal22() {
        String localVariable = "Local";

        Foo foo = parameter -> {
//            return parameter + " " + localVariable;
            return parameter;
        };

        localVariable = "LOCAL"; // 新的内存地址

        System.out.println(foo.aMethod("hello"));
    }


}
