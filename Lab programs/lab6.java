
import java.util.Scanner;

class Ride {
    String passenger;
    String driver;
    double distance;

    Ride(String passenger, String driver, double distance) {
        this.passenger = passenger;
        this.driver = driver;
        this.distance = distance;
    }

    double calculateFare() {
        return 50 + distance * 12;
    }

    void displayDetails() {
        System.out.println("\nRide Details");
        System.out.println("Passenger: " + passenger);
        System.out.println("Driver: " + driver);
        System.out.println("Distance: " + distance + " km");
        System.out.printf("Total Fare: Rs. %.2f%n", calculateFare());
    }
}

public class RideSharingPlatformSimulator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();

        System.out.print("Enter distance in km: ");
        double distance = sc.nextDouble();

        if (distance <= 0) {
            System.out.println("Invalid distance.");
        } else {
            Ride ride = new Ride(name, "Driver-101", distance);
            ride.displayDetails();
            System.out.println("Ride booked successfully.");
        }

        sc.close();
    }
}
Enter passenger name: Hemanth
Enter distance in km: 10

Ride Details
Passenger: Hemanth
Driver: Driver-101
Distance: 10.0 km
Total Fare: Rs. 170.00
Ride booked successfully.
