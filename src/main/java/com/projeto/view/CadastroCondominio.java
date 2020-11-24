package com.projeto.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
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

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	public CadastroCondominio() {
		setFont(new Font("Arial Black", Font.BOLD, 18));
		setTitle("Cadastro de Condom\u00EDnio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nome do condom\u00EDnio:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtNomeCondominio = new JTextField();
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
		txtEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Digite uma senha:");
		lblNewLabel_3_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		passwordSenha = new JPasswordField();
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Deve conter no m\u00EDnimo 8 caracteres");
		lblNewLabel_3_1_1.setFont(new Font("Arial", Font.PLAIN, 12));
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Digite novamente sua senha:");
		lblNewLabel_3_1_2.setFont(new Font("Arial", Font.PLAIN, 16));
		
		passwordConfirmaSenha = new JPasswordField();
		
		JLabel lblNewLabel_3_1_2_1 = new JLabel("Telefone de contato:");
		lblNewLabel_3_1_2_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtTelefone = new JTextField();
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
		txtRua.setFont(new Font("Arial", Font.PLAIN, 14));
		txtRua.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("Arial", Font.PLAIN, 14));
		txtBairro.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP: ");
		lblCep.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Arial", Font.PLAIN, 14));
		txtNumero.setColumns(10);
		
		JLabel lblN = new JLabel("N\u00BA");
		lblN.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtCEP = new JTextField();
		txtCEP.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCEP.setColumns(10);
		
		JLabel lblCep_1 = new JLabel("Cidade:");
		lblCep_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Arial", Font.PLAIN, 14));
		txtCidade.setColumns(10);
		
		JLabel lblCep_1_1 = new JLabel("Complemento:");
		lblCep_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("Arial", Font.PLAIN, 14));
		txtComplemento.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JComboBox comBoxEstado = new JComboBox();
		comBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO"}));
		comBoxEstado.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("SALVAR");
		btnNewButton.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/attach.png")));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnNewButton_1 = new JButton("VOLTAR");
		btnNewButton_1.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/arrow_undo.png")));
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(txtEmail, Alignment.LEADING)
											.addComponent(txtNomeCondominio, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
										.addPreferredGap(ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE)
										.addGap(46)
										.addComponent(lblNewLabel_3_1_1, GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblRua, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblN, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
								.addGap(84)
								.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtCEP, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
								.addGap(56)
								.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(comBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3_1_2_1, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtTelefone))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_3_1_2, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(passwordConfirmaSenha, GroupLayout.PREFERRED_SIZE, 281, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblCep_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 264, GroupLayout.PREFERRED_SIZE)
								.addGap(45)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(btnNewButton_1)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblCep_1_1, GroupLayout.PREFERRED_SIZE, 113, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtComplemento, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)))
								.addPreferredGap(ComponentPlacement.RELATED, 25, Short.MAX_VALUE)))
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 249, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(35, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(219)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(439, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(txtNomeCondominio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordConfirmaSenha, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3_1_2_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRua, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNumero, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblN, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCEP, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(comBoxEstado, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCep_1)
						.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCep_1_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtComplemento, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
