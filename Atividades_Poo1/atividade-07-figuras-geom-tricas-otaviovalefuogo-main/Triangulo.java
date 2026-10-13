public class Triangulo extends FiguraGeometrica {
    private double base;
    private double altura;
    private double lado1, lado2, lado3;

    public Triangulo(double base, double altura, double l1, double l2, double l3) {
        this.base = base;
        this.altura = altura;
        this.lado1 = l1;
        this.lado2 = l2;
        this.lado3 = l3;
    }

    @Override
    public double calcularArea() {
        return (this.base * this.altura) / 2;
    }

    @Override
    public double calcularPerimetro() {
        return this.lado1 + this.lado2 + this.lado3;
    }
}