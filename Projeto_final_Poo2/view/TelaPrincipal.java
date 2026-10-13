package view;

import com.formdev.flatlaf.FlatDarkLaf;
import controller.EstacionamentoController;
import dao.VagaDAO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaPrincipal extends JFrame {

    private final EstacionamentoController controller = new EstacionamentoController();

    private final JTextField campoPlaca = new JTextField(12);
    private final JComboBox<String> comboTipoVeiculo = new JComboBox<>(new String[]{"Carro", "Moto"});
    private final JComboBox<Integer> comboVaga = new JComboBox<>();
    private final JPanel painelVagas = new JPanel(new GridLayout(0, 5, 10, 10));

    public TelaPrincipal() {
        super("Estacionamento Inteligente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 600);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        add(criarPainelEntrada(), BorderLayout.NORTH);
        add(criarPainelVagasComScroll(), BorderLayout.CENTER);

        atualizarGrelhaVagas();
    }

    private JPanel criarPainelEntrada() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        painel.setBorder(BorderFactory.createTitledBorder("Registrar Entrada"));

        painel.add(new JLabel("Placa:"));
        painel.add(campoPlaca);
        painel.add(new JLabel("Tipo:"));
        painel.add(comboTipoVeiculo);
        painel.add(new JLabel("Vaga:"));
        painel.add(comboVaga);

        JButton botaoRegistrar = new JButton("Registrar Entrada");
        botaoRegistrar.addActionListener(e -> registrarEntrada());
        painel.add(botaoRegistrar);

        return painel;
    }

    private JScrollPane criarPainelVagasComScroll() {
        painelVagas.setBorder(BorderFactory.createTitledBorder("Vagas"));
        return new JScrollPane(painelVagas);
    }

    private void registrarEntrada() {
        String placa = campoPlaca.getText().trim().toUpperCase();
        String tipo = (String) comboTipoVeiculo.getSelectedItem();
        Integer vagaEscolhida = (Integer) comboVaga.getSelectedItem();

        if (placa.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe a placa do veículo.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (vagaEscolhida == null) {
            JOptionPane.showMessageDialog(this, "Não há vagas livres no momento.", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            controller.registrarEntrada(placa, tipo, vagaEscolhida);
            campoPlaca.setText("");
            atualizarGrelhaVagas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro ao registrar entrada", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void atualizarGrelhaVagas() {
        painelVagas.removeAll();

        List<VagaDAO.VagaInfo> vagas = controller.listarVagas();
        for (VagaDAO.VagaInfo vaga : vagas) {
            painelVagas.add(criarBotaoVaga(vaga));
        }

        painelVagas.revalidate();
        painelVagas.repaint();

        atualizarComboVagas(vagas);
    }

    private void atualizarComboVagas(List<VagaDAO.VagaInfo> vagas) {
        Integer selecionadaAtual = (Integer) comboVaga.getSelectedItem();
        comboVaga.removeAllItems();

        for (VagaDAO.VagaInfo vaga : vagas) {
            if ("Livre".equalsIgnoreCase(vaga.estado)) {
                comboVaga.addItem(vaga.numero);
            }
        }

        if (selecionadaAtual != null) {
            comboVaga.setSelectedItem(selecionadaAtual);
        }
    }

    private JButton criarBotaoVaga(VagaDAO.VagaInfo vaga) {
        boolean ocupada = "Ocupada".equalsIgnoreCase(vaga.estado);

        String texto = ocupada
                ? "<html><center>Vaga " + vaga.numero + "<br>" + vaga.placa + "</center></html>"
                : "<html><center>Vaga " + vaga.numero + "<br>Livre</center></html>";

        JButton botao = new JButton(texto);
        botao.setOpaque(true);
        botao.setForeground(Color.WHITE);
        botao.setBackground(ocupada ? new Color(198, 40, 40) : new Color(46, 125, 50));
        botao.setPreferredSize(new Dimension(120, 80));

        if (ocupada) {
            botao.addActionListener(e -> abrirCheckout(vaga.numero));
        } else {
            botao.addActionListener(e -> comboVaga.setSelectedItem(vaga.numero));
        }

        return botao;
    }

    private void abrirCheckout(int numeroVaga) {
        try {
            EstacionamentoController.CheckoutInfo info = controller.prepararCheckout(numeroVaga);
            ModalCheckout modal = new ModalCheckout(this, controller, numeroVaga, info, this::atualizarGrelhaVagas);
            modal.setVisible(true);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro ao abrir saída", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatDarkLaf());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new TelaPrincipal().setVisible(true);
        });
    }
}
