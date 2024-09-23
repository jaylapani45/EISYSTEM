package structural.decorator;
public class DecoratorPatternDemo {
    public static void main(String[] args) {
        WearableDevice smartwatch = new Smartwatch();
        WearableDevice healthSmartwatch = new HealthTracker(smartwatch);
        WearableDevice gpsHealthSmartwatch = new GPSModule(healthSmartwatch);

        gpsHealthSmartwatch.features();
    }
}
