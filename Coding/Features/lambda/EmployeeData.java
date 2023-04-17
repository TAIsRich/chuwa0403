package Coding.Features.lambda;
import java.util.*;

public class EmployeeData {
    static List<Employee> lst = new ArrayList<>();
    public static List<Employee> getEmployees() {
        lst.add(new Employee());
        return lst;
    }
}
