package br.com.simplyDesk;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpcoesCliente extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcoesCliente frame = new OpcoesCliente();
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
	public OpcoesCliente() {
		setBackground(SystemColor.text);
		setResizable(false);
		setTitle("Cliente:");
		setType(Type.UTILITY);
		setBounds(100, 100, 498, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarCliente = new JButton("CADASTRAR");
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				CadastroCliente telaCadastro = new CadastroCliente();
				telaCadastro.setVisible(true);
			}
		});
		btnCadastrarCliente.setBackground(SystemColor.desktop);
		btnCadastrarCliente.setForeground(SystemColor.text);
		btnCadastrarCliente.setFont(new Font("Arial", Font.BOLD, 16));
		btnCadastrarCliente.setBounds(5, 11, 207, 68);
		contentPane.add(btnCadastrarCliente);
		
		JButton btnConsultarCliente = new JButton("CONSULTAR");
		btnConsultarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				TelaCliente telaCliente = new TelaCliente();
				telaCliente.setVisible(true);
			}
		});
		btnConsultarCliente.setBackground(SystemColor.desktop);
		btnConsultarCliente.setForeground(SystemColor.text);
		btnConsultarCliente.setFont(new Font("Arial", Font.BOLD, 16));
		btnConsultarCliente.setBounds(245, 11, 207, 68);
		contentPane.add(btnConsultarCliente);
	}

}
