
import java.util.Scanner;

class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    double calculateNewSalary(double percentage) {
        return salary + (salary * percentage / 100);
    }
}

public class SalaryTransformationSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter employee name: ");
        String name = sc.nextLine();

        System.out.print("Enter current salary: ");
        double salary = sc.nextDouble();

        System.out.print("Enter increment percentage: ");
        double percentage = sc.nextDouble();

        Employee emp = new Employee(name, salary);
        double revised = emp.calculateNewSalary(percentage);

        System.out.println("Employee Name: " + emp.name);
        System.out.printf("Current Salary: %.2f%n", emp.salary);
        System.out.printf("Revised Salary: %.2f%n", revised);

        sc.close();
    }
}
Enter employee name: Hemanth
Enter current salary: 30000
Enter increment percentage: 10
Employee Name: Hemanth
Current Salary: 30000.00
Revised Salary: 33000.00
