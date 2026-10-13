public class Email {
    private String rotulo;
    private String endereco;

    public Email(String rotulo, String endereco) {
        this.rotulo = rotulo;
        this.endereco = endereco;
    }

    public String toString() {
        return rotulo + ": " + endereco;
    }
}
