import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        System.out.println("INICIANDO CASA INTELIGENTE \n");

        List<Dispositivo> listaDispositivos = new ArrayList<>();

        LampadaInteligente lampada = new LampadaInteligente("LMP-01", "Sala de Estar", false, "Branca", 100);
        Termostato termostato = new Termostato("TRM-01", "Quarto", false, 22, 20); 
        CameraSeguranca camera = new CameraSeguranca("CAM-01", "Portao Pincipal", false,false);

        listaDispositivos.add(lampada);
        listaDispositivos.add(termostato);
        listaDispositivos.add(camera);
        
        for (Dispositivo d : listaDispositivos) {
            
            System.out.println(">> Acessando dispossitivo ID: ");
            d.exibirStatus();

            d.ligar(); 
            d.funcionar(); 
            d.exibirStatus();
        }
    }
}
