public class ForecastDisplay implements Observer {
    private float currentPressure = 29.92f;  
    private float lastPressure;

    @Override
    public void update(float temperature, float humidity, float pressure) {
        lastPressure = currentPressure; 
        currentPressure = pressure;  
        display(); 
    }

    public void display() {
        System.out.println("\n---Forecast Display---");
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("The weather is improving");
        } else if (currentPressure == lastPressure) {
            System.out.println("The weather will remain the same");
        } else {
            System.out.println("Warning: rain and cold weather are expected");
        }
    }
}