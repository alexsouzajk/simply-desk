package br.com.simplyDesk;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import br.com.simplyDesk.request.MoedaRequest;
import br.com.simplyDesk.request.OrdemRequest;
import br.com.simplyDesk.request.Requisita;

public class Relatorios extends JFrame {

	private JPanel contentPane;
	private JTable table;

	private Object[][] dados;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Relatorios frame = new Relatorios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Relatorios() {
		setBounds(100, 100, 1097, 566);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnBuscarPorCpf = new JButton("POR CPF");
		btnBuscarPorCpf.setForeground(SystemColor.text);
		btnBuscarPorCpf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String cpf = (String) JOptionPane.showInputDialog("CPF");

				Gson gson = new Gson();
				List<OrdemRequest> ordens = new ArrayList<>();
				String jsonRetorno = null;

				try {
					jsonRetorno = Requisita.get("http://localhost:8080/ordens/cliente/"+cpf);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("ERRO: " + e.getMessage());
				}

				if (jsonRetorno != null) {
					ordens = gson.fromJson(jsonRetorno, new TypeToken<List<OrdemRequest>>() {
					}.getType());
					preencheTabela(ordens);
				} else {
					JOptionPane.showMessageDialog(null, "Nenhuma ordem encontrada!");
				}
			}
		});
		btnBuscarPorCpf.setFont(new Font("Arial", Font.BOLD, 12));
		btnBuscarPorCpf.setBackground(SystemColor.textHighlight);
		btnBuscarPorCpf.setBounds(45, 49, 151, 44);
		contentPane.add(btnBuscarPorCpf);

		JLabel lblNewLabel = new JLabel("SELECIONE COMO DESEJA VISUALIZAR:");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(58, 11, 322, 27);
		contentPane.add(lblNewLabel);

		JButton btnBuscarUltimoMes = new JButton("ULTIMOS 30 DIAS");
		btnBuscarUltimoMes.setForeground(SystemColor.text);
		btnBuscarUltimoMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gson gson = new Gson();
				List<OrdemRequest> ordens = new ArrayList<>();
				String jsonRetorno = null;

				try {
					jsonRetorno = Requisita.get("http://localhost:8080/ordens/data/30");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("ERRO: " + e.getMessage());
				}

				if (jsonRetorno != null) {
					ordens = gson.fromJson(jsonRetorno, new TypeToken<List<OrdemRequest>>() {
					}.getType());
					preencheTabela(ordens);
				} else {
					JOptionPane.showMessageDialog(null, "Nenhuma ordem encontrada!");
				}
			}
		});
		btnBuscarUltimoMes.setFont(new Font("Arial", Font.BOLD, 12));
		btnBuscarUltimoMes.setBackground(SystemColor.textHighlight);
		btnBuscarUltimoMes.setBounds(218, 49, 151, 44);
		contentPane.add(btnBuscarUltimoMes);

		JButton btnBuscarUltimaSemana = new JButton("ULTIMOS 7 DIAS");
		btnBuscarUltimaSemana.setForeground(SystemColor.text);
		btnBuscarUltimaSemana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Gson gson = new Gson();
				List<OrdemRequest> ordens = new ArrayList<>();
				String jsonRetorno = null;

				try {
					jsonRetorno = Requisita.get("http://localhost:8080/ordens/data/7");
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("ERRO: " + e.getMessage());
				}

				if (jsonRetorno != null) {
					ordens = gson.fromJson(jsonRetorno, new TypeToken<List<OrdemRequest>>() {
					}.getType());
					preencheTabela(ordens);
				} else {
					JOptionPane.showMessageDialog(null, "Nenhuma ordem encontrada!");
				}
			}
		});
		btnBuscarUltimaSemana.setFont(new Font("Arial", Font.BOLD, 12));
		btnBuscarUltimaSemana.setBackground(SystemColor.textHighlight);
		btnBuscarUltimaSemana.setBounds(390, 49, 151, 44);
		contentPane.add(btnBuscarUltimaSemana);

		JButton btnBuscarPorMoeda = new JButton("POR MOEDA");
		btnBuscarPorMoeda.setForeground(SystemColor.text);
		btnBuscarPorMoeda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Map<String, Long> mapOpcoes = new HashMap<>();
				List<String> opcoes = new ArrayList<>();
				Gson gson = new Gson();
				List<MoedaRequest> moedas = new ArrayList<>();
				moedas = gson.fromJson(Requisita.get("http://localhost:8080/moedas"),
						new TypeToken<List<MoedaRequest>>() {
						}.getType());

				moedas.forEach(moeda -> {
					mapOpcoes.put(moeda.getNome(), moeda.getId());
				});

				mapOpcoes.forEach((chave, valor) -> {
					opcoes.add(chave);
				});
				String chaveMoeda = (String) JOptionPane.showInputDialog(null, "Selecione a moeda:", "Moeda",
						JOptionPane.QUESTION_MESSAGE, null, opcoes.toArray(), opcoes.toArray()[0]);

				Long idMoeda = mapOpcoes.get(chaveMoeda);

				List<OrdemRequest> ordens = new ArrayList<>();
				String jsonRetorno = null;

				try {
					jsonRetorno = Requisita.get("http://localhost:8080/ordens/moeda/" + idMoeda.intValue());
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println("ERRO: " + e.getMessage());
				}

				if (jsonRetorno != null) {
					ordens = gson.fromJson(jsonRetorno, new TypeToken<List<OrdemRequest>>() {
					}.getType());
					preencheTabela(ordens);
				} else {
					JOptionPane.showMessageDialog(null, "Nenhuma ordem encontrada!");
				}
			}
		});
		btnBuscarPorMoeda.setFont(new Font("Arial", Font.BOLD, 12));
		btnBuscarPorMoeda.setBackground(SystemColor.textHighlight);
		btnBuscarPorMoeda.setBounds(573, 49, 151, 44);
		contentPane.add(btnBuscarPorMoeda);

		JPanel panel = new JPanel();
		panel.setBounds(10, 122, 1061, 394);
		panel.setLayout(new GridLayout(1, 1));
		contentPane.add(panel);

		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Cliente (CNPJ)");
		model.addColumn("Moeda");
		model.addColumn("Quantidade");
		model.addColumn("Preço unitário");
		model.addColumn("Valor");
		model.addColumn("Tipo");
		model.addColumn("Data");
		model.addColumn("Status");

		table = new JTable(model);
		table.setCellSelectionEnabled(true);
		table.setFont(new Font("Arial", Font.BOLD, 11));
		table.setForeground(SystemColor.text);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setBackground(SystemColor.windowBorder);
		table.setBounds(1023, 494, 151, 44);
		panel.add(table);

		JScrollPane barraRolagem = new JScrollPane(table);
		barraRolagem.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		barraRolagem.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(barraRolagem);
	}

	private void preencheTabela(List<OrdemRequest> ordens) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		DecimalFormat decFormat = new DecimalFormat("'R$ ' #,###,##0.00");
		model.setRowCount(0);
		ordens.forEach(ordem -> {
			String status = ordem.getStatusOrdem();
			String tipo = ordem.getTipo();

			if (tipo.equals("C"))
				tipo = "Compra";
			if (tipo.equals("V"))
				tipo = "Venda";

			if (status.equals("E"))
				status = "Executada";
			if (status.equals("A"))
				status = "Aguardando processamento";
			if (status.equals("E"))
				status = "Rejeitada";

			model.addRow(new Object[] { ordem.getCliente().getCnpjCpf(), ordem.getMoeda().getNome(),
					ordem.getQuantidadeMoedas(),
					decFormat.format(ordem.getValorOrdem().divide(BigDecimal.valueOf(ordem.getQuantidadeMoedas()))),
					decFormat.format(ordem.getValorOrdem()), tipo, ordem.getDataOrdem(), status });
		});
	}
}
