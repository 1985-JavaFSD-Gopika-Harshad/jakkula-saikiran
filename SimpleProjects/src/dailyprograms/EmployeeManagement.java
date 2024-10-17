package dailyprograms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeManagement {
	public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("prasad", 50000));
        employees.add(new Employee("babulal", 60000));
        employees.add(new Employee("pavan sai", 45000));
        employees.add(new Employee("saikiran", 70000));

        // Sort employees by salary in descending order
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e2.getSalary(), e1.getSalary()); // Descending order
            }
        });

        // Print sorted employees
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

}
