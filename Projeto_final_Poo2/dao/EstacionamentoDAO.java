package dao;
import java.sql.*;

public class EstacionamentoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/estacionamento_db";
    private static final String USER = "app_estacionamento";
    private static final String PASS = "Estacionamento123!";

    private Connection conn() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

    public void atualizarEstadoVaga(int numero, String novoEstado) {
        String sql = "UPDATE Vaga SET estado = ? WHERE numero = ?";
        
        try (Connection c = conn();
             PreparedStatement stmt = c.prepareStatement(sql)) {
            
            stmt.setString(1, novoEstado);
            stmt.setInt(2, numero);
            stmt.executeUpdate();
            
        } catch (SQLException e) { 
            e.printStackTrace(); 
        }
    }

    public static void main(String[] args) {
        EstacionamentoDAO teste = new EstacionamentoDAO();
        try {
        
            Connection conexao = teste.conn();
            System.out.println("✅ SUCESSO ABSOLUTO! O Java encontrou o banco de dados!");
            conexao.close();
        } catch (Exception e) {
            System.out.println("❌ ERRO DE CONEXÃO. Veja o motivo abaixo:");
            e.printStackTrace();
        }
    }
}