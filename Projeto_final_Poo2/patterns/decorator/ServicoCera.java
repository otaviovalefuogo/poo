package patterns.decorator;
import patterns.factory.TicketComponente;

public class ServicoCera extends TicketDecorator {
    
    public ServicoCera(TicketComponente t) { 
        super(t); 
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + Cera Especial";
    }

    @Override
    public double getValorTotal() {
        return super.getValorTotal() + 15.00;
    }
}