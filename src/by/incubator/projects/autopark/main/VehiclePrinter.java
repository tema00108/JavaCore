package by.incubator.projects.autopark.main;

import by.incubator.projects.autopark.vehicles.Vehicle;

import java.util.List;

public class VehiclePrinter {
    public static void print(List<Vehicle> vehicles, String message) {
        System.out.println(message);
        vehicles.stream().forEach(System.out::println);
        System.out.println();
    }

    public static void print(Vehicle vehicle, String message) {
        System.out.println(message);
        System.out.println(vehicle + "\n");
    }
}
