public class TestePalavras {

    public static void main(String[] args) {
        ListaPalavras Lista = new ListaPalavras();
        
        Lista.adiciona("Java");
        Lista.adiciona("Python");
        Lista.adiciona("Java");
        Lista.adiciona("C+");
        Lista.adiciona("Java");
        
        Lista.imprime(); 

        System.out.println("Número de ocorrências de 'Java': " + Lista.conta("Java"));
        System.out.println("Número de ocorrências de 'Ruby': " + Lista.conta("Ruby"));

        Lista.remove(1); 
        Lista.imprime();

        Lista.remove("Java");
        Lista.imprime();

        Lista.remove("C+");
        Lista.imprime();
    }
}