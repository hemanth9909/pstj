PriorityQueue
  code:
  import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double cgpa;

    public Student(int id, String name, double cgpa) {
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getCGPA() {
        return cgpa;
    }
}

class Priorities {

    public List<Student> getStudents(List<String> events) {

        PriorityQueue<Student> queue = new PriorityQueue<>(
            (a, b) -> {

                // Higher CGPA first
                int result = Double.compare(b.getCGPA(), a.getCGPA());

                if (result != 0) {
                    return result;
                }

                // Same CGPA -> name ascending
                result = a.getName().compareTo(b.getName());

                if (result != 0) {
                    return result;
                }

                // Same CGPA and name -> ID ascending
                return Integer.compare(a.getID(), b.getID());
            }
        );

        for (String event : events) {

            String[] parts = event.split(" ");

            if (parts[0].equals("ENTER")) {

                String name = parts[1];
                double cgpa = Double.parseDouble(parts[2]);
                int id = Integer.parseInt(parts[3]);

                queue.add(new Student(id, name, cgpa));

            } else if (parts[0].equals("SERVED")) {

                queue.poll();
            }
        }

        List<Student> students = new ArrayList<>();

        while (!queue.isEmpty()) {
            students.add(queue.poll());
        }

        return students;
    }
}

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<String> events = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            events.add(sc.nextLine());
        }

        Priorities priorities = new Priorities();

        List<Student> students = priorities.getStudents(events);

        for (Student student : students) {
            System.out.println(student.getName());
        }

        sc.close();
    }
}

Input (stdin)
12
ENTER John 3.75 50
ENTER Mark 3.8 24
ENTER Shafaet 3.7 35
SERVED
SERVED
ENTER Samiha 3.85 36
SERVED
ENTER Ashley 3.9 42
ENTER Maria 3.6 46
ENTER Anik 3.95 49
ENTER Dan 3.95 50
SERVED
Expected Output
Dan
Ashley
Shafaet
Maria
