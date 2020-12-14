package com.projeto.view.condominio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projeto.estrutura.util.VariaveisProjeto;
import com.projeto.main.Login;
import com.projeto.model.models.Condominio;
import com.projeto.model.service.CondominioService;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


public class CadastroCondominio extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCondominio;
	private JTextField txtEmail;
	private JPasswordField passwordSenha;
	private JPasswordField passwordConfirmaSenha;
	private JTextField txtTelefone;
	private JTextField txtRua;
	private JTextField txtBairro;
	private JTextField txtNumero;
	private JTextField txtCEP;
	private JTextField txtCidade;
	private JTextField txtComplemento;
	private JComboBox comBoxEstado;
	private JButton btnSalvar;
	private JButton btnVoltar;
	
	
	private JLabel iconeErrado;
	private JLabel iconeErrado1;
	private JLabel iconeErrado2;
	private JLabel iconeErrado3;
	private JLabel iconeErrado4;
	private JLabel iconeErrado5;
	private JLabel iconeErrado6;
	private JLabel iconeErrado7;
	private JLabel iconeErrado8;
	private JLabel iconeErrado9;
	private JLabel lblSenhaErrada;
	private JLabel lblSenha8Caracteres;
	
	
	private Login login;
	
	
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCondominio frame = new CadastroCondominio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	
	public CadastroCondominio(Login login) {
		this.login = login;
		initiComponents();
		lblSenhaErrada.setVisible(false);
		lblSenha8Caracteres.setVisible(false);
	}
	
	private void initiComponents() {
		setFont(new Font("Arial Black", Font.BOLD, 18));
		setTitle("Cadastro de Condom\u00EDnio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nome do condom\u00EDnio:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtNomeCondominio = new JTextField();
		txtNomeCondominio.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaNomeCondominio();
				}
				if(e.getKeyCode() == KeyEvent.VK_TAB) {
					verificaNomeCondominio();
				}
			}

		});
		txtNomeCondominio.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNomeCondominio.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("INFORMA\u00C7\u00D5ES B\u00C1SICAS");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("______________________________________________________________________________________________________________________________");
		lblNewLabel_2.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_3 = new JLabel("Digite um email:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaEmail();
				}
			}

		});
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Digite uma senha:");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		passwordSenha = new JPasswordField();
		passwordSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaSenha();
				}
			}
		});
		
		lblSenha8Caracteres = new JLabel("Deve conter no m\u00EDnimo 8 caracteres");
		lblSenha8Caracteres.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Digite novamente sua senha:");
		lblNewLabel_3_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		
		passwordConfirmaSenha = new JPasswordField();
		passwordConfirmaSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaConfirmaSenha();
				}
			}
		});
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Telefone de contato:");
		lblNewLabel_3_1_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtTelefone = new JTextField();
		txtTelefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaTelefone();
				}
			}
		});
		txtTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
		txtTelefone.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("INFORMA\u00C7\u00D5ES DE ENDERE\u00C7O");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2_1 = new JLabel("______________________________________________________________________________________________________________________________");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtRua = new JTextField();
		txtRua.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaRua();
				}
			}
		});
		txtRua.setFont(new Font("Arial", Font.PLAIN, 14));
		txtRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtBairro = new JTextField();
		txtBairro.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaBairro();
				}
			}
		});
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 14));
		txtBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtNumero = new JTextField();
		txtNumero.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaNumero();
				}
			}
		});
		txtNumero.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNumero.setColumns(10);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtCEP = new JTextField();
		txtCEP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaCEP();
				}
			}
		});
		txtCEP.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCEP.setColumns(10);
		
		JLabel lblCep_1 = new JLabel("Cidade:");
		lblCep_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtCidade = new JTextField();
		txtCidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaCidade();
				}
			}
		});
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCidade.setColumns(10);
		
		JLabel lblCep_1_1 = new JLabel("Complemento:");
		lblCep_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Arial", Font.PLAIN, 14));
		txtComplemento.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 16));
		
		comBoxEstado = new JComboBox();
		comBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comBoxEstado.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				incluirCondominio();
			}
		});
		btnSalvar.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/attach.png")));
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 14));
		
		btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/arrow_undo.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 14));
			
		iconeErrado = new JLabel("");
		iconeErrado1 = new JLabel("");
		iconeErrado2 = new JLabel("");
		
		iconeErrado3 = new JLabel("");		
		iconeErrado4 = new JLabel("");		
		iconeErrado5 = new JLabel("");		
		iconeErrado6 = new JLabel("");		
		iconeErrado7 = new JLabel("");		
		iconeErrado8 = new JLabel("");		
		iconeErrado9 = new JLabel("");
		
		lblSenhaErrada = new JLabel("As senhas n\u00E3o s\u00E3o iguais");
		lblSenhaErrada.setFont(new Font("Arial", Font.PLAIN, 12));
				
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(iconeErrado2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(lblSenha8Caracteres, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtEmail)
										.addComponent(txtNomeCondominio, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(iconeErrado1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addComponent(iconeErrado)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(iconeErrado6, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblRua, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(iconeErrado5, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblN, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(iconeErrado7, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(64)
									.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtCEP, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(iconeErrado8, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(36)
									.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(comBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCep_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(iconeErrado9, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(25)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnVoltar)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblCep_1_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtComplemento, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblNewLabel_3_1_2_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(txtTelefone))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblNewLabel_3_1_2, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(passwordConfirmaSenha, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(iconeErrado3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblSenhaErrada, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
												.addGap(61))
											.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(iconeErrado4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED, 211, Short.MAX_VALUE))))
									.addComponent(lblNewLabel_2_1, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE)))
							.addGap(1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(219)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel)
								.addComponent(txtNomeCondominio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(iconeErrado1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
						.addComponent(iconeErrado))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblSenha8Caracteres, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addComponent(iconeErrado2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3_1_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordConfirmaSenha, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
								.addComponent(iconeErrado3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3_1_2_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
									.addGap(34)
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
								.addComponent(iconeErrado4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addComponent(lblSenhaErrada, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRua, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(iconeErrado5, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(iconeErrado6, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblN, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtCEP, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(comBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(iconeErrado8, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addComponent(iconeErrado7, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblCep_1)
								.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCep_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtComplemento, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)))
						.addComponent(iconeErrado9, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private boolean verificaNomeCondominio() {
		if(VariaveisProjeto.digitacaoCampo(txtNomeCondominio.getText())) {
			iconeErrado.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtNomeCondominio.requestFocus();
			return false;
		}
		else {
			iconeErrado.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtEmail.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaEmail() {
		if(VariaveisProjeto.digitacaoCampo(txtEmail.getText())) {
			iconeErrado1.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtEmail.requestFocus();
			return false;
		}
		else {
			iconeErrado1.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			passwordSenha.requestFocus();
			return true;
		}
	}
	
	private boolean verificaSenha() {
		if(VariaveisProjeto.digitacaoCampo(new String (passwordSenha.getPassword()))) {
			iconeErrado2.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			lblSenha8Caracteres.setVisible(true);
			passwordSenha.requestFocus();
			return false;
		}
		else {
			if(passwordSenha.getPassword().length < 8) {
				iconeErrado2.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
				lblSenha8Caracteres.setVisible(true);
				passwordSenha.requestFocus();
				return false;
			}
			else {
				iconeErrado2.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
				lblSenha8Caracteres.setVisible(false);
				passwordConfirmaSenha.requestFocus();
				return true;
			}
			
		}
	}
	
	private boolean verificaConfirmaSenha() {
		if(VariaveisProjeto.digitacaoCampo(new String (passwordConfirmaSenha.getPassword()))) {
			iconeErrado3.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			passwordConfirmaSenha.requestFocus();
			return false;
		}
		else {
			if(new String(passwordSenha.getPassword()).equals(new String (passwordConfirmaSenha.getPassword()))) {
				iconeErrado3.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
				lblSenhaErrada.setVisible(false);
				txtTelefone.requestFocus();
				return true;
			}
			else {
				iconeErrado3.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
				lblSenhaErrada.setVisible(true);
				passwordConfirmaSenha.requestFocus();
				return false;
			}
		}
	}
	
	private boolean verificaTelefone() {
		if(VariaveisProjeto.digitacaoCampo(txtTelefone.getText())) {
			iconeErrado4.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtTelefone.requestFocus();
			return false;
		}
		else {
			iconeErrado4.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtRua.requestFocus();
			return true;
		}
	}
	
	private boolean verificaRua() {
		if(VariaveisProjeto.digitacaoCampo(txtRua.getText())) {
			iconeErrado5.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtRua.requestFocus();
			return false;
			
		}
		else {
			iconeErrado5.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtBairro.requestFocus();
			return true;
		}
	}
	
	private boolean verificaBairro() {
		if(VariaveisProjeto.digitacaoCampo(txtBairro.getText())) {
			iconeErrado6.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtBairro.requestFocus();
			return false;
		}
		else {
			iconeErrado6.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtNumero.requestFocus();
			return true;
		}
	}
	
	private boolean verificaNumero() {
		if(VariaveisProjeto.digitacaoCampo(txtNumero.getText())) {
			iconeErrado7.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtNumero.requestFocus();
			return false;
		}
		else {
			iconeErrado7.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtCEP.requestFocus();
			return true;
		}
	}
	
	private boolean verificaCEP() {
		if(VariaveisProjeto.digitacaoCampo(txtCEP.getText())) {
			iconeErrado8.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtCEP.requestFocus();
			return false;
		}
		else {
			iconeErrado8.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			comBoxEstado.requestFocus();
			return true;
		}
	}
	
	private boolean verificaCidade() {
		if(VariaveisProjeto.digitacaoCampo(txtCEP.getText())) {
			iconeErrado9.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtCidade.requestFocus();
			return false;
		}
		else {
			iconeErrado9.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtComplemento.requestFocus();
			return true;
		}
	}
	
	protected void incluirCondominio() {
		Integer toReturn =0;
		Condominio condominio = pegarDadosCondominio();
		
		if(verificaCampos()) {
			CondominioService condominioService= new CondominioService();
			toReturn = condominioService.save(condominio);
			JOptionPane.showMessageDialog(null, "Condomínio inserido com sucesso");
		}
		
		else JOptionPane.showMessageDialog(null, "Erro ao incluir condomínio, verifique seus dados e tente novamente");
		
	
	}
	
	public Condominio pegarDadosCondominio() {
		Condominio condominio = new Condominio();
		
		if(verificaCampos()) {
			condominio.setNome_condominio(txtNomeCondominio.getText());
			condominio.setEmail(txtEmail.getText());
			condominio.setSenha(new String(passwordSenha.getPassword()));
			condominio.setTelefone(txtTelefone.getText());
			condominio.setLogradouro(txtRua.getText());
			condominio.setBairro(txtBairro.getText());
			condominio.setN_instituicao(VariaveisProjeto.convertToInteger(txtNumero.getText()));
			condominio.setCep(txtCEP.getText());
			condominio.setEstado((String) comBoxEstado.getSelectedItem());
			condominio.setCidade(txtCidade.getText());
			condominio.setComplemento(txtComplemento.getText());
			
		}
		return condominio;

	}

	private boolean verificaCampos() {
		if(verificaNomeCondominio() && verificaEmail() && verificaSenha() && verificaConfirmaSenha() && verificaTelefone() && verificaRua()
		&& verificaBairro() && verificaNumero() && verificaCEP() && verificaCidade()) {
			return true;
		}
		else return false;

	}
	
}

