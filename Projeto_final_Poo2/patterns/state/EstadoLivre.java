package patterns.state;

public class EstadoLivre implements EstadoVaga {
    @Override
    public void ocuparVaga(VagaContexto vaga) {
        System.out.println("Vaga " + vaga.getNumero() + " agora está OCUPADA.");
        vaga.setEstado(new EstadoOcupada());
    }

    @Override
    public void liberarVaga(VagaContexto vaga) {
        System.out.println("A vaga já está livre!");
    }

    @Override
    public String getCorVisual() {
        return "VERDE"; 
    }
}