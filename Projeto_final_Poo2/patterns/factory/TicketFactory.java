package patterns.factory;

public class TicketFactory {
    public static TicketComponente criarTicket(String tipo) {
        if ("Carro".equalsIgnoreCase(tipo)) return new TicketCarro();
        if ("Moto".equalsIgnoreCase(tipo)) return new TicketMoto();
        
       
        throw new IllegalArgumentException("Tipo de veículo desconhecido: " + tipo);
    }
}
