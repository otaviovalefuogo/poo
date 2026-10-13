package patterns.state;

public class VagaContexto {
    private int numero;
    private EstadoVaga estadoAtual;

    public VagaContexto(int numero, String estadoDoBanco) {
        this.numero = numero;
       
        if ("Livre".equalsIgnoreCase(estadoDoBanco)) {
            this.estadoAtual = new EstadoLivre();
        } else {
            this.estadoAtual = new EstadoOcupada();
        }
    }

    public void setEstado(EstadoVaga novoEstado) {
        this.estadoAtual = novoEstado;
    }
    
    public int getNumero() {
        return numero;
    }
    
    public String getCorParaInterface() {
        return estadoAtual.getCorVisual();
    }

  
    public void ocupar() {
        estadoAtual.ocuparVaga(this);
    }

    public void liberar() {
        estadoAtual.liberarVaga(this);
    }
}