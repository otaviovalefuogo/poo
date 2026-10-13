public class TrafficLight {
    private State currentState;

    public TrafficLight() {
        this.currentState = new RedState(); 
    }
    public void setState(State state) {
        this.currentState = state;
    }
    public void advance() {
        currentState.handle(this);
    }
    public void triggerEmergency() {
        this.currentState = new EmergencyState();
        this.currentState.handle(this);
    }
}