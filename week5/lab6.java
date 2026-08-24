import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static class Rider {
        int id;
        String name;

        Rider(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    static class Driver {
        int id;
        String name;
        boolean available;

        Driver(int id, String name) {
            this.id = id;
            this.name = name;
            this.available = true;
        }
    }

    static class Ride {
        int rideId;
        Rider rider;
        Driver driver;
        String pickup;
        String destination;
        String status;

        Ride(int rideId, Rider rider, Driver driver,
             String pickup, String destination) {

            this.rideId = rideId;
            this.rider = rider;
            this.driver = driver;
            this.pickup = pickup;
            this.destination = destination;
            this.status = "ONGOING";
        }

        void display() {
            System.out.println("\n--- Ride Details ---");
            System.out.println("Ride ID     : " + rideId);
            System.out.println("Rider       : " + rider.name);
            System.out.println("Driver      : " + driver.name);
            System.out.println("Pickup      : " + pickup);
            System.out.println("Destination : " + destination);
            System.out.println("Status      : " + status);
        }
    }

    static ArrayList<Rider> riders = new ArrayList<>();
    static ArrayList<Driver> drivers = new ArrayList<>();
    static ArrayList<Ride> rides = new ArrayList<>();

    static int riderId = 1;
    static int driverId = 1;
    static int rideId = 1;

    static void addRider(String name) {
        Rider r = new Rider(riderId++, name);
        riders.add(r);

        System.out.println("Rider added successfully!");
        System.out.println("Rider ID: " + r.id);
    }

    static void addDriver(String name) {
        Driver d = new Driver(driverId++, name);
        drivers.add(d);

        System.out.println("Driver added successfully!");
        System.out.println("Driver ID: " + d.id);
    }

    static void requestRide(int id, String pickup, String destination) {

        Rider rider = null;

        for (Rider r : riders) {
            if (r.id == id) {
                rider = r;
                break;
            }
        }

        if (rider == null) {
            System.out.println("Rider not found!");
            return;
        }

        Driver driver = null;

        for (Driver d : drivers) {
            if (d.available) {
                driver = d;
                break;
            }
        }

        if (driver == null) {
            System.out.println("No driver available!");
            return;
        }

        driver.available = false;

        Ride ride = new Ride(
            rideId++,
            rider,
            driver,
            pickup,
            destination
        );

        rides.add(ride);

        System.out.println("\nRide booked successfully!");
        ride.display();
    }

    static void completeRide(int id) {

        for (Ride ride : rides) {

            if (ride.rideId == id) {

                ride.status = "COMPLETED";
                ride.driver.available = true;

                System.out.println("Ride completed successfully!");
                return;
            }
        }

        System.out.println("Ride not found!");
    }

    static void displayRides() {

        if (rides.isEmpty()) {
            System.out.println("No rides available!");
            return;
        }

        for (Ride ride : rides) {
            ride.display();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== RIDE SHARING PLATFORM =====");
            System.out.println("1. Add Rider");
            System.out.println("2. Add Driver");
            System.out.println("3. Request Ride");
            System.out.println("4. Complete Ride");
            System.out.println("5. Display Rides");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter rider name: ");
                    String riderName = sc.nextLine();
                    addRider(riderName);
                    break;

                case 2:
                    System.out.print("Enter driver name: ");
                    String driverName = sc.nextLine();
                    addDriver(driverName);
                    break;

                case 3:
                    System.out.print("Enter Rider ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter pickup: ");
                    String pickup = sc.nextLine();

                    System.out.print("Enter destination: ");
                    String destination = sc.nextLine();

                    requestRide(id, pickup, destination);
                    break;

                case 4:
                    System.out.print("Enter Ride ID: ");
                    int ride = sc.nextInt();

                    completeRide(ride);
                    break;

                case 5:
                    displayRides();
                    break;

                case 6:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
Output:
===== RIDE SHARING PLATFORM =====
1. Add Rider
2. Add Driver
3. Request Ride
4. Complete Ride
5. Display Rides
6. Exit
Enter choice: 1
Enter rider name: hemanth
Rider added successfully!
Rider ID: 1

===== RIDE SHARING PLATFORM =====
1. Add Rider
2. Add Driver
3. Request Ride
4. Complete Ride
5. Display Rides
6. Exit
Enter choice: 2
Enter driver name: raju
Driver added successfully!
Driver ID: 1

===== RIDE SHARING PLATFORM =====
1. Add Rider
2. Add Driver
3. Request Ride
4. Complete Ride
5. Display Rides
6. Exit
Enter choice: 3
Enter Rider ID: 1
Enter pickup: hyd
Enter destination: kmrl

Ride booked successfully!

--- Ride Details ---
Ride ID     : 1
Rider       : hemanth
Driver      : raju
Pickup      : hyd
Destination : kmrl
Status      : ONGOING

===== RIDE SHARING PLATFORM =====
1. Add Rider
2. Add Driver
3. Request Ride
4. Complete Ride
5. Display Rides
6. Exit
Enter choice: 4
Enter Ride ID: 1
Ride completed successfully!

===== RIDE SHARING PLATFORM =====
1. Add Rider
2. Add Driver
3. Request Ride
4. Complete Ride
5. Display Rides
6. Exit
Enter choice: 4
Enter Ride ID: 1
Ride completed successfully!

===== RIDE SHARING PLATFORM =====
1. Add Rider
2. Add Driver
3. Request Ride
4. Complete Ride
5. Display Rides
6. Exit
Enter choice: 5

--- Ride Details ---
Ride ID     : 1
Rider       : hemanth
Driver      : raju
Pickup      : hyd
Destination : kmrl
Status      : COMPLETED

===== RIDE SHARING PLATFORM =====
1. Add Rider
2. Add Driver
3. Request Ride
4. Complete Ride
5. Display Rides
6. Exit
Enter choice: 6
Thank you!
