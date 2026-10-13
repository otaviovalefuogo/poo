package patterns.strategy;

public class CobrancaPorHora implements EstrategiaCobranca {
    public double calcular(long min, double base) { return (Math.ceil(min / 60.0)) * base; }
}
