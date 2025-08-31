package MAP.GroupEmployeesByDepartment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupEmployeesByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("Tarun", "HR"),
                new Employee("Suryansh", "IT"),
                new Employee("Arjun", "HR"),
                new Employee("Abhay", "Finance"),
                new Employee("Arihant", "IT")
        );

        HashMap<String,List<Employee>> employeeMap = new HashMap<>();

        for (Employee e : employees) {
            if (!employeeMap.containsKey(e.getDepartment())) {
                employeeMap.put(e.getDepartment(),new ArrayList<>());
            }
            employeeMap.get(e.getDepartment()).add(e);
        }

        System.out.println(employeeMap);
    }
}
