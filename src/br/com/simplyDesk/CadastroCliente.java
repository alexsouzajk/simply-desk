package br.com.simplyDesk;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.UIManager;

import com.google.gson.Gson;

import br.com.simplyDesk.request.ClienteRequest;
import br.com.simplyDesk.request.EnderecoRequest;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class CadastroCliente extends JFrame {

	protected static final AbstractButton textFieldTelefoe = null;
	private JPanel contentPane;
	private JTextField textFieldNomeCompleto;
	private JTextField textFieldCnpjCpf;
	private JTextField textFieldDataNascimento;
	private JTextField textFieldLogradouro;
	private JTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldCep;
	private JTextField textFieldCidade;
	private JTextField textFieldUf;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefone;
	private JTextField textFieldComplemento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCliente frame = new CadastroCliente();
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
	public CadastroCliente() {
		setFont(new Font("Dialog", Font.BOLD, 17));
		setForeground(SystemColor.controlText);
		setBackground(SystemColor.controlDkShadow);
		setTitle("Cadastro de cliente");
		setBounds(100, 100, 462, 565);
		contentPane = new JPanel();
		contentPane.setBorder(UIManager.getBorder("PopupMenu.border"));
		contentPane.setBackground(SystemColor.text);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		
		JLabel lblCadastrarNovoCliente = new JLabel("Cadastrar novo cliente:");
		lblCadastrarNovoCliente.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCadastrarNovoCliente.setBounds(10, 11, 190, 26);
		contentPane.add(lblCadastrarNovoCliente);
		
		JLabel labelNome = new JLabel("Nome completo:");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelNome.setBounds(10, 66, 102, 14);
		contentPane.add(labelNome);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 35, 444, 2);
		contentPane.add(separator);
		
		JLabel labelCpfCnpj = new JLabel("CNPJ/CPF:");
		labelCpfCnpj.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelCpfCnpj.setBounds(10, 94, 102, 14);
		contentPane.add(labelCpfCnpj);
		
		JLabel labelDataDeNascimento = new JLabel("Data de nascimento:");
		labelDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelDataDeNascimento.setBounds(10, 124, 118, 14);
		contentPane.add(labelDataDeNascimento);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 230, 444, 2);
		contentPane.add(separator_1);
		
		JLabel lblDadosPessoais = new JLabel("Dados pessoais");
		lblDadosPessoais.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDadosPessoais.setBounds(10, 35, 190, 26);
		contentPane.add(lblDadosPessoais);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEndereco.setBounds(10, 230, 190, 26);
		contentPane.add(lblEndereco);
		
		JLabel labelLogradouro = new JLabel("Logradouro:");
		labelLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		labelLogradouro.setBounds(10, 253, 102, 26);
		contentPane.add(labelLogradouro);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBairro.setBounds(10, 315, 102, 14);
		contentPane.add(lblBairro);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCep.setBounds(10, 340, 102, 14);
		contentPane.add(lblCep);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCidade.setBounds(10, 365, 102, 14);
		contentPane.add(lblCidade);
		
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNmero.setBounds(10, 290, 102, 14);
		contentPane.add(lblNmero);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUf.setBounds(10, 390, 102, 14);
		contentPane.add(lblUf);
		
		textFieldNomeCompleto = new JTextField();
		textFieldNomeCompleto.setBounds(141, 64, 160, 20);
		contentPane.add(textFieldNomeCompleto);
		textFieldNomeCompleto.setColumns(10);
		
		textFieldCnpjCpf = new JTextField();
		textFieldCnpjCpf.setColumns(10);
		textFieldCnpjCpf.setBounds(141, 92, 160, 20);
		contentPane.add(textFieldCnpjCpf);
		
		textFieldDataNascimento = new JTextField();
		textFieldDataNascimento.setColumns(10);
		textFieldDataNascimento.setBounds(141, 122, 160, 20);
		contentPane.add(textFieldDataNascimento);
		
		textFieldLogradouro = new JTextField();
		textFieldLogradouro.setColumns(10);
		textFieldLogradouro.setBounds(102, 257, 160, 20);
		contentPane.add(textFieldLogradouro);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(102, 284, 160, 20);
		contentPane.add(textFieldNumero);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(102, 313, 160, 20);
		contentPane.add(textFieldBairro);
		
		textFieldCep = new JTextField();
		textFieldCep.setColumns(10);
		textFieldCep.setBounds(102, 340, 160, 20);
		contentPane.add(textFieldCep);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(102, 365, 160, 20);
		contentPane.add(textFieldCidade);
		
		textFieldUf = new JTextField();
		textFieldUf.setColumns(10);
		textFieldUf.setBounds(102, 390, 160, 20);
		contentPane.add(textFieldUf);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(10, 154, 118, 14);
		contentPane.add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTelefone.setBounds(10, 179, 118, 14);
		contentPane.add(lblTelefone);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblSexo.setBounds(10, 205, 37, 14);
		contentPane.add(lblSexo);
		
		JRadioButton rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setBackground(Color.WHITE);
		rdbtnMasculino.setBounds(53, 200, 81, 23);
		contentPane.add(rdbtnMasculino);
		
		JRadioButton rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setBackground(Color.WHITE);
		rdbtnFeminino.setBounds(141, 200, 81, 23);
		contentPane.add(rdbtnFeminino);
		
		buttonGroup.add(rdbtnMasculino);
		buttonGroup.add(rdbtnFeminino);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(141, 152, 160, 20);
		contentPane.add(textFieldEmail);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setColumns(10);
		textFieldTelefone.setBounds(141, 177, 160, 20);
		contentPane.add(textFieldTelefone);
		
		JButton botaoCadastrarCliente = new JButton("Cadastrar");
		botaoCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String sexo = rdbtnMasculino.isSelected() ? "M" : "F";
				
				ClienteRequest cliente = new ClienteRequest();
				
				EnderecoRequest endereco = new EnderecoRequest();
				
				SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
				
				endereco.setBairo(textFieldBairro.getText());
				endereco.setCep(textFieldCep.getText());
				endereco.setCidade(textFieldCidade.getText());
				endereco.setComplemento(textFieldComplemento.getText());
				endereco.setLogradouro(textFieldLogradouro.getText());
				endereco.setNumero(
						(textFieldNumero.getText() != null && !textFieldNumero.getText().isEmpty()) ? Integer.valueOf(textFieldNumero.getText()) : 0
						);
				endereco.setUF(textFieldUf.getText());
				
				cliente.setCnpjCpf(textFieldCnpjCpf.getText());
				cliente.setNome(textFieldNomeCompleto.getText());
				cliente.setEndereco(endereco);
				cliente.setEmail(textFieldEmail.getText());
				cliente.setSexo(sexo);
				cliente.setTelefone(textFieldTelefone.getText());

				//System.out.println(formato.format(textFieldDataNascimento.getText()));

				cliente.setDataNascimento(textFieldDataNascimento.getText());


				System.out.println(cliente.getDataNascimento());
				
				doPost("http://localhost:8080/cliente", cliente);
			}
		});
		botaoCadastrarCliente.setFont(new Font("Arial", Font.BOLD, 14));
		botaoCadastrarCliente.setBounds(170, 462, 104, 39);
		contentPane.add(botaoCadastrarCliente);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblComplemento.setBounds(10, 419, 102, 14);
		contentPane.add(lblComplemento);
		
		textFieldComplemento = new JTextField();
		textFieldComplemento.setColumns(10);
		textFieldComplemento.setBounds(102, 417, 160, 20);
		contentPane.add(textFieldComplemento);
	}
	
	private String doPost(String url, Object object) {
		Gson gson = new Gson();
		
		String json = gson.toJson(object);
		String jsonRetorno = null;
		try {
			OkHttpClient client = new OkHttpClient();

			Request.Builder builder = new Request.Builder();

			builder.url(url);

			MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
			
			RequestBody body = RequestBody.create(mediaType, json);
			
			builder.post(body);

			Request request = builder.build();

			Response response = client.newCall(request).execute();

			jsonRetorno = response.body().string();
		}catch(IOException e) {
			e.printStackTrace();
			System.out.println("ERROR: \n"+e.getMessage());
		}
		
		return jsonRetorno;
	}
	
}
