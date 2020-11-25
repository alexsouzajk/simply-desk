package br.com.simplyDesk;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.google.gson.Gson;

import br.com.simplyDesk.request.ClienteRequest;
import br.com.simplyDesk.request.EnderecoRequest;
import br.com.simplyDesk.request.Requisita;

public class TelaCliente extends JFrame {

	private JPanel contentPane;
	private JButton btnBuscarCliente;
	private JTextField textFieldBuscarPorNome;
	private JLabel lblBuscarPorCnpjCpf;
	private JTextField textFieldBuscarPorCpf;
	private JTextField textFieldNomeCompleto;
	private JTextField textFieldCpf;
	private JTextField textFieldDataNascimento;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTextField textFieldLogradouro;
	private JTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldCep;
	private JTextField textFieldCidade;
	private JTextField textFieldUf;
	private JTextField textFieldComplemento;
	private JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
	private JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
	private JButton btnEditar = new JButton("Editar");
	private JButton btnExcluir = new JButton("Excluir");
	private JLabel hiddenIdEndereco = new JLabel("");
	private JLabel hiddenIdCliente = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
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
	public TelaCliente() {
		setBounds(100, 100, 677, 468);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 641, 102);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarCliente("","");
			}
		});
		btnBuscarCliente.setBackground(Color.WHITE);
		btnBuscarCliente.setBounds(28, 67, 89, 23);
		panel.add(btnBuscarCliente);
		
		JLabel lblBuscarPorNome = new JLabel("Por nome:");
		lblBuscarPorNome.setBounds(29, 11, 89, 16);
		panel.add(lblBuscarPorNome);
		
		textFieldBuscarPorNome = new JTextField();
		textFieldBuscarPorNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldBuscarPorCpf.setText("");
			}
		});
		textFieldBuscarPorNome.setBounds(108, 9, 440, 20);
		panel.add(textFieldBuscarPorNome);
		textFieldBuscarPorNome.setColumns(10);
		
		lblBuscarPorCnpjCpf = new JLabel("Por CPF:");
		lblBuscarPorCnpjCpf.setBounds(28, 40, 89, 16);
		panel.add(lblBuscarPorCnpjCpf);
		
		textFieldBuscarPorCpf = new JTextField();
		textFieldBuscarPorCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				textFieldBuscarPorNome.setText("");
			}
		});
		textFieldBuscarPorCpf.setColumns(10);
		textFieldBuscarPorCpf.setBounds(107, 38, 440, 20);
		panel.add(textFieldBuscarPorCpf);
		
		JLabel lblNewLabel = new JLabel("Dados pessoais");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 14));
		lblNewLabel.setBounds(10, 117, 129, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome completo:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 139, 91, 14);
		contentPane.add(lblNewLabel_1);
		
		textFieldNomeCompleto = new JTextField();
		textFieldNomeCompleto.setBounds(136, 136, 171, 20);
		contentPane.add(textFieldNomeCompleto);
		textFieldNomeCompleto.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 167, 91, 14);
		contentPane.add(lblNewLabel_1_1);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setColumns(10);
		textFieldCpf.setBounds(136, 167, 171, 20);
		contentPane.add(textFieldCpf);
		
		JLabel lblNewLabel_1_2 = new JLabel("Data de nascimento:");
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(10, 195, 122, 14);
		contentPane.add(lblNewLabel_1_2);
		
		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setColumns(10);
		textFieldDataNascimento.setBounds(136, 195, 171, 20);
		contentPane.add(textFieldDataNascimento);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email:");
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(10, 229, 91, 14);
		contentPane.add(lblNewLabel_1_3);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(136, 226, 171, 20);
		contentPane.add(textFieldEmail);
		
		JLabel lblNewLabel_1_4 = new JLabel("Telefone:");
		lblNewLabel_1_4.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_4.setBounds(10, 260, 91, 14);
		contentPane.add(lblNewLabel_1_4);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(136, 257, 171, 20);
		contentPane.add(textFieldTelefone);
		
		rdbtnMasculino.setBackground(SystemColor.text);
		rdbtnMasculino.setBounds(10, 292, 109, 23);
		contentPane.add(rdbtnMasculino);
		
		rdbtnFeminino.setBackground(Color.WHITE);
		rdbtnFeminino.setBounds(126, 292, 109, 23);
		contentPane.add(rdbtnFeminino);
		
		buttonGroup.add(rdbtnMasculino);
		buttonGroup.add(rdbtnFeminino);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 359, 661, 2);
		contentPane.add(separator);
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteRequest cliente = getDadosFormTela();
				String jsonRetorno = null;
				Gson gson = new Gson();
				
				try {
					jsonRetorno = Requisita.put("http://localhost:8080/cliente", cliente);
				}catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR CLIENTE - "+e.getMessage()+"!");
				}
				
				if (jsonRetorno == null) {
					JOptionPane.showMessageDialog(null, "ERRO AO ATUALIZAR CLIENTE!");
					throw new RuntimeException("ERRO AO ATUALIZAR CLIENTE!");
				}
				
				ClienteRequest clienteRetorno = gson.fromJson(jsonRetorno, ClienteRequest.class);
				
				buscarCliente("", cliente.getCnpjCpf());
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEditar.setBackground(SystemColor.textHighlight);
		btnEditar.setBounds(10, 372, 127, 42);
		contentPane.add(btnEditar);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClienteRequest cliente = getDadosFormTela();;
				
				try {
					Requisita.delete("http://localhost:8080/cliente", cliente);
				}catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR CLIENTE - "+e.getMessage()+"!");
				}
				limparTextFields();
			}
		});
		
		btnExcluir.setEnabled(false);
		btnExcluir.setFont(new Font("Arial", Font.BOLD, 12));
		btnExcluir.setBackground(new Color(255, 0, 0));
		btnExcluir.setBounds(159, 372, 127, 42);
		contentPane.add(btnExcluir);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Arial", Font.BOLD, 14));
		lblEndereco.setBounds(335, 117, 129, 20);
		contentPane.add(lblEndereco);
		
		JLabel lblNewLabel_1_5 = new JLabel("Logradouro:");
		lblNewLabel_1_5.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_5.setBounds(335, 139, 91, 14);
		contentPane.add(lblNewLabel_1_5);
		
		textFieldLogradouro = new JTextField();
		textFieldLogradouro.setColumns(10);
		textFieldLogradouro.setBounds(461, 136, 171, 20);
		contentPane.add(textFieldLogradouro);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("N\u00FAmero:");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_1_1.setBounds(335, 167, 91, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(461, 167, 171, 20);
		contentPane.add(textFieldNumero);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Bairro:");
		lblNewLabel_1_2_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_2_1.setBounds(335, 195, 122, 14);
		contentPane.add(lblNewLabel_1_2_1);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(461, 195, 171, 20);
		contentPane.add(textFieldBairro);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("CEP:");
		lblNewLabel_1_3_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_3_1.setBounds(335, 229, 91, 14);
		contentPane.add(lblNewLabel_1_3_1);
		
		textFieldCep = new JTextField();
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(461, 226, 171, 20);
		contentPane.add(textFieldCep);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Cidade:");
		lblNewLabel_1_4_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_4_1.setBounds(335, 260, 91, 14);
		contentPane.add(lblNewLabel_1_4_1);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(461, 257, 171, 20);
		contentPane.add(textFieldCidade);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("UF:");
		lblNewLabel_1_4_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_4_1_1.setBounds(335, 288, 91, 14);
		contentPane.add(lblNewLabel_1_4_1_1);
		
		textFieldUf = new JTextField();
		textFieldUf.setColumns(10);
		textFieldUf.setBounds(461, 285, 171, 20);
		contentPane.add(textFieldUf);
		
		JLabel lblNewLabel_1_4_1_2 = new JLabel("Complemento:");
		lblNewLabel_1_4_1_2.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel_1_4_1_2.setBounds(335, 316, 91, 14);
		contentPane.add(lblNewLabel_1_4_1_2);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setColumns(10);
		textFieldComplemento.setBounds(461, 313, 171, 20);
		contentPane.add(textFieldComplemento);
		
		hiddenIdCliente.setEnabled(false);
		hiddenIdCliente.setBounds(10, 334, 46, 14);
		contentPane.add(hiddenIdCliente);
		
		hiddenIdEndereco.setEnabled(false);
		hiddenIdEndereco.setBounds(80, 334, 46, 14);
		contentPane.add(hiddenIdEndereco);
	}

	private ClienteRequest getDadosFormTela() {
		ClienteRequest cliente = new ClienteRequest();
		cliente.setId(Long.valueOf(hiddenIdCliente.getText()));
		
		cliente.setNome(textFieldNomeCompleto.getText());
		cliente.setCnpjCpf(textFieldCpf.getText());
		cliente.setDataNascimento(textFieldDataNascimento.getText());
		cliente.setEmail(textFieldEmail.getText());
		cliente.setTelefone(textFieldTelefone.getText());
		
		String sexo = rdbtnMasculino.isSelected() ? "M" : "F";
		cliente.setSexo(sexo);

		EnderecoRequest endereco = new EnderecoRequest();
		endereco.setId(Long.valueOf(hiddenIdEndereco.getText()));
		endereco.setLogradouro(textFieldLogradouro.getText());
		endereco.setNumero(Integer.valueOf(textFieldNumero.getText()));
		endereco.setBairo(textFieldBairro.getText());
		endereco.setCep(textFieldCep.getText());
		endereco.setCidade(textFieldCidade.getText());
		endereco.setUf(textFieldUf.getText());
		endereco.setComplemento(textFieldComplemento.getText());
		
		cliente.setEndereco(endereco);
		
		return cliente;
	}

	private void setaCliente(ClienteRequest cliente) {
		hiddenIdCliente.setText(cliente.getId().toString());
		textFieldNomeCompleto.setText(String.valueOf(isNull(cliente.getNome(),"-")));
		textFieldCpf.setText(String.valueOf(isNull(cliente.getCnpjCpf(),"-")));
		textFieldDataNascimento.setText(String.valueOf(isNull(cliente.getDataNascimento(),"__/__/____")));
		textFieldEmail.setText(String.valueOf(isNull(cliente.getEmail(),"-")));
		textFieldTelefone.setText(String.valueOf(isNull(cliente.getTelefone(),"-")));
		if(cliente.getSexo() == null || cliente.getSexo().isBlank() || cliente.getSexo().isEmpty()) {
			rdbtnMasculino.setSelected(true);
		}else {			
			if(cliente.getSexo().equalsIgnoreCase("M")) {rdbtnMasculino.setSelected(true);}
			if(cliente.getSexo().equalsIgnoreCase("F")) {rdbtnFeminino.setSelected(true);}
		}
		
		//Endereco
		EnderecoRequest endereco = cliente.getEndereco();
		hiddenIdEndereco.setText(endereco.getId().toString());
		textFieldLogradouro.setText(String.valueOf(isNull(endereco.getLogradouro(),"-")));
		textFieldNumero.setText(String.valueOf(isNull(endereco.getNumero(),"-")));
		textFieldBairro.setText(String.valueOf(isNull(endereco.getBairo(),"-")));
		textFieldCep.setText(String.valueOf(isNull(endereco.getCep(),"-")));
		textFieldCidade.setText(String.valueOf(isNull(endereco.getCidade(),"-")));
		textFieldUf.setText(String.valueOf(isNull(endereco.getUf(),"-")));
		textFieldComplemento.setText(String.valueOf(isNull(endereco.getComplemento(),"-")));
	}
	
	private void limparTextFields() {
		hiddenIdCliente.setText("");
		hiddenIdEndereco.setText("");
		textFieldNomeCompleto.setText("");
		textFieldCpf.setText("");
		textFieldDataNascimento.setText("");
		textFieldEmail.setText("");
		textFieldTelefone.setText("");
	
		rdbtnMasculino.setSelected(false);
		rdbtnFeminino.setSelected(false);

		textFieldLogradouro.setText("");
		textFieldNumero.setText("");
		textFieldBairro.setText("");
		textFieldCep.setText("");
		textFieldCidade.setText("");
		textFieldUf.setText("");
		textFieldComplemento.setText("");
		btnEditar.setEnabled(false);
		btnExcluir.setEnabled(false);
	}
	
	private Object isNull(Object obj, Object segundaOpcao) {
		if(obj == null) {
			return segundaOpcao;
		}
		return obj;
	}
	
	private void buscarCliente(String BuscarPorNome, String BuscarPorCpf) {
		Gson gson = new Gson();
		String jsonRetorno = null;
		limparTextFields();
		if(!BuscarPorNome.isEmpty()) {textFieldBuscarPorNome.setText(BuscarPorNome); textFieldBuscarPorCpf.setText("");}
		if(!BuscarPorCpf.isEmpty()) {textFieldBuscarPorCpf.setText(BuscarPorCpf); textFieldBuscarPorNome.setText("");}
		
		if (textFieldBuscarPorNome.getText().isEmpty() && textFieldBuscarPorCpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "SELECIONE UMA OPÇÃO \nBUSCA POR NOME OU CNPJ!");
			throw new RuntimeException("SELECIONE UMA OPÇÃO!");
		}

		if ((textFieldBuscarPorCpf != null || !textFieldBuscarPorCpf.getText().isEmpty()
				|| !textFieldBuscarPorCpf.getText().isBlank())
				&& (textFieldBuscarPorNome == null || textFieldBuscarPorNome.getText().isEmpty()
						|| textFieldBuscarPorNome.getText().isBlank())) {
			try {
				System.out.println("Entrou no buscar por CPF");
				jsonRetorno = Requisita
						.get("http://localhost:8080/cliente/cpf?cpf=" + textFieldBuscarPorCpf.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "ERRO AO BUSCAR CLIENTE - CPF NÃO ENCONTRADO!");
			}
		}

		if ((textFieldBuscarPorNome != null || !textFieldBuscarPorNome.getText().isEmpty() || !textFieldBuscarPorNome.getText().isBlank()) &&
				textFieldBuscarPorCpf == null || textFieldBuscarPorCpf.getText().isEmpty() || textFieldBuscarPorCpf.getText().isBlank()) {
			try {
				System.out.println("Entrou no buscar por nome");
				String url = "http://localhost:8080/cliente/nome?nome=" + textFieldBuscarPorNome.getText();
				jsonRetorno = Requisita
						.get(url);
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "ERRO AO BUSCAR CLIENTE - NOME NÃO ENCONTRADO!");
			}
		}

		if (jsonRetorno == null) {
			JOptionPane.showMessageDialog(null, "CLIENTE NÃO ENCONTRADO!");
			throw new RuntimeException("CLIENTE NÃO ENCONTRADO!");
		}

		ClienteRequest cliente = gson.fromJson(jsonRetorno, ClienteRequest.class);

		setaCliente(cliente);
		
		btnEditar.setEnabled(true);
		btnExcluir.setEnabled(true);
	}
	
}
