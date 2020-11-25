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
import javax.swing.JTable;
import java.awt.Canvas;
import java.awt.Component;
import javax.swing.Box;

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
		setBounds(100, 100, 552, 386);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
			}
		});
		btnCliente.setBounds(10, 115, 180, 38);
		contentPane.add(btnCliente);
		
		JButton btnRelatorios = new JButton("Relat\u00F3rios");
		btnRelatorios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Relatorios telaRelatorios = new Relatorios();
				telaRelatorios.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
				telaRelatorios.setVisible(true);
			}
		});
		btnRelatorios.setForeground(SystemColor.text);
		btnRelatorios.setFont(new Font("Arial", Font.PLAIN, 12));
		btnRelatorios.setBackground(Color.BLACK);
		btnRelatorios.setBounds(10, 175, 180, 38);
		contentPane.add(btnRelatorios);
		
		JLabel lblNewLabel = new JLabel("Bem vindo ao Simply");
		lblNewLabel.setForeground(new Color(0, 128, 0));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 233, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblEscolhaAOpo = new JLabel("Escolha a op\u00E7\u00E3o desejada:");
		lblEscolhaAOpo.setForeground(new Color(0, 191, 255));
		lblEscolhaAOpo.setFont(new Font("Arial", Font.BOLD, 14));
		lblEscolhaAOpo.setBounds(10, 60, 233, 38);
		contentPane.add(lblEscolhaAOpo);
	}
}
