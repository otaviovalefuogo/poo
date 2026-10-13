import java.util.ArrayList;
import java.util.List;

public class LoanProcessor {
  
    private List<LoanHandler> handlers = new ArrayList<>();

    
    public void addHandler(LoanHandler handler) {
        handlers.add(handler);
    }

    
    public boolean process(LoanRequest request) {
        for (LoanHandler handler : handlers) {
            
            boolean passed = handler.evaluate(request);
            
            
            if (!passed) {
                System.out.println("Processo interrompido. Empréstimo negado.");
                return false; 
            }
        }

        System.out.println("Processo concluído. Empréstimo aprovado com sucesso!");
        return true; 
    }
}