public class LampadaInteligente extends Dispositivo implements Conectavel, Agendavel {
    protected String cor;
    protected int intensidade;

    public LampadaInteligente(String id,String loc,boolean ligado,String cor,int intensidade){
        super(id,loc,ligado);
        this.cor = cor;
        this.intensidade = intensidade;
    }
    @Override
    public void funcionar() {
        if (!estaLigado()) {
        System.out.println("Lampada desligada.");
        return;
        }
    System.out.println("A lampada esta iluminando na cor " + cor + " com intensidade " + intensidade);
    }
    @Override
    public void conectarWifi() {
        System.out.println("Lampada conectada ao Wi-Fi.");
    }
    @Override
    public void desconectarWifi() {
        System.out.println("Lampada desconectada do Wi-Fi.");
    }
    @Override
    public void agendarAtividade() {
        System.out.println("Horario de ligar a lampada agendado.");
    }

    @Override
    public void cancelarAgendamento() {
        System.out.println("Agendamento da lampada cancelado.");
    }
}

