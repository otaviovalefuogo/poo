public interface State {
    void handle(TrafficLight context); 
    State nextState(); 
    int getDuration(); 
}