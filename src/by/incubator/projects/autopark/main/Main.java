package by.incubator.projects.autopark.main;

import by.incubator.projects.autopark.queue.MyQueue;
import by.incubator.projects.autopark.queue.MyStack;
import by.incubator.projects.autopark.service.MechanicService;
import by.incubator.projects.autopark.vehicles.Vehicle;
import by.incubator.projects.autopark.vehicles.VehicleCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String PATH = "src/by/incubator/projects/autopark/files/";

    public static void main(String[] args) {
        MechanicService mechanic = new MechanicService();
        VehicleCollection vehCollection = loadInfo();

        detectProblems(vehCollection, mechanic);
        repairVehicles(vehCollection, mechanic);
    }

    private static void repairVehicles(VehicleCollection vehCollection, MechanicService mechanic) {
        for (Vehicle vehicle : vehCollection.getVehicles()) {
            if (mechanic.isBroken(vehicle)) {
                mechanic.repair(vehicle);
            }
        }
    }

    private static void detectProblems(VehicleCollection vehCollection, MechanicService mechanic) {
        for (Vehicle vehicle : vehCollection.getVehicles()) {
            mechanic.detectBreaking(vehicle);
        }
    }

    public static VehicleCollection loadInfo() {
        VehicleCollection vehicleCollection = new VehicleCollection("types.csv","vehicles.csv", "rents.csv");

        vehicleCollection.loadTypes(PATH);
        vehicleCollection.loadVehicles(PATH);
        vehicleCollection.loadRents(PATH);

        return vehicleCollection;
    }
}

