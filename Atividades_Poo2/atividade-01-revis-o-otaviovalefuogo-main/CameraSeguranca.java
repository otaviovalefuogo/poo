public class CameraSeguranca extends Dispositivo implements  Conectavel, Monitoravel, Atualizavel {
    protected boolean gravando;

    public CameraSeguranca(String id,String loc,boolean ligado,boolean gravando){
        super(id, loc, ligado);
        this.gravando=false;
    }
    @Override
    public void funcionar() {
        if (!estaLigado()) {
        System.out.println("Camera desligaao.");
        return;
    }
    System.out.println("Camera gravando e transitindo immagens");
    }

    @Override
    public void conectarWifi() {
        System.out.println("Camera conectada ao Wi-Fi.");
    }
    @Override
    public void desconectarWifi() {
        System.out.println("Camera desconectada ao Wi-Fi.");
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
    
    System.out.println("Camera monitorando");
    }
    @Override
    public void atualizarFirmware(){
        System.out.println("Atualizando...");
        this.ligado=false;
        this.ligado=true;
    }
}
