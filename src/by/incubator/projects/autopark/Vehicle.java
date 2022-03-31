package by.incubator.projects.autopark;

import java.util.Objects;
import static by.incubator.projects.autopark.TechnicalSpecialist.*;

public class Vehicle implements Comparable<Vehicle>{
    private final VehicleType type;
    private final String modelName;
    private String registrationNumber;
    private int weight;
    private final int manufactureYear;
    private int mileage;
    private Color color;
    private int volume;

    public Vehicle(VehicleType type, String modelName, String registrationNumber, int weight, int manufactureYear, int mileage, Color color) {
        if (validateVehicleType(type)) {
            this.type = type;
        }
        else {
            this.type = new VehicleType();
        }
        if (validateModelName(modelName)) {
            this.modelName = modelName;
        }
        else {
            this.modelName = "";
        }
        if (validateRegistrationNumber(registrationNumber)) {
            this.registrationNumber = registrationNumber;
        }
        if (validateWeight(weight)) {
            this.weight = weight;
        }
        if (validateManufactureYear(manufactureYear)) {
            this.manufactureYear = manufactureYear;
        }
        else {
            this.manufactureYear = 0;
        }
        if (validateMileage(mileage)) {
            this.mileage = mileage;
        }
        if (validateColor(color)) {
            this.color = color;
        }
    }

    public VehicleType getType() {
        return type;
    }

    public String getModelName() {
        return modelName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (validateRegistrationNumber(registrationNumber)) {
            this.registrationNumber = registrationNumber;
        }
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        if (validateWeight(weight)) {
            this.weight = weight;
        }
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        if (validateMileage(mileage)) {
            this.mileage = mileage;
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        if (validateColor(color)) {
            this.color = color;
        }
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getCalcTaxPerMonth() {
        return (weight * 0.0013) + (type.getTaxCoefficient() * 30) + 5;
    }

    @Override
    public String toString() {
        return type +
                ", " + modelName +
                ", " + registrationNumber +
                ", " + weight +
                ", " + manufactureYear +
                ", " + mileage +
                ", " + color +
                ", " + volume +
                ", " + getCalcTaxPerMonth();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Vehicle that = (Vehicle) o;

        return (type.equals(that.type) && modelName.equals(that.modelName));
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, modelName);
    }

    public int compareTo(Vehicle obj) {
        if (manufactureYear > obj.manufactureYear) {
            return 1;
        }
        else if (manufactureYear < obj.manufactureYear) {
            return -1;
        }
        else {
            if (mileage > obj.mileage) {
                return 1;
            }
            else if (mileage < obj.mileage) {
                return -1;
            }
        }
        return 0;
    }
}
