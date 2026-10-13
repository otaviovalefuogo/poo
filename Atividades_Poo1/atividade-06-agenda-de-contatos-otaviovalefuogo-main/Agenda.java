import java.util.ArrayList;
public class Agenda {
    private ArrayList<Contato> contatos = new ArrayList<>();

    public void adicionarContato(Contato c) {
        contatos.add(c);
    }

    public void removerContato(String nome) {
        for (int i = 0; i < contatos.size(); i++) {
            if (contatos.get(i).getNome().equalsIgnoreCase(nome)) {
                contatos.remove(i);
                System.out.println("Contato removido.");
                return;
            }
        }
        System.out.println("Contato não encontrado.");
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Nenhum contato cadastrado.");
        } else {
            for (Contato c : contatos) {
                System.out.println(c);
            }
        }
    }
}
