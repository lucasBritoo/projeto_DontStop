package com.projeto.view.motorista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FilenameUtils;

import com.projeto.estrutura.util.VariaveisProjeto;
import com.projeto.model.models.Condominio;
import com.projeto.model.models.Motorista;
import com.projeto.model.models.Porteiro;
import com.projeto.model.service.MotoristaService;
import com.projeto.model.service.PorteiroService;
import com.projeto.view.condominio.CadastroCondominio;


import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTable;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroMotorista extends JDialog {

	
	private static final long serialVersionUID = 4235996973490753627L;
	
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
	private JLabel iconeCheck1;
	private JLabel iconeCheck2;
	private JLabel iconeCheck3;
	private JLabel iconeCheck4;
	private JLabel iconeCheck5;
	private JLabel iconeCheck6;
	private JLabel iconeCheck7;
	private JLabel iconeCheck8;
	private JLabel iconeCheck9;

	private JFileChooser fileChooser;
	private boolean fotoInserida =false;
	private byte[] byteFoto;
	private String extensaoFoto;
	
	private Condominio condominio;
	//private Porteiro porteiro;
	private Integer id_motorista;
	
	private JTable tabelaMotorista;
	private TabelaMotoristaModel tabelaMotoristaModel;
	
	private int linha = 0;
	private int acao = 0;
	
	private Integer id_porteiro;
	
	/**
	 * Launch the application.
	
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
	 */
	
	public CadastroMotorista(JFrame frame, boolean modal, JTable tabelaMotorista, TabelaMotoristaModel tabelaMotoristaModel, 
			int linha, int acao, Condominio condominio) {
		
		super(frame, modal);
		
		//this.porteiro = porteiro;
		this.condominio = condominio;
		this.tabelaMotorista = tabelaMotorista;
		this.tabelaMotoristaModel = tabelaMotoristaModel;
		this.linha = linha;
		this.acao = acao;
		
		initComponents();
		
		if(acao>=2) {
			buscarMotorista();
		}
	}
	private void initComponents() {
		setTitle("CADASTRO DE MOTORISTA");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		btnInserirFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirFoto();
			}
		});
		btnInserirFoto.setIcon(new ImageIcon(CadastroMotorista.class.getResource("/com/projeto/estrutura/imagens/class.png")));
		
		lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_TAB) {
					verificaNomeMotorista();
				}
			}
		});
		txtNome.setColumns(10);
		
		lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtCPF = new JTextField();
		txtCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_TAB) {
					verificaCPF();
				}
			}
		});
		txtCPF.setColumns(10);
		
		lblNewLabel_4 = new JLabel("RG:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtRG = new JTextField();
		txtRG.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_TAB) {
					verificaRG();
				}
			}
		});
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
		
		if(acao == 3) {
			btnSalvar.setText("EXCLUIR");
		}
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(acao == 1) {
					incluirMotorista();
				}
				if(acao == 2) {
					alterarMotorista();
				}
				
				if(acao == 3) {
					excluirMotorista();
				}
				
			}
		});
		btnSalvar.setIcon(new ImageIcon(CadastroMotorista.class.getResource("/com/projeto/estrutura/imagens/attach.png")));
		
		btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVoltar.setIcon(new ImageIcon(CadastroMotorista.class.getResource("/com/projeto/estrutura/imagens/arrow_undo.png")));
		
		iconeCheck1 = new JLabel("");
		
		
		iconeCheck2 = new JLabel("");
		
		iconeCheck3 = new JLabel("");
		
		iconeCheck4 = new JLabel("");
		
		iconeCheck5 = new JLabel("");
		
		iconeCheck6 = new JLabel("");
		
		iconeCheck7 = new JLabel("");
		
		iconeCheck8 = new JLabel("");
		
		iconeCheck9 = new JLabel("");
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
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addComponent(rdbtnMasculino))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(iconeCheck9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(iconeCheck5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(iconeCheck4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
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
											.addComponent(iconeCheck7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtDataNascimento)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(iconeCheck3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(iconeCheck2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(iconeCheck1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(iconeCheck6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblInformaesDeEndereo, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtBlocoResidencial, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
									.addGap(26)
									.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNumeroResidencial, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtNumeroBloco, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
											.addGap(36)
											.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
											.addGap(53)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtComplemento))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(iconeCheck8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
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
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(iconeCheck1)
									.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
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
										.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
										.addComponent(iconeCheck4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(iconeCheck2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addGap(30)
									.addComponent(iconeCheck3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(iconeCheck5, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(iconeCheck9, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnInserirFoto, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(rdbtnFeminino)
								.addComponent(rdbtnMasculino)
								.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtDataNascimento, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(iconeCheck6, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(lblInformaesDeEndereo, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(26)
							.addComponent(iconeCheck7, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_9)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
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
								.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addComponent(iconeCheck8, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private boolean verificaNomeMotorista() {
		if(VariaveisProjeto.digitacaoCampo(txtNome.getText())) {
			iconeCheck1.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtNome.requestFocus();
			return false;
		}
		else {
			iconeCheck1.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtCPF.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaCPF() {
		if(VariaveisProjeto.digitacaoCampo(txtCPF.getText())) {
			iconeCheck2.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtCPF.requestFocus();
			return false;
		}
		else {
			iconeCheck2.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtRG.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaRG() {
		if(VariaveisProjeto.digitacaoCampo(txtRG.getText())) {
			iconeCheck3.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtRG.requestFocus();
			return false;
		}
		else {
			iconeCheck3.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtTelefone.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaTelefone() {
		if(VariaveisProjeto.digitacaoCampo(txtTelefone.getText())) {
			iconeCheck4.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtTelefone.requestFocus();
			return false;
		}
		else {
			iconeCheck4.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtEmail.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaEmail() {
		if(VariaveisProjeto.digitacaoCampo(txtEmail.getText())) {
			iconeCheck5.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtEmail.requestFocus();
			return false;
		}
		else {
			iconeCheck5.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtDataNascimento.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaDataNascimento() {
		if(VariaveisProjeto.digitacaoCampo(txtDataNascimento.getText())) {
			iconeCheck6.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtDataNascimento.requestFocus();
			return false;
		}
		else {
			iconeCheck6.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			rdbtnFeminino.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaSexo() {
		if(!(rdbtnFeminino.isSelected() || rdbtnMasculino.isSelected())) {
			iconeCheck7.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			rdbtnFeminino.requestFocus();
			return false;
		}
		else {
			iconeCheck7.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtNumeroResidencial.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaNumero() {
		if(VariaveisProjeto.digitacaoCampo(txtNumeroResidencial.getText())) {
			iconeCheck8.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtNumeroResidencial.requestFocus();
			return false;
		}
		else {
			iconeCheck8.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtNumeroResidencial.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaFoto() {
		if(fotoInserida) {
			iconeCheck9.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			return true;
		}
		else {
			iconeCheck9.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			btnInserirFoto.requestFocus();
			return false;
		}
	}
	
	private boolean verificaDados() {
		if(verificaNomeMotorista() && verificaCPF() && verificaRG() && verificaTelefone() && verificaEmail() && verificaSexo() && verificaDataNascimento()
				&& verificaNumero() && verificaFoto()) {
			return true;
		}
		else return false;
	}
	
	
	
	public void inserirFoto() {
		fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagem", "jpg", "png");
		fileChooser.setFileFilter(filter);
		int retorno = fileChooser.showOpenDialog(this);
		
		if(retorno == JFileChooser.APPROVE_OPTION) {
			extensaoFoto = FilenameUtils.getExtension(fileChooser.getSelectedFile().getPath());
			
			ImageIcon image = new ImageIcon(fileChooser.getSelectedFile().getPath());
			image.setImage(image.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
			
			lblFoto.setIcon(image);
			fotoInserida = true;
			byteFoto = converterFoto();
		}
		else {
			fotoInserida = false;
		}
		
	}
	
	
	
	private byte[] converterFoto() {
		
		try {
			BufferedImage foto = ImageIO.read(new File(fileChooser.getSelectedFile().getPath()));
			ByteArrayOutputStream bytesImg = new ByteArrayOutputStream();
			
			if(extensaoFoto.equals("jpg")) {
				ImageIO.write((BufferedImage)foto, "jpg", bytesImg);
			}
			
			if(extensaoFoto.equals("png")) {
				ImageIO.write((BufferedImage)foto, "png", bytesImg);
			}
			
			bytesImg.flush();
			byte[] byteArray = bytesImg.toByteArray();
			bytesImg.close();
			
			return byteArray;
			
		}catch(Exception ex) {
			ex.printStackTrace();
			
			return null;
		}
	}
	
	
	
	private void exibirFoto(Motorista motorista) {
		
		byte[] foto = null;
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new ByteArrayInputStream(motorista.getFoto_motorista()));
			this.byteFoto = motorista.getFoto_motorista();
			lblFoto.setIcon(new ImageIcon(img));
			fotoInserida = true;
			
		}catch(IOException e) {
			e.printStackTrace();
			fotoInserida = false;
		}
		
	}
	
	protected void incluirMotorista() {
		Integer toReturn =0;
		Motorista motorista = pegarDadosMotorista();
		
		if(verificaDados()) {
			MotoristaService motoristaService = new MotoristaService();
			toReturn = motoristaService.save(motorista);
			JOptionPane.showMessageDialog(null, "Motorista inserido com sucesso");
			
			tabelaMotoristaModel.fireTableDataChanged();
			motorista = new Motorista();
		}
		
		else JOptionPane.showMessageDialog(null, "Erro ao incluir motorista, verifique os dados e tente novamente");
	}
	
	protected void alterarMotorista() {
		Integer toReturn =0;
		Motorista motorista = pegarDadosMotorista();
		motorista.setId_motorista(id_motorista);
		
		MotoristaService motoristaService = new MotoristaService();
		
		toReturn = motoristaService.update(motorista);
		
		if(toReturn == VariaveisProjeto.CAMPO_VAZIO) {
			verificaDados();
			showMensagem("Campo nome deve ser informado");
		}
		if(toReturn == VariaveisProjeto.ERRO_ALTERACAO) {
			showMensagem("Erro na alteração do registro");
		}
		if(toReturn == VariaveisProjeto.ALTERECAO_REALIZADA) {
			showMensagem( "Alteração foi realizada com sucesso");
			
			
			tabelaMotoristaModel.fireTableDataChanged();
			
			motorista = new Motorista();
			
		}
	}
	
	protected void excluirMotorista() {
		
		if(confirmarAcao()) {
			Integer toReturn = 0;
			
			Motorista motorista = pegarDadosMotorista();
			motorista.setId_motorista(id_motorista);
			
			MotoristaService motoristaService = new MotoristaService();
			
			toReturn = motoristaService.delete(motorista);
			
			if(toReturn == VariaveisProjeto.ERRO_EXCLUSAO) {
				showMensagem("Erro na exclusao do registro");
			}
			if(toReturn == VariaveisProjeto.EXCLUSAO_REALIZADA) {
				showMensagem( "Exclusao realizada com sucesso");
				motorista = new Motorista();
				dispose();
			}
		}
		
	}
	
	protected Motorista pegarDadosMotorista() {
		Motorista motorista = new Motorista();
		
		if(verificaDados()) {
			
			motorista.setNome_motorista(txtNome.getText());
			motorista.setCpf_Motorista(Integer.parseInt(txtCPF.getText()));
			motorista.setRg_Motorista(txtRG.getText());
			motorista.setTelefone_motorista(txtTelefone.getText());
			motorista.setEmail_motorista(txtEmail.getText());
			motorista.setData_nascimento_Motorista(txtDataNascimento.getText());
			motorista.setBloco_residencial(txtBlocoResidencial.getText());
			motorista.setComplemento(txtComplemento.getText());
			motorista.setN_bloco(txtNumeroBloco.getText());
			motorista.setNumero_residencia(txtNumeroResidencial.getText());
			motorista.setFoto_motorista(this.byteFoto);
			
			if(rdbtnFeminino.isSelected()) motorista.setSexo_motorista("feminino");
			
			if(rdbtnMasculino.isSelected()) motorista.setSexo_motorista("masculino");
			
			motorista.setCondominio(condominio);
			
			//motorista.setPorteiro(porteiro);
			
		}
		return motorista;
	}
	
	protected void buscarMotorista() {
		Motorista motorista = new Motorista();
		
		motorista = tabelaMotoristaModel.getMotorista(this.linha);
		
		txtNome.setText(motorista.getNome_motorista());
		txtCPF.setText(String.valueOf(motorista.getCpf_Motorista()));
		txtRG.setText(motorista.getRg_Motorista());
		txtDataNascimento.setText(motorista.getData_nascimento_Motorista());
		txtBlocoResidencial.setText(motorista.getBloco_residencial());
		txtNumeroResidencial.setText(motorista.getNumero_residencia());
		txtNumeroBloco.setText(motorista.getN_bloco());
		txtComplemento.setText(motorista.getComplemento());
		txtTelefone.setText(motorista.getTelefone_motorista());
		txtEmail.setText(motorista.getEmail_motorista());
		id_motorista = motorista.getId_motorista();
		
		if(motorista.getSexo_motorista().equals("feminino")) {
			rdbtnFeminino.setSelected(true);
		}
		else rdbtnMasculino.setSelected(true);
		
		exibirFoto(motorista);
		
	}
	
	private boolean confirmarAcao() {
		Object[] options = {"SIM", "NAO"};
		
		Integer confirmaAcao = JOptionPane.showOptionDialog(null, "DESEJA REALMENTE EXCLUIR ESTE CADASTRO?", "EXCLUIR", 
				0, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		
		if(confirmaAcao == 0) {
			return true;
		}
		
		else return false;
	}
	
	private void showMensagem(String mensagem) {
		JOptionPane.showMessageDialog(null, mensagem);
	}
}
