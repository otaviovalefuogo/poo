public class EmergencyState implements State {
    @Override
    public void handle(TrafficLight context) {
        System.out.println("Transitou para: Emergência (Piscando) | Ação: Ceder passagem | Tempo: " + getDuration() + "s");
        context.setState(this.nextState());
    }

    @Override
    public State nextState() {
        return new RedState(); 
    }
    @Override
    public int getDuration() {
        return -1;
    }
}