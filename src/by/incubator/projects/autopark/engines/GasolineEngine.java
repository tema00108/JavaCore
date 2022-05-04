package by.incubator.projects.autopark.engines;

public class GasolineEngine extends CombustionEngine {

    public GasolineEngine(double engineCapacity, double fuelConsumptionPer100, double fuelTankCapacity) {

        super("Gasoline", 1.1, engineCapacity, fuelConsumptionPer100, fuelTankCapacity);
    }

    @Override
    public String toString() {
        return "Gasoline";
    }
}
