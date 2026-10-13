import java.util.ArrayList;
public class Contato {
    private String nome;
    private ArrayList<Telefone> telefones= new ArrayList<>();
    private ArrayList<Email> emails= new ArrayList<>();

    public Contato(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void addTelefone(String rotulo, String numero) {
        telefones.add(new Telefone(rotulo,numero));
    }
    public void addEmail(String rotulo, String endereco) {
        emails.add(new Email(rotulo,endereco));
    }

    public String toString() {
        String toString = "Nome: " + nome + "Telefones:\n";
        for (int i = 0; i < telefones.size(); i++) {
            toString += "  " + telefones.get(i).toString() + "\n";
        }
        toString += "Emails:\n";
        for (int i = 0; i < emails.size(); i++) {
            toString += "  " + emails.get(i).toString() + "\n";
        }
        return toString;
       
    }
}
