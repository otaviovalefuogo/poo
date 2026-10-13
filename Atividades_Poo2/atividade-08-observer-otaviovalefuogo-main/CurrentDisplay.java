public class CurrentDisplay implements Observer {
    private float temperature;
    private float humidity;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }

    public void display() {
        System.out.println("\n---CURRENT DISPLAY--- ");
        System.out.println("Current conditions: " + temperature + "°C e " + humidity + "% humidity.");
    }
}