package br.com.simplyDesk;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.google.gson.Gson;

import br.com.simplyDesk.request.BancosEntityRequest;
import br.com.simplyDesk.request.ClienteContaRequest;
import br.com.simplyDesk.request.ClienteRequest;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Design\\Simply\\Telas\\e1804e71-611f-4101-be64-e0c75202983e.jpg"));
		setTitle("Simply");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCliente = new JButton("Cliente");
		btnCliente.setForeground(SystemColor.text);
		btnCliente.setFont(new Font("Arial", Font.PLAIN, 12));
		btnCliente.setBackground(SystemColor.desktop);
		btnCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				OpcoesCliente opcoesCliente = new OpcoesCliente();
				opcoesCliente.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				opcoesCliente.setVisible(true);
				
				// JOptionPane.showMessageDialog(null, "ABRI O JOPTIONPANE PORRA1!");

				/*try {
					URL url = new URL("http://localhost:8080/contas");

					HttpURLConnection con = con = (HttpURLConnection) url.openConnection();

					if (con.getResponseCode() != 200) {
						throw new RuntimeException("HTTP error code : " + con.getResponseCode());
					}
					BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
					
					StringBuilder builder = new StringBuilder();
					
					br.lines().forEach(linha->{
						builder.append(linha);
					});
					
					System.out.println(builder.toString());
					
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("ERROR: \n"+e.getMessage());
				}*/
				
				/*Gson gson = new Gson();
				
				BancosEntityRequest banco = new BancosEntityRequest();
				banco.setCodigo(1L);
				
				ClienteRequest cliente = new ClienteRequest();
				cliente.setId(1L);
				
				ClienteContaRequest conta = new ClienteContaRequest();
				conta.setCodigoBanco(banco);
				conta.setIdCliente(cliente);
				conta.setCodigoAgencia(0001L);
				conta.setCodigoConta(1476547812L);
				
				String json = gson.toJson(conta);
				try {
					OkHttpClient client = new OkHttpClient();

					String url = "http://localhost:8080/contas";

					Request.Builder builder = new Request.Builder();

					builder.url(url);

					MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
					
					RequestBody body = RequestBody.create(mediaType, json);
					
					builder.post(body);

					Request request = builder.build();

					Response response = client.newCall(request).execute();

					String jsonDeResposta = response.body().string();
					
					System.out.println(jsonDeResposta);
				}catch(IOException e) {
					e.printStackTrace();
					System.out.println("ERROR: \n"+e.getMessage());
				}
				*/
				
				
			}
		});
		btnCliente.setBounds(10, 67, 180, 38);
		contentPane.add(btnCliente);
		
		JButton btnRelatorios = new JButton("Relat\u00F3rios");
		btnRelatorios.setForeground(SystemColor.text);
		btnRelatorios.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRelatorios.setBackground(Color.BLACK);
		btnRelatorios.setBounds(10, 127, 180, 38);
		contentPane.add(btnRelatorios);
	}
}
