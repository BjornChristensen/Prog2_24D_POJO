package collections;

import java.util.HashMap;
import java.util.Map;

public class StudentGrades {
    public static void main(String[] args) {
        HashMap<String, Integer> grades = new HashMap<>();
        grades.put("Alice", 85);
        grades.put("Bob", 80);
        grades.put("Charlie", 70);
        grades.put("David", 60);

        // Print all grades
        System.out.println("Student grades");
        for (String key : grades.keySet()) {
            System.out.println(key + ": " + grades.get(key));
        }
        // More economic
        for (Map.Entry<String, Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());
        }

        // Get Alice's grade
        Integer gr=grades.get("Alice");
        System.out.println(gr);

        // Update Alice's grade
        grades.put("Bob", 88);

        // Remove a student
        grades.remove("Bob");

        // Check if "Bob" is there
        System.out.println(grades.containsKey("Bob"));

        // Simple printout
        System.out.println(grades);
    }
}
