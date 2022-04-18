package by.incubator.projects.autopark.main;

import by.incubator.projects.autopark.rent.Rent;
import by.incubator.projects.autopark.vehicles.Vehicle;
import by.incubator.projects.autopark.vehicles.VehicleCollection;
import by.incubator.projects.autopark.vehicles.VehicleType;

import java.util.List;

public class Main {

    public static final String TYPES_PATH = "src/by/incubator/projects/autopark/Java-main/";
    public static final String VEHICLES_PATH = "src/by/incubator/projects/autopark/Java-main/";
    public static final String RENTS_PATH = "src/by/incubator/projects/autopark/Java-main/";

    public static void main(String[] args) {
        VehicleCollection vehicleCollection = new VehicleCollection("types.csv","vehicles.csv", "rents.csv");

        vehicleCollection.loadTypes(TYPES_PATH);
        vehicleCollection.loadVehicles(VEHICLES_PATH);
        vehicleCollection.loadRents(RENTS_PATH);

        vehicleCollection.display();
    }

}

