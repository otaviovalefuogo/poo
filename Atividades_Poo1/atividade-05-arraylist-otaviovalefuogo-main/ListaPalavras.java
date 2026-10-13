import java.util.ArrayList;
import java.util.List;

public class ListaPalavras {

    private List<String> palavras;

    public ListaPalavras() {
        this.palavras = new ArrayList<>();
    }

    public void adiciona(String palavra) {
        this.palavras.add(palavra);
        System.out.println(palavra + "' adicionada.");
    }

    public void remove(String palavra) {
        System.out.println("Removendo todas as ocorrências de '" + palavra + "'...");
        
        boolean removeu = false;
        while (this.palavras.remove(palavra)) {
            removeu = true;
        }
        
        if (!removeu) {
            System.out.println("Palavra não encontrada.");
        }
    }

    public void remove(int posicao) {
        if (posicao >= 0 && posicao < this.palavras.size()) {
            String removida = this.palavras.remove(posicao);
            System.out.println("Palavra '" + removida + "' na posição " + posicao + " removida.");
        } else {
            System.out.println("Posição inválida: " + posicao);
        }
    }

    public void imprime() {
        System.out.println("--- Lista de Palavras ---");
        if (palavras.isEmpty()) {
            System.out.println("(Lista vazia)");
            return;
        }
        
        for (String palavra : this.palavras) {
            System.out.println(palavra);
        }
    }

    public int conta(String palavra) {
        int contador = 0;
        
        for (String elemento : this.palavras) {
            if (elemento.equals(palavra)) {
                contador++;
            }
        }
        return contador;
    }
}