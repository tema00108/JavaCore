package by.incubator.projects.autopark;

import java.util.Objects;

public class Vehicle implements Comparable<Vehicle>{
    VehicleType type;
    String modelName;
    String registrationNumber;
    int weight;
    int manufactureYear;
    int mileage;
    Color color;
    int volume;

    public Vehicle() {
    }

    public Vehicle(VehicleType type, String modelName, String registrationNumber, int weight, int manufactureYear, int mileage, Color color) {
        this.type = type;
        this.modelName = modelName;
        this.registrationNumber = registrationNumber;
        this.weight = weight;
        this.manufactureYear = manufactureYear;
        this.mileage = mileage;
        this.color = color;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(int manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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
        return getClass().getSimpleName() +
                "{type=" + type +
                ", modelName='" + modelName + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", weight=" + weight +
                ", manufactureYear=" + manufactureYear +
                ", mileage=" + mileage +
                ", color=" + color +
                ", volume=" + volume +
                '}';
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
        return Objects.hash(type, modelName, registrationNumber, weight, manufactureYear, mileage, color, volume);
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
