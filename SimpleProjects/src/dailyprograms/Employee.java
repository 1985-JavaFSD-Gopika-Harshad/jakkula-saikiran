package dailyprograms;

public class Employee {
	 private String name;
	    private double salary;

	    // Constructor
	    public Employee(String name, double salary) {
	        this.name = name;
	        this.salary = salary;
	    }

	    // Getters
	    public String getName() {
	        return name;
	    }

	    public double getSalary() {
	        return salary;
	    }

	    @Override
	    public String toString() {
	        return "Employee{" +
	                "name='" + name + '\'' +
	                ", salary=" + salary +
	                '}';
	    }
	}