import java.time.LocalDateTime;

public class LoggerDisplay implements Observer {

    @Override
    public void update(float temperature, float humidity, float pressure) {
        log(temperature, humidity, pressure);
    }

    public void log(float temperature, float humidity, float pressure) {
        System.out.println(" \n---LOGGER  DISPLAY---");
        System.out.println("[LOG: " + LocalDateTime.now() + "] Update received. Temp: " + temperature + ", Humidity: " + humidity + ", Pressure: " + pressure);
    }
}