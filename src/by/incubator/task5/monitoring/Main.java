package by.incubator.task5.monitoring;

public class Main {

    public static void main(String[] args) {

        MonitoringSystem generalMonitoring = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Monitoring of general indicators has started!");
            }
        };
        generalMonitoring.startMonitoring();

        MonitoringSystem errorMonitoring = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Bug tracking monitoring has started!");
            }
        };
        errorMonitoring.startMonitoring();

        MonitoringSystem securityMonitoring = new MonitoringSystem() {
            @Override
            public void startMonitoring() {
                System.out.println("Security monitoring has started!");
            }
        };
        securityMonitoring.startMonitoring();


    }
}
