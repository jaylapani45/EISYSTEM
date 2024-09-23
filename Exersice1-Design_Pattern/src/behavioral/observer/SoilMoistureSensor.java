public class SoilMoistureSensor extends Subject {
    private String moistureLevel;

    public void setMoistureLevel(String level) {
        this.moistureLevel = level;
        notifyObservers(moistureLevel);
    }

    public String getMoistureLevel() {
        return moistureLevel;
    }
}
