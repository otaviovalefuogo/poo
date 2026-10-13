package patterns.factory;

public class TicketMoto implements TicketComponente {
    public String getDescricao() { return "Ticket Moto"; }
    public double getValorBase() { return 5.00; }
    @Override
public double getValorTotal() {
    return this.getValorBase();
}
}