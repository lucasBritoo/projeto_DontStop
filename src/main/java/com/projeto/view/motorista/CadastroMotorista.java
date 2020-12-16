package com.projeto.view.motorista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class CadastroMotorista extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblFoto;
	private JButton btnInserirFoto;
	private JLabel lblNewLabel_2;
	private JTextField txtNome;
	private JLabel lblNewLabel_3;
	private JTextField txtCPF;
	private JLabel lblNewLabel_4;
	private JTextField txtRG;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JRadioButton rdbtnFeminino;
	private JRadioButton rdbtnMasculino;
	private JLabel lblNewLabel_7;
	private JTextField txtDataNascimento;
	private JLabel lblNewLabel_8;
	private JLabel lblInformaesDeEndereo;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JTextField txtBlocoResidencial;
	private JLabel lblNewLabel_11;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextField txtNumeroResidencial;
	private JLabel lblNewLabel_12;
	private JTextField txtNumeroBloco;
	private JLabel lblNewLabel_13;
	private JTextField txtComplemento;
	private JButton btnSalvar;
	private JButton btnVoltar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroMotorista frame = new CadastroMotorista();
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
	public CadastroMotorista() {
		initComponents();
	}
	private void initComponents() {
		setTitle("CADASTRO DE MOTORISTA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("INFORMA\u00C7\u00D5ES B\u00C1SICAS");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		lblNewLabel_1 = new JLabel("______________________________________________________________________________________________________________________________");
		lblNewLabel_1.setForeground(Color.BLACK);
		
		lblFoto = new JLabel("");
		lblFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		btnInserirFoto = new JButton("INSERIR FOTO");
		btnInserirFoto.setIcon(new ImageIcon(CadastroMotorista.class.getResource("/com/projeto/estrutura/imagens/class.png")));
		
		lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtCPF = new JTextField();
		txtCPF.setColumns(10);
		
		lblNewLabel_4 = new JLabel("RG:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtRG = new JTextField();
		txtRG.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Sexo:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		
		lblNewLabel_6 = new JLabel("Telefone:");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 16));
		
		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setFont(new Font("Arial", Font.PLAIN, 14));
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblNewLabel_7 = new JLabel("Data Nascimento:");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtDataNascimento = new JTextField();
		txtDataNascimento.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Email:");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 16));
		
		lblInformaesDeEndereo = new JLabel("INFORMA\u00C7\u00D5ES DE ENDERE\u00C7O");
		lblInformaesDeEndereo.setForeground(Color.BLACK);
		lblInformaesDeEndereo.setFont(new Font("Arial", Font.PLAIN, 16));
		
		lblNewLabel_9 = new JLabel("______________________________________________________________________________________________________________________________");
		lblNewLabel_9.setForeground(Color.BLACK);
		
		lblNewLabel_10 = new JLabel("Bloco Residencial:");
		lblNewLabel_10.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtBlocoResidencial = new JTextField();
		txtBlocoResidencial.setColumns(10);
		
		lblNewLabel_11 = new JLabel("N\u00BA");
		lblNewLabel_11.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtTelefone = new JTextField();
		txtTelefone.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		
		txtNumeroResidencial = new JTextField();
		txtNumeroResidencial.setColumns(10);
		
		lblNewLabel_12 = new JLabel("N\u00BA Bloco:");
		lblNewLabel_12.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtNumeroBloco = new JTextField();
		txtNumeroBloco.setColumns(10);
		
		lblNewLabel_13 = new JLabel("Complemento:");
		lblNewLabel_13.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		
		btnSalvar = new JButton("SALVAR");
		btnSalvar.setIcon(new ImageIcon(CadastroMotorista.class.getResource("/com/projeto/estrutura/imagens/attach.png")));
		
		btnVoltar = new JButton("VOLTAR");
		btnVoltar.setIcon(new ImageIcon(CadastroMotorista.class.getResource("/com/projeto/estrutura/imagens/arrow_undo.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(btnInserirFoto, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(rdbtnFeminino, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addComponent(rdbtnMasculino)))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(2)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
											.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
											.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
											.addComponent(txtRG, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)))
									.addGroup(gl_contentPane.createSequentialGroup()
										.addGap(32)
										.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtDataNascimento)))))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInformaesDeEndereo, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtBlocoResidencial, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
								.addGap(26)
								.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(txtNumeroResidencial, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(txtNumeroBloco, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
										.addGap(36)
										.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))
									.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
										.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
										.addGap(53)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtComplemento)))))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(16)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtRG, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addComponent(btnInserirFoto, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(rdbtnFeminino)
						.addComponent(rdbtnMasculino)
						.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtDataNascimento, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblInformaesDeEndereo, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_9)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtBlocoResidencial, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtNumeroResidencial, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtNumeroBloco, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtComplemento, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
