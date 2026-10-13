public class Termostato extends Dispositivo implements  Conectavel, Monitoravel {
    protected int temperaturaAlvo;
    protected int temperaturaAtual;

    public Termostato(String id,String loc,boolean ligado,int temperaturaAlvo,int temperaturaAtual){ 
        super(id, loc, ligado);
        this.temperaturaAlvo=temperaturaAlvo;
        this.temperaturaAtual=temperaturaAtual;
    }
    @Override
    public void funcionar() {
        if (!estaLigado()) {
        System.out.println("Termostato desligado. Ligue-o para ajustar a temperatura.");
        return;
    }

    System.out.println("Monitorando o ambiente...");

    if (temperaturaAtual < temperaturaAlvo) {
        System.out.println("Aquecendo a sala de " + temperaturaAtual + " para " + temperaturaAlvo + " graus.");
        this.temperaturaAtual = temperaturaAlvo;
        
    } else if (temperaturaAtual > temperaturaAlvo) {
        System.out.println("Resfriando a sala de " + temperaturaAtual + " para " + temperaturaAlvo + " graus.");
        this.temperaturaAtual = temperaturaAlvo;
        
    } else {
        System.out.println("Status: Temperatura ideal de " + temperaturaAlvo + " graus mantida em modo de espera.");
    }

    }

    @Override
    public void conectarWifi() {
        System.out.println("Termoestato conectado ao Wi-Fi.");
    }
    @Override
    public void desconectarWifi() {
        System.out.println("Termoestato desconectado ao Wi-Fi.");
    }
    @Override
    public void gerarRelatorio() {
    System.out.println("ID do Dispositivo: " + this.id);
    System.out.println("Localizacao: " + this.loc);
    if (estaLigado()) {
        System.out.println("Esta ligado");
    } else {
        System.out.println("Esta desligado");
    }
    
    System.out.println("Temperatura Atual: " + this.temperaturaAtual + "°C");
    System.out.println("Temperatura Alvo: " + this.temperaturaAlvo + "°C");
    }
    

}
