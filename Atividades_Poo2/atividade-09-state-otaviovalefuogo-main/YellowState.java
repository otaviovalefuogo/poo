public class YellowState implements State {
    @Override
    public void handle(TrafficLight context) {
        System.out.println("Transitou para: Amarelo | Ação: Atenção | Tempo: " + getDuration() + "s");
        context.setState(this.nextState());
    }
    @Override
    public State nextState() {
        return new RedState();
    }
    @Override
    public int getDuration() {
        return 5;
    }
}