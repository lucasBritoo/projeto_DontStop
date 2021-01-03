package com.projeto.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projeto.model.models.Condominio;
import com.projeto.model.models.Porteiro;
import com.projeto.model.service.CondominioService;
import com.projeto.model.service.PorteiroService;
import com.projeto.view.condominio.CadastroCondominio;
import com.projeto.view.menu.MenuCondominio;
import com.projeto.view.trocaSenha.TelaEsqueceuSenha;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JLabel lblInvalido;
	private JLabel lblEsqueceuSenha;
	private JPasswordField passwordSenha;
	
	private static Login frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/com/projeto/estrutura/imagens/logoCarro.png")));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/com/projeto/estrutura/imagens/titulo.png")));
		
		JLabel lblNewLabel_2 = new JLabel("O NOVO CONCEITO DE CONTROLE PARA PORTARIAS");
		lblNewLabel_2.setFont(new Font("Lucida Console", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("Digite seu email:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 14));
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					validarDados();
				}
			}
		});
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
		btnAcessar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					validarDados();
				}
			}
		});
		btnAcessar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarDados();
			}

		});
		btnAcessar.setIcon(new ImageIcon(Login.class.getResource("/com/projeto/estrutura/imagens/application_go.png")));
		btnAcessar.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_6 = new JLabel("DESENVOLVIDO POR LUCAS BRITO");
		lblNewLabel_6.setFont(new Font("Arial Black", Font.BOLD, 11));
		
		lblInvalido = new JLabel("    ");
		lblInvalido.setForeground(Color.RED);
		lblInvalido.setFont(new Font("Arial", Font.PLAIN, 12));
		
		passwordSenha = new JPasswordField();
		passwordSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					validarDados();
				}
			}
		});
		
		JButton btnNovoCadastro = new JButton("NOVO CADASTRO");
		btnNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novoCadastro();
			}

		});
		btnNovoCadastro.setIcon(new ImageIcon(Login.class.getResource("/com/projeto/estrutura/imagens/application_add.png")));
		btnNovoCadastro.setFont(new Font("Arial", Font.PLAIN, 16));
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
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(4)
										.addComponent(btnAcessar)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnNovoCadastro))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(37)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblEsqueceuSenha, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
												.addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)))))
								.addComponent(lblInvalido, GroupLayout.PREFERRED_SIZE, 296, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(235)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(259)
							.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)))
					.addGap(130))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblEsqueceuSenha)
							.addGap(26)
							.addComponent(lblInvalido)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnAcessar)
								.addComponent(btnNovoCadastro, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblNewLabel))
					.addGap(92)
					.addComponent(lblNewLabel_6)
					.addContainerGap(18, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	
	private void validarDados() {
		
		if(txtEmail.getText().equals("") || passwordSenha.getPassword().length == 0) {
			credenciaisInvalidas();
		}
		
		else {
			
			CondominioService condominioService = new CondominioService();
			PorteiroService porteiroService = new PorteiroService();
			
			List<Condominio> listaCondominio = condominioService.findEmail(txtEmail.getText());
			List<Porteiro> listaPorteiro = porteiroService.findByEmail(txtEmail.getText());
			
			if(listaCondominio.isEmpty() && listaPorteiro.isEmpty()) {
				credenciaisInvalidas();
			}
			
			else {
				
				if(!listaCondominio.isEmpty()) {
					for(Condominio condominio: listaCondominio) {
						if(condominio.getEmail().equals(txtEmail.getText()) && condominio.getSenha().equals(new String(passwordSenha.getPassword()))) {
							acessoMenuCondominio(condominio);
							this.setVisible(false);
							limpaCampos();
							
						}
						else {
							credenciaisInvalidas();
						}
					}
				}
			
				if(!listaPorteiro.isEmpty()) {
					for(Porteiro porteiro: listaPorteiro) {
						if(porteiro.getEmail().equals(txtEmail.getText()) && porteiro.getSenha().equals(new String(passwordSenha.getPassword()))) {
							acessoMenuPorteiro(porteiro);
							this.setVisible(false);
							limpaCampos();
							
						}
						else {
							credenciaisInvalidas();
						}
					}
				}
				
			}
		}
	}
	
	private void acessoMenuCondominio(Condominio condominio) {
		MenuCondominio menuCondominio = new MenuCondominio(frame, condominio);
		//menuCondominio.setCondominio(condominio);
		menuCondominio.setResizable(false);
		menuCondominio.setExtendedState(JFrame.MAXIMIZED_BOTH);
		menuCondominio.setVisible(true);
		

	}
	
	private void acessoMenuPorteiro(Porteiro porteiro) {
		
	}
	
	private void esqueceuSenha() {
		TelaEsqueceuSenha telaEsqueceuSenha = new TelaEsqueceuSenha(frame);
		telaEsqueceuSenha.setVisible(true);
		limpaCampos();
		this.setVisible(false);
	}
	
	private void novoCadastro() {
		CadastroCondominio cadastroCondominio = new CadastroCondominio(frame);
		cadastroCondominio.setVisible(true);
		limpaCampos();
		this.setVisible(false);
	}
	
	private void limpaCampos() {
		txtEmail.setText("");
		passwordSenha.setText("");
	}
	
	private void credenciaisInvalidas() {
		txtEmail.setText("");
		passwordSenha.setText("");
		lblInvalido.setText("Credenciais inv\u00E1lidas. Verifique e tente novamente");
	}
}
