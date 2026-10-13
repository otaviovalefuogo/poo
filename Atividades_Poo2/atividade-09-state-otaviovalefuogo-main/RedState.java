public class RedState implements State {
    @Override
    public void handle(TrafficLight context) {
        System.out.println("Transitou para: Vermelho | Ação: Parar | Tempo: " + getDuration() + "s");
        context.setState(this.nextState());
    }
    @Override
    public State nextState() {
        return new GreenState();
    }

    @Override
    public int getDuration() {
        return 20;
    }
}