// Exemplo do ServicoLavagem (Faça o mesmo para Cera, mudando os valores e texto)
package patterns.decorator;
import patterns.factory.TicketComponente;

public class ServicoLavagem extends TicketDecorator {
    public ServicoLavagem(TicketComponente t) { super(t); }

    @Override
    public String getDescricao() { 
        return super.getDescricao() + " + Lavagem";
    }

    @Override
    public double getValorTotal() { 
        return super.getValorTotal() + 30.00; 
}
}