package hw5.feature.optional;

import hw0.help.Employee;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class OptionalMainMethodTest {
    @Test
    public void testOptionalWithOutHandleException(){
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);

        employee = null; // of(T t) cannot be null
        Optional<Employee> optional2 = Optional.of(employee);
    }

    @Test(expected = NullPointerException.class)
    public void test1(){
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.of(employee);

        employee = null;
        Optional<Employee> optional1 = Optional.of(employee);
    }

    @Test
    public void testOfNullable(){
        Employee e = new Employee();
        Optional<Employee> optional = Optional.ofNullable(e);
        System.out.println(optional);

        e= null;
        System.out.println(optional); // still has the object
        Optional<Employee> optional1 = Optional.ofNullable(e);
        System.out.println(optional1);
    }

    @Test
    public void testOrElse(){
        Employee e = new Employee();
        Optional<Employee> optional = Optional.ofNullable(e);


        e= null;

        Employee e1 = Optional.ofNullable(e).orElse(new Employee(1,"Jone",3,5));
        System.out.println(e1);
        if(e != null){
            e1 = e;
        }else{
            e1 = new Employee(1,"K", 3, 6);
        }
        System.out.println(e1);
    }

    @Test
    public  void testOrElseThrow(){
        Employee employee = new Employee();
        Optional<Employee> optional = Optional.ofNullable(employee);
        System.out.println(optional);

        employee = null;

        Employee employee1 = Optional.ofNullable(employee).orElseThrow(()-> new RuntimeException("exception"));
        System.out.println(employee1);

    }

}
