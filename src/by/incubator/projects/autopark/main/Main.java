package by.incubator.projects.autopark.main;

import by.incubator.projects.autopark.rent.Rent;
import by.incubator.projects.autopark.exceptions.DefectedVehicleException;
import by.incubator.projects.autopark.service.MechanicService;
import by.incubator.projects.autopark.vehicles.Vehicle;
import by.incubator.projects.autopark.vehicles.VehicleCollection;
import by.incubator.projects.autopark.vehicles.VehicleType;

import java.util.List;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final String TYPES_PATH = "src/by/incubator/projects/autopark/files/";
    public static final String VEHICLES_PATH = "src/by/incubator/projects/autopark/files/";
    public static final String RENTS_PATH = "src/by/incubator/projects/autopark/files/";

    public static void main(String[] args) {
        MechanicService mechanic = new MechanicService();
        VehicleCollection vehicleCollection = loadInfo();

        detectProblems(vehicleCollection, mechanic);
        repairVehicles(vehicleCollection, mechanic);
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

        List<VehicleType> list =  vehicleCollection.loadTypes(TYPES_PATH);
        List<Vehicle> list3 = vehicleCollection.loadVehicles(VEHICLES_PATH);
        List<Rent> list2 = vehicleCollection.loadRents(RENTS_PATH);

        return vehicleCollection;
    }

    private static void print(Vehicle veh) {
        System.out.println("Most defects has");
        System.out.println(veh.getModelName() + ", " + veh.getRegistrationNumber());
    }
}

