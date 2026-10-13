package patterns.state;

public interface EstadoVaga {
    void ocuparVaga(VagaContexto vaga);
    void liberarVaga(VagaContexto vaga);
    String getCorVisual();
}