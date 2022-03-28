package by.incubator.projects.autopark;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 4;

        double maxRatio;
        double sumOfRatio;
        double averageRatio;

        VehicleType[] types = new VehicleType[SIZE];

        types[0] = new VehicleType("Bus", 1.2d);
        types[1] = new VehicleType("Car", 1d);
        types[2] = new VehicleType("Rink", 1.5d);
        types[3] = new VehicleType("Tractor", 1.2d);

        for (VehicleType type:
             types) {
            type.display();
        }

        types[SIZE - 1].setTaxRatio(1.3d);

        maxRatio = types[0].getTaxRatio();
        for (VehicleType type:
             types) {
            double ratio = type.getTaxRatio();

            if (ratio > maxRatio) {
                maxRatio = ratio;
            }
        }

        System.out.println("Max tax ratio: " + maxRatio);

        sumOfRatio = 0;
        for (VehicleType type:
                types) {
            sumOfRatio += type.getTaxRatio();
        }

        averageRatio = sumOfRatio / SIZE;
        System.out.println("Average tax ratio: " + averageRatio);

        maxRatio = types[0].getTaxRatio();
        sumOfRatio = 0;

        for (VehicleType type:
                types) {
            type.display();

            double ratio = type.getTaxRatio();
            if (ratio > maxRatio) {
                maxRatio = ratio;
            }

            sumOfRatio += ratio;
        }

        System.out.println("Max tax ratio: " + maxRatio);

        averageRatio = sumOfRatio / SIZE;
        System.out.println("Average tax ratio: " + averageRatio);

    }
}
