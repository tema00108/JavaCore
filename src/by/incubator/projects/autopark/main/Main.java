package by.incubator.projects.autopark.main;

import by.incubator.projects.autopark.queue.MyQueue;
import by.incubator.projects.autopark.vehicles.Vehicle;
import by.incubator.projects.autopark.vehicles.VehicleCollection;

public class Main {

    public static final String TYPES_PATH = "src/by/incubator/projects/autopark/Java-main/";
    public static final String VEHICLES_PATH = "src/by/incubator/projects/autopark/Java-main/";
    public static final String RENTS_PATH = "src/by/incubator/projects/autopark/Java-main/";

    public static void main(String[] args) {
        VehicleCollection vehColl = loadInfo();
        vehColl.display();

        Vehicle[] vehicles = vehColl.getVehicles().toArray(new Vehicle[]{});

        MyQueue<Vehicle> queue = new MyQueue<>(vehicles);
        washVehicles(queue);
    }
    public static VehicleCollection loadInfo() {
        VehicleCollection vehicleCollection = new VehicleCollection("types.csv","vehicles.csv", "rents.csv");

        vehicleCollection.loadTypes(TYPES_PATH);
        vehicleCollection.loadVehicles(VEHICLES_PATH);
        vehicleCollection.loadRents(RENTS_PATH);

        return vehicleCollection;
    }

    public static void washVehicles(MyQueue<Vehicle> queue) {
        int size = queue.size();

        for (int i = 0; i < size; i++) { //size returns 5 instead of 7
            System.out.println(queue.dequeue() + " -- вымыто");
        }
    }
}

