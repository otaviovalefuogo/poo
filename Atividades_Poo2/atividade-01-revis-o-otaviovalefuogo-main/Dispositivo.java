public abstract class Dispositivo {
    protected String id;
    protected String loc;
    protected Boolean ligado=false;

    public Dispositivo(String id,String loc,boolean ligado){
        this.id=id;
        this.loc=loc;
        this.ligado=ligado;
    }

    public void ligar(){
        this.ligado=true;
        System.out.println("Dispositivo ligado");
    }
    public void desligar(){
        this.ligado=false;
        System.out.println("Dispositivo desligado");
    }
    public void exibirStatus(){
        System.out.println("O id do dispositivo é:"+id);
        System.out.println("A localizacao do dispositivo é:"+loc);
        if(ligado){
            System.out.println("O dispositivo esta ligado");
        }
        else{
            System.out.println("O dispositivo esta desligado");
        }
    }
    public boolean estaLigado(){
        return this.ligado;
    }
    public abstract void funcionar();
}

