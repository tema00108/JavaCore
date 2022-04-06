package by.incubator.projects.autopark.vehicles;

import by.incubator.projects.autopark.Color;
import by.incubator.projects.autopark.engines.ElectricalEngine;
import by.incubator.projects.autopark.engines.Startable;

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
    private Startable engine;

    public Vehicle(VehicleType type, Startable engine, String modelName, String registrationNumber, int weight, int manufactureYear, int mileage, Color color) {
//        if (!validateVehicleType(type)) {
//            throw new IllegalArgumentException("Vehicle type: " + type);
//        }
//        if (!validateModelName(modelName)) {
//            throw new IllegalArgumentException("Model name: " + modelName);
//        }
//        if (!validateRegistrationNumber(registrationNumber)) {
//            throw new IllegalArgumentException("Registration number: " + registrationNumber);
//        }
//        if (!validateWeight(weight)) {
//            throw new IllegalArgumentException("Weight: " + weight);
//        }
//        if (!validateManufactureYear(manufactureYear)) {
//            throw new IllegalArgumentException("Manufacture year: " + manufactureYear);
//        }
//        if (!validateMileage(mileage)) {
//            throw new IllegalArgumentException("Mileage: " + mileage);
//        }
//        if (!validateColor(color)) {
//            throw new IllegalArgumentException("Color: " + color);
//        }
        if (!validateVehicleType(type)) {
            this.type = type;
        }
        else {
            this.type = new VehicleType();
        }
        if (validateModelName(modelName)) {
            this.modelName = modelName;
        }
        else {
            this.modelName = "Model";
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
            this.manufactureYear = LOWER_LIMIT_MANUFACTURE_YEAR;
        }
        if (validateMileage(mileage)) {
            this.mileage = mileage;
        }
        if (validateColor(color)) {
            this.color = color;
        }

        this.engine = engine;
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

    public Startable getEngine() {
        return engine;
    }

    public void setEngine(Startable engine) {
        this.engine = engine;
    }

    public double getCalcTaxPerMonth() {

        return (weight * 0.0013) + (type.getTaxCoefficient() * engine.getTaxPerMonth() * 30) + 5;
    }

    @Override
    public String toString() {
        return type.getTypeName() +
                ", " + modelName +
                ", " + registrationNumber +
                ", " + weight +
                ", " + manufactureYear +
                ", " + mileage +
                ", " + color +
                ", " + volume +
                ", " + getCalcTaxPerMonth() +
                ", " + engine;
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


