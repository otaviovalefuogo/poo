package patterns.strategy;

public class CobrancaDiaria implements EstrategiaCobranca {
    private static final double FATOR_DIARIA = 6.0;

    @Override
    public double calcular(long minutos, double base) {
        long dias = Math.max(1, (long) Math.ceil(minutos / 1440.0));
        return dias * base * FATOR_DIARIA;
    }
}
