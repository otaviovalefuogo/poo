package patterns.template;

import patterns.strategy.EstrategiaCobranca;
import patterns.factory.TicketComponente;

public abstract class ProcessadorSaida {
    

    private EstrategiaCobranca estrategia;

    public ProcessadorSaida(EstrategiaCobranca estrategia) {
        this.estrategia = estrategia;
    }

    public final void executarSaida(String placa, TicketComponente ticket) {
        long minutos = calcularTempo(placa);
        double valorCobranca = estrategia.calcular(minutos, ticket.getValorBase());
        double valorFinal = ticket.getValorTotal() + valorCobranca; 
        
        finalizarNoBanco(placa, valorFinal);
    }
    
    // Agora os métodos se comunicam!
    protected abstract long calcularTempo(String placa);
    protected abstract void finalizarNoBanco(String placa, double valorFinal);
}