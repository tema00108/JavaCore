package by.incubator.projects.autopark;

import java.util.Objects;

public class TechnicalSpecialist {
    public static final int LOWER_LIMIT_MANUFACTURE_YEAR = 1886;

    public static boolean validateManufactureYear(int year) {
        return year >= LOWER_LIMIT_MANUFACTURE_YEAR && year < 10000;
    }

    public static boolean validateMileage(int mileage) {
        return mileage >= 0;
    }

    public static boolean validateWeight(int weight) {
        return weight >= 0;
    }

    static public boolean validateColor(Color color) {
        return color != null; //checking color?
    }

    public static boolean validateVehicleType(VehicleType type) {
        String name = type.getTypeName();

        if (name != null && !(name.equals(""))){
            return type.getTaxCoefficient() > 0.0;
        }

        return false;
    }

    public static boolean validateRegistrationNumber(String number) {
        if (number == null || number.length() != 9) {
            return false;
        }

        char[] chars = number.toCharArray();

        for (int i = 0; i < 4; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                return false;
            }
        }

        if (chars[4] != ' ') {
            return false;
        }

        for (int i = 5; i < 7; i++) {
            if (chars[i] < 'A' || chars[i] > 'Z') {
                return false;
            }
        }

        if (chars[7] != '-') {
            return false;
        }

        return chars[8] >= '0' && chars[8] <= '9';
    }

    public static boolean validateModelName(String name) {
        return name != null && !name.equals("");
    }
}
