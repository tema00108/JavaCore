package by.incubator.projects.autopark;

public class VehicleType {
    private String typeName;
    private double taxRatio;

    public VehicleType() {}

    public VehicleType(String name, double taxRatio) {
        this.typeName = name;
        this.taxRatio = taxRatio;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public double getTaxRatio() {
        return taxRatio;
    }

    public void setTaxRatio(double taxRatio) {
        this.taxRatio = taxRatio;
    }

    public void display() {
        System.out.println("typeName = " + typeName + '\n' +
                           "taxRatio = " + taxRatio);
    }

    public String getString() {
        return typeName + ',' + "\"" + taxRatio + "\"";
    }


}
