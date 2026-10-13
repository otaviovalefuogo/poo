package patterns.decorator;
import patterns.factory.TicketComponente;

public abstract class TicketDecorator implements TicketComponente {
   
    private TicketComponente ticket; 

    public TicketDecorator(TicketComponente ticket) {
        this.ticket = ticket;
    }

    @Override
    public String getDescricao() { return ticket.getDescricao(); }
    @Override
    public double getValorTotal() { return ticket.getValorTotal(); }
    @Override
    public double getValorBase() { return ticket.getValorBase(); }
}