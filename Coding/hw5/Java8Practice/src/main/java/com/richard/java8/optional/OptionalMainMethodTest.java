package com.richard.java8.optional;

import com.richard.java8.lambda.Employee;
import org.junit.Test;

import java.util.Optional;

/**
 * @Author zhuhaotian
 * @Date 2023/4/15
 */

public class OptionalMainMethodTest {

    /**
     * https://www.youtube.com/watch?v=wOi2k4dJviM&list=PLmOn9nNkQxJH0qBIrtV6otI0Ep4o2q67A&index=684
     * of(T t) - 不可以为null
     * ofNullable(T t) - 可以为null
     * orElse(T t) - 如果当前的optional内部封装的t是非空的，则返回内部t, 如果内部的t是空的， 则返回orElse()方法中的t
     */

    @Test
    public void testOptionalWithoutHandlingException() {
        Employee emp = new Employee();
        Optional<Employee> optional = Optional.of(emp);

        // of(T t) - 不可以为null
        // 如果为null会抛出异常
        emp = null;
        optional = Optional.of(emp);
    }

    @Test(expected = NullPointerException.class)
    public void testWithAddingExceptionToAnnotation() {
        Employee emp = new Employee();
        Optional<Employee> optional = Optional.of(emp);

        // of(T t) - 不可以为null
        // 这里在注释里面已经expected了exception
        // 所以不会抛出异常
        emp = null;
        optional = Optional.of(emp);
    }

    @Test
    public void testOfNullable() {
        Employee emp = new Employee();
        Optional<Employee> optional = Optional.ofNullable(emp);

        // ofNullable(T t) - 可以为null
        emp = null;
        optional = Optional.ofNullable(emp);
    }

    @Test
    public void testOrElse() {
        Employee emp = new Employee();
        Optional<Employee> optional = Optional.ofNullable(emp);
        System.out.println(optional);

        emp = null;
        Optional<Employee> optional2 = Optional.ofNullable(emp);
        System.out.println(optional2);

        // 注意这里emp是null，所以一定会执行orElse
        // 然后orElse返回了一个新的Employee
        Employee emp1 = Optional.ofNullable(emp).orElse(new Employee(1, "JCole", 30, 6666));
//        if (emp != null) {
//            emp1 = emp;
//        } else {
//            emp1 = new Employee(1, "JCole", 30, 6666);
//        }
        System.out.println(emp1);
    }

    @Test
    public void testOrElseThrow() {
        Employee emp = new Employee();
        Optional<Employee> optional = Optional.ofNullable(emp);
        System.out.println(optional);

        emp = null;
        Optional<Employee> optional2 = Optional.ofNullable(emp);

        Employee emp1 = Optional.ofNullable(emp).orElseThrow(() -> new RuntimeException("Exception Throwed"));
        System.out.println(emp1);
    }
}
