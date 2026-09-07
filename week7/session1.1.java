class ParkingSystem {
    int big;
    int medium;
    int small;

    // Constructor
    ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    // Add a car
    boolean addCar(int carType) {

        if (carType == 1) {
            if (big > 0) {
                big--;
                return true;
            }
        } 
        else if (carType == 2) {
            if (medium > 0) {
                medium--;
                return true;
            }
        } 
        else if (carType == 3) {
            if (small > 0) {
                small--;
                return true;
            }
        }

        return false;
    }
}

public class Main {
    public static void main(String[] args) {

        ParkingSystem parking = new ParkingSystem(1, 1, 0);

        System.out.println(parking.addCar(1)); // true
        System.out.println(parking.addCar(2)); // true
        System.out.println(parking.addCar(3)); // false
        System.out.println(parking.addCar(1)); // false
    }
}
Input
["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
[[1, 1, 0], [1], [2], [3], [1]]
Output
[null, true, true, false, false]
