package by.incubator.projects.autopark;

import by.incubator.projects.autopark.engines.DieselEngine;
import by.incubator.projects.autopark.engines.ElectricalEngine;
import by.incubator.projects.autopark.engines.GasolineEngine;
import by.incubator.projects.autopark.vehicles.Vehicle;
import by.incubator.projects.autopark.vehicles.VehicleType;

public class Main {

    public static final int SIZE_TYPES = 4;
    public static final int SIZE_VEHICLES = 7;

    public static void main(String[] args) {

        double maxRatio;
        double averageRatio = 0.0d;

        VehicleType[] types = new VehicleType[SIZE_TYPES];

        types[0] = new VehicleType("Bus", 1.2d);
        types[1] = new VehicleType("Car", 1d);
        types[2] = new VehicleType("Rink", 1.5d);
        types[3] = new VehicleType("Tractor", 1.2d);

        types[SIZE_TYPES - 1].setTaxCoefficient(1.3d);

        maxRatio = types[0].getTaxCoefficient();

        for (VehicleType type: types) {
            type.display();

            double ratio = type.getTaxCoefficient();
            if (ratio > maxRatio) {
                maxRatio = ratio;
            }

            averageRatio += ratio / SIZE_TYPES;
        }

        System.out.println("Max tax ratio: " + maxRatio);
        System.out.println("Average tax ratio: " + averageRatio);

        Vehicle[] vehicles = new Vehicle[SIZE_VEHICLES];

        vehicles[0] = new Vehicle(types[0], new GasolineEngine(2, 8.1, 75)   ,"Volkswagen Crafter", "5427 AX-7", 2022 , 2015, 376000, Color.BLUE);
        vehicles[1] = new Vehicle(types[0], new GasolineEngine(2.18, 8.5, 75),"Volkswagen Crafter", "6427 AA-7", 2500 , 2014, 227010, Color.WHITE);
        vehicles[2] = new Vehicle(types[0], new ElectricalEngine(50, 150)                     ,"Electric Bus E321" , "6785 BA-7", 12080, 2019, 20451 , Color.GREEN);
        vehicles[3] = new Vehicle(types[1], new DieselEngine(1.6, 7.2, 55)   ,"Golf 5"            , "8682 AX-7", 1200 , 2006, 230451, Color.GRAY);
        vehicles[4] = new Vehicle(types[1], new ElectricalEngine(25, 70)                      ,"Tesla Model S 70D" , "0001 AA-7", 2200 , 2019, 10454 , Color.WHITE);
        vehicles[5] = new Vehicle(types[2], new DieselEngine(3.2, 25, 20)    ,"Hamm HD 12 VV"     , null       , 3000 , 2016, 122   , Color.YELLOW);
        vehicles[6] = new Vehicle(types[3], new DieselEngine(4.75, 20.1, 135),"МТЗ Беларус-1025.4", "1145 AB-7", 1200 , 2020, 109   , Color.RED);

        System.out.println("Unsorted vehicles: ");
        Helper.displayArr(vehicles);

        for (int i = 0; i < SIZE_VEHICLES; i++) {

            for (int j = 0; j < SIZE_VEHICLES - 1; j++) {
                if (vehicles[j].compareTo(vehicles[j + 1]) > 0) {

                    Vehicle temp = vehicles[j + 1];
                    vehicles[j + 1] = vehicles[j];
                    vehicles[j] = temp;
                }
            }
        }

        System.out.println("\nSorted vehicles: ");
        Helper.displayArr(vehicles);

        System.out.println("\nMax mileage car: ");
        System.out.println(findMaxMileageVehicle(vehicles));

        System.out.println("\nMin mileage car: ");
        System.out.println(findMinMileageVehicle(vehicles));

        System.out.println("\nThe following vehicles are equal:");
        displayEqual(vehicles);

        System.out.println("\nThe vehicles with Max kilometers:");
        System.out.println(findMaxKilometersVehicle(vehicles));
    }

    public static Vehicle findMinMileageVehicle(Vehicle[] vehicles) {
        int minMileage;
        Vehicle minMileageVehicle;

        minMileageVehicle = vehicles[0];
        minMileage = vehicles[0].getMileage();

        for (int i = 0; i < SIZE_VEHICLES; i++) {

            int mileage = vehicles[i].getMileage();

            if (mileage < minMileage) {
                minMileage = mileage;
                minMileageVehicle = vehicles[i];
            }
        }

        return minMileageVehicle;
    }

    public static Vehicle findMaxMileageVehicle(Vehicle[] vehicles) {
        int maxMileage;
        Vehicle maxMileageVehicle;

        maxMileageVehicle = vehicles[0];
        maxMileage = vehicles[0].getMileage();

        for (int i = 0; i < SIZE_VEHICLES; i++) {

            int mileage = vehicles[i].getMileage();

            if (mileage > maxMileage) {
                maxMileage = mileage;
                maxMileageVehicle = vehicles[i];
            }
        }

        return maxMileageVehicle;
    }


    public static void displayEqual(Vehicle[] vehicles) {
        int counter = 0;

        for (int i = 0; i < SIZE_VEHICLES; i++) {

            for (int j = i + 1; j < SIZE_VEHICLES; j++) {

                if (vehicles[i].equals(vehicles[j])) {
                    counter++;
                    System.out.println(vehicles[i] + " and " + vehicles[j]);
                }
            }
        }

        if (counter == 0) {
            System.out.println("Neither of vehicles are equal");
        }
    }

    public static Vehicle findMaxKilometersVehicle(Vehicle[] vehicles) {

        Vehicle biggestMaxKilometersVehicle = vehicles[0];
        double biggestMaxKilometers = vehicles[0].getEngine().getMaxKilometers();
        double maxKilometers;

        for (Vehicle vehicle : vehicles) {

            maxKilometers = vehicle.getEngine().getMaxKilometers();

            if (maxKilometers > biggestMaxKilometers) {

                biggestMaxKilometers = maxKilometers;
                biggestMaxKilometersVehicle = vehicle;
            }
        }

        return biggestMaxKilometersVehicle;
    }

    static class Helper {
        public static <T> void displayArr(T[] elements) {
            for (T element:
                    elements) {
                System.out.println(element.toString());
            }
            System.out.println();
        }
    }
}

