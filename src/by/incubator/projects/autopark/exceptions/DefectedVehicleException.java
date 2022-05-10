package by.incubator.projects.autopark.exceptions;

public class DefectedVehicleException extends Exception {
    public DefectedVehicleException() {
    }

    public DefectedVehicleException(String message) {
        super(message);
    }

    public DefectedVehicleException(String message, Throwable cause) {
        super(message, cause);
    }

    public DefectedVehicleException(Throwable cause) {
        super(cause);
    }
}
