public class Principal {
    public static void main(String[] args) {
        Quadrado q = new Quadrado(5);       
        Circulo c = new Circulo(2);         
        Triangulo t = new Triangulo(6, 4, 6, 5, 5);

        System.out.println("Quadrado - Área: " + q.calcularArea() + ", Perímetro: " + q.calcularPerimetro());
        System.out.println("Círculo - Área: " + c.calcularArea() + ", Perímetro: " + c.calcularPerimetro());
        System.out.println("Triângulo - Área: " + t.calcularArea() + ", Perímetro: " + t.calcularPerimetro());


    }
}