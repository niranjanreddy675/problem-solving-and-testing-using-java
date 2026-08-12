import java.util.*;

abstract class Vehicle {
    abstract int calculateFare(double distance);
}

class Bike extends Vehicle {
    public int calculateFare(double distance) {
        return (int)(distance * 5);
    }
}

class Auto extends Vehicle {
    public int calculateFare(double distance) {
        return (int)(distance * 12);
    }
}

class Cab extends Vehicle {
    public int calculateFare(double distance) {
        return (int)(distance * 12);
    }
}

class Driver {
    String name;

    Driver(String name) {
        this.name = name;
    }
}

class Rider {
    String name;

    Rider(String name) {
        this.name = name;
    }
}

class Trip {
    Vehicle vehicle;

    Trip(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    int getFare(double distance) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Invalid distance");
        }

        return vehicle.calculateFare(distance);
    }
}

public class task6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double distance = sc.nextDouble();

            try {
                Vehicle vehicle;

                switch (type) {
                    case "Bike":
                        vehicle = new Bike();
                        break;

                    case "Auto":
                        vehicle = new Auto();
                        break;

                    case "Cab":
                        vehicle = new Cab();
                        break;

                    default:
                        throw new IllegalArgumentException("Invalid ride type");
                }

                Trip trip = new Trip(vehicle);

                System.out.println(trip.getFare(distance));

            } catch (Exception e) {
                System.out.println("Invalid Booking");
            }
        }

        sc.close();
    }
}