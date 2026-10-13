package controller;

import dao.EstacionamentoDAO;
import dao.TicketDAO;
import dao.VagaDAO;
import patterns.decorator.ServicoCera;
import patterns.decorator.ServicoLavagem;
import patterns.factory.TicketComponente;
import patterns.factory.TicketFactory;
import patterns.state.VagaContexto;
import patterns.strategy.CobrancaDiaria;
import patterns.strategy.CobrancaPorHora;
import patterns.strategy.EstrategiaCobranca;
import patterns.template.ProcessadorSaidaPadrao;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class EstacionamentoController {

    private final EstacionamentoDAO estacionamentoDAO = new EstacionamentoDAO();
    private final VagaDAO vagaDAO = new VagaDAO();
    private final TicketDAO ticketDAO = new TicketDAO();

    public List<VagaDAO.VagaInfo> listarVagas() {
        return vagaDAO.listarVagas();
    }

    public void registrarEntrada(String placa, String tipoVeiculo, int numeroVaga) throws SQLException {
        VagaDAO.VagaInfo vaga = vagaDAO.listarVagas().stream()
                .filter(v -> v.numero == numeroVaga)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Vaga " + numeroVaga + " não encontrada."));

        if (!"Livre".equalsIgnoreCase(vaga.estado)) {
            throw new IllegalStateException("A vaga " + numeroVaga + " não está mais livre.");
        }

        TicketFactory.criarTicket(tipoVeiculo);

        VagaContexto vagaContexto = new VagaContexto(vaga.numero, vaga.estado);
        vagaContexto.ocupar();

        ticketDAO.registrarEntrada(placa, tipoVeiculo, vaga.numero);
        estacionamentoDAO.atualizarEstadoVaga(vaga.numero, "Ocupada");
    }

    public CheckoutInfo prepararCheckout(int numeroVaga) throws SQLException {
        TicketDAO.TicketAberto aberto = ticketDAO.buscarTicketAberto(numeroVaga);
        if (aberto == null) {
            throw new IllegalStateException("Nenhum ticket em aberto para a vaga " + numeroVaga);
        }
        long minutos = ChronoUnit.MINUTES.between(aberto.horaEntrada, LocalDateTime.now());
        return new CheckoutInfo(aberto, minutos);
    }

    public double finalizarSaida(int numeroVaga, TicketDAO.TicketAberto aberto, long minutosDecorridos,
                                  boolean lavagem, boolean cera, String estrategiaSelecionada) throws SQLException {

        TicketComponente ticket = TicketFactory.criarTicket(aberto.tipoVeiculo);

        StringBuilder servicos = new StringBuilder();
        if (lavagem) {
            ticket = new ServicoLavagem(ticket);
            servicos.append("Lavagem");
        }
        if (cera) {
            ticket = new ServicoCera(ticket);
            if (servicos.length() > 0) servicos.append(", ");
            servicos.append("Cera Especial");
        }

        EstrategiaCobranca estrategia = "Diária".equals(estrategiaSelecionada)
                ? new CobrancaDiaria()
                : new CobrancaPorHora();

       
        new ProcessadorSaidaPadrao(estrategia).executarSaida(aberto.placa, ticket);

        double valorFinal = estrategia.calcular(minutosDecorridos, ticket.getValorBase()) + ticket.getValorTotal();

        ticketDAO.finalizarTicket(aberto.id, servicos.toString(), estrategiaSelecionada, valorFinal);

        VagaContexto vagaContexto = new VagaContexto(numeroVaga, "Ocupada");
        vagaContexto.liberar();
        estacionamentoDAO.atualizarEstadoVaga(numeroVaga, "Livre");

        return valorFinal;
    }

    public static class CheckoutInfo {
        public final TicketDAO.TicketAberto ticket;
        public final long minutosDecorridos;

        public CheckoutInfo(TicketDAO.TicketAberto ticket, long minutosDecorridos) {
            this.ticket = ticket;
            this.minutosDecorridos = minutosDecorridos;
        }
    }
}
