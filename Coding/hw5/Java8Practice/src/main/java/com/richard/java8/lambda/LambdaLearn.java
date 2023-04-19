package com.richard.java8.lambda;

/**
 * @Author zhuhaotian
 * @Date 2023/4/15
 */

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.baeldung.com/java-8-lambda-expressions-tips
 *
 * 1， 只能有一个方法。可以有多个default方法（因为default方法被实现了）
 * 2， Avoid Overloading Methods With Functional Interfaces as Parameters， 如果有overloading, 可以用Cast
 *
 * By using the @FunctionalInterface annotation, the compiler will trigger an error in response to any attempt to
 * break the predefined structure of a functional interface. It is also a very handy tool to make our application
 * architecture easier to understand for other developers.
 */

public class LambdaLearn {

    /* Before Java 8, we can use Anonymous Class to override this method
     * Interface var = new Class
     * List<Integer> var = new ArrayList<>()
     * Foo 这个interface有一个abstract method, 所以在Anonymous Class里需要override来提供method body
     */
    @Test
    public void overrideFoo() {

        Foo foo = new Foo() {
            @Override
            public String aMethod(String s) {
                return "Override method: " + s + " from Foo.";
            }
        };

        String s = foo.aMethod("Hello");
        System.out.println(s);

    }

    @Test
    public void lambdaFoo() {

        // Foo.aMethod() 是abstract method,缺少method body. lambda 提供method body.
        // 比Anonymous class 简洁很多。
        Foo foo = s -> "Override method: " + s + " from Foo.";

        String s = foo.aMethod("Hello");
        System.out.println(s);

        // 同时也可以使用default or static 方法
        foo.defaultBar();
        foo.defaultCommon();
        Foo.staticMethod();

    }

    /**
     * Use “Effectively Final” Variables - 只要变量的地址不变，就可以
     * 1. 用Final修饰
     * 2. 不用final修饰但赋值一次就不再改变
     * 当variable只赋值一次，没有任何变动的时候，Java默认是final。
     * 注意，在lambda expression的前后都不能被改变
     */
    /**
     * 不更改的情况
     */
    @Test
    public void testEffectivelyFinalNotChange() {

        String localVariable = "from Local";
        Foo foo = s -> {
            return "Override method: " + s + " " + localVariable;
        };

        System.out.println(foo.aMethod("Hello"));

    }

    /**
     * 更改的情况 - 在lambda之前修改变量
     */
    @Test
    public void testEffectivelyFinalChangeBefore() {

        String localVariable = "from Local";     // 原址内存地址
        localVariable = "Change before Lambda";  // 新的内存地址

        Foo foo = s -> {
            // 下面这句话会报错，因为上面修改了变量的地址
            // return "Override method: " + s + " " + localVariable;
            return s;
        };

        System.out.println(foo.aMethod("Hello"));

    }

    /**
     * 更改的情况 - 在lambda之后修改变量
     */
    @Test
    public void testEffectivelyFinalChangeAfter() {

        String localVariable = "from Local";     // 原址内存地址

        Foo foo = s -> {
            // 下面这句话会报错，因为下面修改了变量的地址
            // return "Override method: " + s + " " + localVariable;
            return s;
        };

        localVariable = "Change before Lambda";  // 新的内存地址

        System.out.println(foo.aMethod("Hello"));

    }

    /**
     * Object 的本身的方法不会报错
     */
    @Test
    public void testEffectivelyFinalSet() {
        List<Employee> employees = EmployeeData.getEmployees();

        Employee emp = employees.get(0);

        // lambda之前更改值
        emp.setAge(34);

        Foo foo = s -> "Override method: " + s + " " + emp;

        // lambda之后更改值
        emp.setAge(55);

        System.out.println(foo.aMethod("Hello"));
        /**
         * 其实是因为emp只代表了这个对象的地址，具体值是这个地址表示的内存的位置中
         * 存储的数据，emp没有改变，所以地址的值也不会改变，自然而然就可以在lambda中使用
         */
    }

}
