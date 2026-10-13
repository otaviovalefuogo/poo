public class StatisticsDisplay implements Observer {
    private float maxTemp = 0.0f;
    private float minTemp = 200.0f; 
    private float tempSum = 0.0f;
    private int numReadings = 0;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        tempSum += temperature;
        numReadings++;

        if (temperature > maxTemp) {
            maxTemp = temperature;
        }
        if (temperature < minTemp) {
            minTemp = temperature;
        }
        display();
    }

    public void display() {
        System.out.println("\n---Statistics Display---");
        System.out.println("Temperatur avg/max/min: " + (tempSum / numReadings) + "/" + maxTemp + "/" + minTemp);
    }
}