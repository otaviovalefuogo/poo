public class GreenState implements State {
    @Override
    public void handle(TrafficLight context) {
        System.out.println("Transitou para: Verde | Ação: Avançar | Tempo: " + getDuration() + "s");
        context.setState(this.nextState());
    }

    @Override
    public State nextState() {
        return new YellowState();
    }

    @Override
    public int getDuration() {
        return 30;
    }
}