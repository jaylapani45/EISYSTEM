package devices;

public class Thermostat extends SmartDevice {
    private int temperature;

    public Thermostat(String id) {
        super(id, "Thermostat");
        this.temperature = 70; // Default temperature
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        System.out.println("Thermostat " + getId() + " is set to " + temperature + " degrees.");
    }

    public int getTemperature() {
        return temperature;
    }

    @Override
    public String getStatusReport() {
        return "Thermostat " + getId() + " is set to " + temperature + " degrees.";
    }
}
