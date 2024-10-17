//Scenario 5: Handling Key-Value Pairs
//You are developing an application where you need to associate each student with their respective grades. Which Java collection would be appropriate for storing this key-value pair relationship?
//Answer:
//HashMap
//would be suitable for storing the mapping of students to their grades. It allows you to store key-value pairs, where each student's ID (key) maps to their grades (value). This provides efficient retrieval and modification of grades based on the student ID.


package dailyprograms;

import java.util.HashMap;

public class Student {
	public static void main(String[] args) {
		HashMap<String,Integer> grades=new HashMap<>();
		grades.put("Sai001",99);
		//grades.put("Sai001", 90);
		grades.put("Prasad002",85);
		grades.put("rashmika003",80);
		grades.put("samantha004", 60);
		grades.put("ananya005", 78);
		
		
		String id="Sai001";
		System.out.println("grade of student  :"+id+" ="+grades.get(id));
		
		grades.put("Prasad002",75);
		
		grades.remove("rashmika003");
		
		System.out.println("all students with grades :"+ grades);
		
		
	}

}
