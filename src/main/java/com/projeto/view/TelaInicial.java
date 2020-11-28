package com.projeto.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projeto.model.models.Condominio;
import com.projeto.model.service.CondominioService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JLabel lblInvalido;
	private JLabel lblEsqueceuSenha;
	private JPasswordField passwordSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/com/projeto/estrutura/imagens/logoCarro.png")));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaInicial.class.getResource("/com/projeto/estrutura/imagens/titulo.png")));
		
		JLabel lblNewLabel_2 = new JLabel("O NOVO CONCEITO DE CONTROLE PARA PORTARIAS");
		lblNewLabel_2.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("Digite seu email:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Digite sua senha:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblEsqueceuSenha = new JLabel("Esqueceu sua senha? Clique aqui.");
		lblEsqueceuSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				esqueceuSenha();
			}

		});
		lblEsqueceuSenha.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		
		JButton btnAcessar = new JButton("ACESSAR");
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarDados();
			}

		});
		btnAcessar.setIcon(new ImageIcon(TelaInicial.class.getResource("/com/projeto/estrutura/imagens/application_go.png")));
		btnAcessar.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_6 = new JLabel("DESENVOLVIDO POR LUCAS BRITO");
		lblNewLabel_6.setFont(new Font("Arial Black", Font.BOLD, 11));
		
		lblInvalido = new JLabel("Credenciais inv\u00E1lidas. Verifique e tente novamente");
		lblInvalido.setForeground(Color.RED);
		lblInvalido.setFont(new Font("Arial", Font.PLAIN, 12));
		
		passwordSenha = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(66)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 417, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addComponent(lblNewLabel)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(28)
									.addComponent(lblInvalido, GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordSenha, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblEsqueceuSenha, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(235)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(259)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(34, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(520, Short.MAX_VALUE)
					.addComponent(btnAcessar)
					.addGap(129))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addComponent(lblNewLabel))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(45)
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(23)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addGap(12)
							.addComponent(lblEsqueceuSenha)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblInvalido)))
					.addGap(9)
					.addComponent(btnAcessar)
					.addGap(56)
					.addComponent(lblNewLabel_6)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		lblInvalido.setVisible(false);
	}
	
	
	private void validarDados() {
		
		if(txtEmail.getText().equals("") || passwordSenha.getPassword().length == 0) {
			credenciaisInvalidas();
		}
		
		
		else {
			
			CondominioService condominioService = new CondominioService();
			
			List<Condominio> listaCondominio = condominioService.findEmail(txtEmail.getText());
			
			if(listaCondominio.isEmpty()) {
				credenciaisInvalidas();
				
			}
			else {
				for(Condominio condominio: listaCondominio) {
					if(condominio.getEmail().equals(txtEmail.getText()) && condominio.getSenha().equals(new String(passwordSenha.getPassword()))) {
						JOptionPane.showMessageDialog(null, "Entrou parça");
					}
					else {
						credenciaisInvalidas();
					}
				}
				
			}
		}
	}
	private void esqueceuSenha() {
		JOptionPane.showMessageDialog(null, "Entrou parça");
	}
	

	private void credenciaisInvalidas() {
		txtEmail.setText("");
		passwordSenha.setText("");
		lblInvalido.setVisible(true);
	}
}
