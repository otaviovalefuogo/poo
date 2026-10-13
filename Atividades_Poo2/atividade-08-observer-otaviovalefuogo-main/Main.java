public class Main {
    public static void main(String[] args) {
        
        WeatherStation Weather = new WeatherStation();


        CurrentDisplay CurrentDisplay = new CurrentDisplay();
        StatisticsDisplay StatisticsDisplay = new StatisticsDisplay();
        ForecastDisplay ForecastDisplay = new ForecastDisplay();
        LoggerDisplay LoggerDisplay = new LoggerDisplay();

  
        Weather.registerObserver(CurrentDisplay);
        Weather.registerObserver(StatisticsDisplay);
        Weather.registerObserver(ForecastDisplay);
        Weather.registerObserver(LoggerDisplay);

        Weather.setMeasurements(25.0f, 65.0f, 30.4f);
        Weather.setMeasurements(27.0f, 70.0f, 29.2f);

        Weather.removeObserver(StatisticsDisplay); 
        
        Weather.setMeasurements(22.0f, 90.0f, 29.2f);
    }
}