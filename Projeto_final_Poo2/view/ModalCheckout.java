package view;

import controller.EstacionamentoController;

import javax.swing.*;
import java.awt.*;

public class ModalCheckout extends JDialog {

    private final EstacionamentoController controller;
    private final int numeroVaga;
    private final EstacionamentoController.CheckoutInfo info;
    private final Runnable aoFinalizar;

    private final JCheckBox checkLavagem = new JCheckBox("Lavagem (+R$30,00)");
    private final JCheckBox checkCera = new JCheckBox("Cera Especial (+R$15,00)");
    private final JComboBox<String> comboEstrategia = new JComboBox<>(new String[]{"Por Hora", "Diária"});

    public ModalCheckout(JFrame parent, EstacionamentoController controller, int numeroVaga,
                          EstacionamentoController.CheckoutInfo info, Runnable aoFinalizar) {
        super(parent, "Finalizar Saída - Vaga " + numeroVaga, true);
        this.controller = controller;
        this.numeroVaga = numeroVaga;
        this.info = info;
        this.aoFinalizar = aoFinalizar;

        setLayout(new BorderLayout(10, 10));
        setSize(380, 320);
        setLocationRelativeTo(parent);

        add(criarPainelInfo(), BorderLayout.NORTH);
        add(criarPainelOpcoes(), BorderLayout.CENTER);
        add(criarPainelBotao(), BorderLayout.SOUTH);
    }

    private JPanel criarPainelInfo() {
        JPanel painel = new JPanel(new GridLayout(0, 1, 4, 4));
        painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        long horas = info.minutosDecorridos / 60;
        long minutos = info.minutosDecorridos % 60;

        painel.add(new JLabel("Placa: " + info.ticket.placa));
        painel.add(new JLabel("Tipo: " + info.ticket.tipoVeiculo));
        painel.add(new JLabel("Tempo de permanência: " + horas + "h " + minutos + "min"));

        return painel;
    }

    private JPanel criarPainelOpcoes() {
        JPanel painel = new JPanel();
        painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
        painel.setBorder(BorderFactory.createTitledBorder("Serviços Extras e Cobrança"));

        painel.add(checkLavagem);
        painel.add(checkCera);

        JPanel painelEstrategia = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painelEstrategia.add(new JLabel("Cobrança:"));
        painelEstrategia.add(comboEstrategia);
        painel.add(painelEstrategia);

        return painel;
    }

    private JPanel criarPainelBotao() {
        JPanel painel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        JButton botaoFinalizar = new JButton("Finalizar Saída");
        botaoFinalizar.addActionListener(e -> finalizarSaida());
        painel.add(botaoFinalizar);
        return painel;
    }

    private void finalizarSaida() {
        try {
            double valor = controller.finalizarSaida(
                    numeroVaga,
                    info.ticket,
                    info.minutosDecorridos,
                    checkLavagem.isSelected(),
                    checkCera.isSelected(),
                    (String) comboEstrategia.getSelectedItem()
            );

            JOptionPane.showMessageDialog(this,
                    String.format("Saída registrada! Valor cobrado: R$ %.2f", valor),
                    "Sucesso", JOptionPane.INFORMATION_MESSAGE);

            aoFinalizar.run();
            dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Erro ao finalizar saída", JOptionPane.ERROR_MESSAGE);
        }
    }
}
