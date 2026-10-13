package patterns.factory;

public class TicketCarro implements TicketComponente {
    public String getDescricao() { return "Ticket Carro"; }
    public double getValorBase() { return 10.00; }
     @Override
public double getValorTotal() {
    return this.getValorBase(); 
}
}