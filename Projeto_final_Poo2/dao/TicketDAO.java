package dao;

import java.sql.*;
import java.time.LocalDateTime;

public class TicketDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/estacionamento_db";
    private static final String USER = "app_estacionamento";
    private static final String PASS = "Estacionamento123!";

    private Connection conn() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public void registrarEntrada(String placa, String tipoVeiculo, int numeroVaga) throws SQLException {
        try (Connection c = conn()) {
            try (PreparedStatement upsertVeiculo = c.prepareStatement(
                    "INSERT INTO veiculo (placa, tipo) VALUES (?, ?) " +
                            "ON DUPLICATE KEY UPDATE tipo = VALUES(tipo)")) {
                upsertVeiculo.setString(1, placa);
                upsertVeiculo.setString(2, tipoVeiculo);
                upsertVeiculo.executeUpdate();
            }
            try (PreparedStatement insertTicket = c.prepareStatement(
                    "INSERT INTO ticket (placa_veiculo, numero_vaga, hora_entrada) VALUES (?, ?, NOW())")) {
                insertTicket.setString(1, placa);
                insertTicket.setInt(2, numeroVaga);
                insertTicket.executeUpdate();
            }
        }
    }

    public TicketAberto buscarTicketAberto(int numeroVaga) throws SQLException {
        String sql = "SELECT t.id, t.placa_veiculo, t.hora_entrada, v.tipo " +
                "FROM ticket t JOIN veiculo v ON v.placa = t.placa_veiculo " +
                "WHERE t.numero_vaga = ? AND t.hora_saida IS NULL " +
                "ORDER BY t.id DESC LIMIT 1";

        try (Connection c = conn();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, numeroVaga);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new TicketAberto(
                            rs.getInt("id"),
                            rs.getString("placa_veiculo"),
                            rs.getString("tipo"),
                            rs.getTimestamp("hora_entrada").toLocalDateTime()
                    );
                }
            }
        }
        return null;
    }

    public void finalizarTicket(int idTicket, String servicosExtras, String tipoCobranca, double valorTotal) throws SQLException {
        String sql = "UPDATE ticket SET hora_saida = NOW(), servicos_extras = ?, tipo_cobranca = ?, valor_total = ? WHERE id = ?";

        try (Connection c = conn();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setString(1, servicosExtras);
            stmt.setString(2, tipoCobranca);
            stmt.setDouble(3, valorTotal);
            stmt.setInt(4, idTicket);
            stmt.executeUpdate();
        }
    }

    public static class TicketAberto {
        public final int id;
        public final String placa;
        public final String tipoVeiculo;
        public final LocalDateTime horaEntrada;

        public TicketAberto(int id, String placa, String tipoVeiculo, LocalDateTime horaEntrada) {
            this.id = id;
            this.placa = placa;
            this.tipoVeiculo = tipoVeiculo;
            this.horaEntrada = horaEntrada;
        }
    }
}
