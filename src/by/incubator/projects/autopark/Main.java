package by.incubator.projects.autopark;

public class Main {
    public static void main(String[] args) {
        final int SIZE_TYPES = 4;
        final int SIZE_VEHICLES = 7;

        int maxMileage;
        int minMileage;

        double maxRatio;
        double averageRatio = 0.0d;

        Vehicle maxMileageVehicle;
        Vehicle minMileageVehicle;

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

        vehicles[0] = new Vehicle(types[0], "Volkswagen Crafter", "5427 AX-7", 2022 , 2015, 376000, Color.BLUE);
        vehicles[1] = new Vehicle(types[0], "Volkswagen Crafter", "6427 AA-7", 2500 , 2014, 227010, Color.WHITE);
        vehicles[2] = new Vehicle(types[0], "Electric Bus E321" , "6785 BA-7", 12080, 2019, 20451 , Color.GREEN);
        vehicles[3] = new Vehicle(types[1], "Golf 5"            , "8682 AX-7", 1200 , 2006, 230451, Color.GRAY);
        vehicles[4] = new Vehicle(types[1], "Tesla Model S 70D" , "0001 AA-7", 2200 , 2019, 10454 , Color.WHITE);
        vehicles[5] = new Vehicle(types[2], "Hamm HD 12 VV"     , null       , 3000 , 2016, 122   , Color.YELLOW);
        vehicles[6] = new Vehicle(types[3], "МТЗ Беларус-1025.4", "1145 AB-7", 1200 , 2020, 109   , Color.RED);


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

        System.out.println("Sorted vehicles: ");
        Helper.displayArr(vehicles);

        maxMileageVehicle = vehicles[0];
        minMileageVehicle = vehicles[0];
        maxMileage = vehicles[0].getMileage();
        minMileage = maxMileage;

        for (int i = 0; i < SIZE_VEHICLES; i++) {

            int mileage = vehicles[i].getMileage();

            if (mileage > maxMileage) {
                maxMileage = mileage;
                maxMileageVehicle = vehicles[i];
            }
            else if (mileage < minMileage) {
                minMileage = mileage;
                minMileageVehicle = vehicles[i];
            }
        }

        System.out.println("Max mileage car: ");
        System.out.println(maxMileageVehicle.toString());

        System.out.println("\nMin mileage car: ");
        System.out.println(minMileageVehicle.toString());
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

