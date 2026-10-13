package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VagaDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/estacionamento_db";
    private static final String USER = "app_estacionamento";
    private static final String PASS = "Estacionamento123!";

    private Connection conn() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public List<VagaInfo> listarVagas() {
        List<VagaInfo> vagas = new ArrayList<>();
        String sql = "SELECT v.numero, v.estado, t.placa_veiculo " +
                "FROM vaga v " +
                "LEFT JOIN ticket t ON t.numero_vaga = v.numero AND t.hora_saida IS NULL " +
                "ORDER BY v.numero";

        try (Connection c = conn();
             PreparedStatement stmt = c.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                vagas.add(new VagaInfo(rs.getInt("numero"), rs.getString("estado"), rs.getString("placa_veiculo")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vagas;
    }

    public static class VagaInfo {
        public final int numero;
        public final String estado;
        public final String placa;

        public VagaInfo(int numero, String estado, String placa) {
            this.numero = numero;
            this.estado = estado;
            this.placa = placa;
        }
    }
}
