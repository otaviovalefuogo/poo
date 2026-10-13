package patterns.state;

public class EstadoOcupada implements EstadoVaga {
    @Override
    public void ocuparVaga(VagaContexto vaga) {
        System.out.println("ERRO: A vaga " + vaga.getNumero() + " já está ocupada!");
    }

    @Override
    public void liberarVaga(VagaContexto vaga) {
        System.out.println("Vaga " + vaga.getNumero() + " foi LIBERADA.");
        vaga.setEstado(new EstadoLivre());
    }

    @Override
    public String getCorVisual() {
        return "VERMELHO";
    }
}