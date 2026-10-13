public class Telefone {
    private String rotulo;
    private String numero;

    public Telefone(String rotulo, String numero) {
        this.rotulo = rotulo;
        this.numero = numero;
    }
    public String toString() {
        return rotulo + ": " + numero;
    }
}
