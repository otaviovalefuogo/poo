package patterns.template;
import patterns.strategy.EstrategiaCobranca;

public class ProcessadorSaidaPadrao extends ProcessadorSaida {

    public ProcessadorSaidaPadrao(EstrategiaCobranca estrategia) {
        super(estrategia);
    }

    @Override
    protected long calcularTempo(String placa) {
       
        System.out.println("Calculando tempo no banco para a placa: " + placa);
        return 120; 
    }

    @Override
    protected void finalizarNoBanco(String placa, double valorFinal) {
       
        System.out.println("Atualizando status e salvando... Placa: " + placa + " | R$ " + valorFinal);
    }
}