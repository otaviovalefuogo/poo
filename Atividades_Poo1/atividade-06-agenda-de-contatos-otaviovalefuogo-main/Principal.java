public class Principal {
    public static void main(String[] args) {
        Agenda minhaAgenda = new Agenda();

        Contato c1 = new Contato("Alice");
        c1.addTelefone("Celular", "12345-6789");
        c1.addEmail("Pessoal", "alice@gmail.com");
        minhaAgenda.adicionarContato(c1);

        Contato c2 = new Contato("Bob");
        c2.addTelefone("Trabalho", "98765-4321");
        c2.addEmail("Trabalho", "bob@gmail.com");
        minhaAgenda.adicionarContato(c2);

        minhaAgenda.listarContatos();
}
}
