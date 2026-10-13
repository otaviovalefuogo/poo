public class Main {
    public static void main(String[] args) {
        TrafficLight semaforo = new TrafficLight();
        semaforo.advance(); 
        System.out.println("\nEMERGÊNCIA");
        semaforo.triggerEmergency();
        
        System.out.println("\nEMERGÊNCIA FINALIZADA");
        semaforo.advance();

        semaforo.advance();
        semaforo.advance(); 
        semaforo.advance();
    }
}