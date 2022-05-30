package by.incubator.projects.autopark.main;

import by.incubator.projects.autopark.vehicles.Vehicle;
import by.incubator.projects.autopark.vehicles.VehicleCollection;

import java.util.*;
import java.util.stream.Collectors;

public class StreamAPIDemo {
    public static final String PATH = "src/by/incubator/projects/autopark/files/";
    public static final String MESSAGE_VOLKSWAGEN = "The following vehicles are Volkswagen's:";
    public static final String MESSAGE_MAX_YEAR_VOLKSWAGEN = "The following vehicle is the oldest Volkswagen's:";

    public static void main(String[] args) {
        List<Vehicle> vehicles = initVehicles();

        List<Vehicle> volkswagens = findVolkswagens(vehicles);
        VehiclePrinter.print(volkswagens, MESSAGE_VOLKSWAGEN);

        Vehicle maxYearVolkswagen = findMaxYear(volkswagens);
        VehiclePrinter.print(maxYearVolkswagen, MESSAGE_MAX_YEAR_VOLKSWAGEN);

        washVehicles(vehicles);
        vehiclesToGarage(vehicles);
    }

    private static List<Vehicle> initVehicles() {
        VehicleCollection vehCollection = new VehicleCollection("types.csv","vehicles.csv", "rents.csv");
        vehCollection.loadTypes(PATH);

        return vehCollection.loadVehicles(PATH);
    }

    private static void vehiclesToGarage(List<Vehicle> vehicles) {
        Deque<Vehicle> stack = new ArrayDeque<>();
        vehicles.forEach(stack::push);
        stack.stream().forEach(veh -> System.out.println(veh + " -- drove out from garage"));
    }

    private static void washVehicles(List<Vehicle> vehicles) {
        vehicles.stream().forEach(veh -> System.out.println(veh + "-- washed up"));
    }

    private static Vehicle findMaxYear(List<Vehicle> vehicles) {
        Optional<Vehicle> maxYear = vehicles.stream().max(Comparator.comparingInt(Vehicle::getManufactureYear));
        return maxYear.get();
    }

    private static List<Vehicle> findVolkswagens(List<Vehicle> vehicles) {
        return vehicles.stream()
                .filter(car -> car.getModelName().contains("Volkswagen"))
                .collect(Collectors.toList());
    }
}

