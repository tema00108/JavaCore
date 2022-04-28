package by.incubator.projects.autopark.main;

import by.incubator.projects.autopark.exceptions.DefectedVehicleException;
import by.incubator.projects.autopark.service.MechanicService;
import by.incubator.projects.autopark.vehicles.Vehicle;
import by.incubator.projects.autopark.vehicles.VehicleCollection;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String PATH = "src/by/incubator/projects/autopark/files/";

    public static void main(String[] args) {
        MechanicService mechanic = new MechanicService();
        VehicleCollection vehCollection = loadInfo();

        detectProblems(vehCollection, mechanic);
        repairVehicles(vehCollection, mechanic);

        startRent(vehCollection, mechanic);
    }

    private static void startRent(VehicleCollection vehCollection, MechanicService mechanic) {
        try {
            for (Vehicle vehicle : vehCollection.getVehicles()) {
                if (mechanic.isBroken(vehicle)) {
                    mechanic.repair(vehicle);
                    throw new DefectedVehicleException();
                }
            }
        } catch (DefectedVehicleException e) {
            System.out.println();
        }
    }

    private static void repairVehicles(VehicleCollection vehCollection, MechanicService mechanic) {
        for (Vehicle vehicle : vehCollection.getVehicles()) {
            if (mechanic.isBroken(vehicle)) {
                mechanic.repair(vehicle);
            }
        }
    }

    private static void detectProblems(VehicleCollection vehCollection, MechanicService mechanic) {
        int defects;
        int maxDefects = 0;
        Vehicle mostDefects = new Vehicle();

        for (Vehicle vehicle : vehCollection.getVehicles()) {
            mechanic.detectBreaking(vehicle);
            defects = mechanic.countDefects(vehicle);

            if (defects > maxDefects) {
                mostDefects = vehicle;
            }
        }

        print(mostDefects);
    }

    private static VehicleCollection loadInfo() {
        VehicleCollection vehicleCollection = new VehicleCollection("types.csv","vehicles.csv", "rents.csv");

        vehicleCollection.loadTypes(PATH);
        vehicleCollection.loadVehicles(PATH);
        vehicleCollection.loadRents(PATH);

        return vehicleCollection;
    }

    private static void print(Vehicle veh) {
        System.out.println(veh.getModelName() + ", " + veh.getRegistrationNumber());
    }
}

