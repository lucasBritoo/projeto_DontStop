package com.projeto.view.porteiro;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FilenameUtils;

import com.projeto.estrutura.util.VariaveisProjeto;
import com.projeto.model.models.Condominio;
import com.projeto.model.models.Porteiro;
import com.projeto.model.service.MotoristaService;
import com.projeto.model.service.PorteiroService;
import com.projeto.view.condominio.CadastroCondominio;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

public class CadastroPorteiro extends JDialog {

	
	private static final long serialVersionUID = 2221180777478057672L;
	
	private JPanel contentPane;
	private JPasswordField passwordConfirmaSenha;
	private JTextField txtNome;
	private JTextField txtCPF;
	private JTextField txtRG;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JPasswordField passwordSenha;
	private JLabel lblFoto;
	
	private JLabel icone1;
	private JLabel icone2;
	private JLabel icone3;
	private JLabel icone4;
	private JLabel icone5;
	private JLabel icone6;
	private JLabel icone7;
	private JLabel lblSenhaErrada;
	private JLabel lblSenhasDiferentes;
	private JButton btnSalvar;
	
	private JFileChooser fileChooser;
	private boolean fotoInserida = false;
	private byte[] byteFoto = null;
	
	private Condominio condominio;
	
	private JTable tabelaPorteiro;
	private TabelaPorteiroModel tabelaPorteiroModel;
	
	private int linha = 0;
	private int acao = 0;
	private JLabel iconeCheckFoto;
	
	private Integer id_porteiro;
	private String extensaoFoto;

	/**
	 * Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroPorteiro frame = new CadastroPorteiro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 */
	
	public CadastroPorteiro(JFrame frame, boolean modal, JTable tabelaPorteiro, TabelaPorteiroModel tabelaPorteiroModel, int linha, int acao, Condominio condominio) {
		super(frame, modal);
	
		this.condominio = condominio;
		this.tabelaPorteiro = tabelaPorteiro;
		this.tabelaPorteiroModel = tabelaPorteiroModel;
		this.linha = linha;
		this.acao = acao;
		
		initComponents();
		
		lblSenhaErrada.setVisible(false);
		lblSenhasDiferentes.setVisible(false);
		
		if(acao>=2) {
			buscarPorteiro();
		}
	}
	
	private void initComponents() {
		setTitle("CADASTRO DE PORTEIRO");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("INFORMA\u00C7\u00D5ES B\u00C1SICAS");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("______________________________________________________________________________________________________________________________");
		lblNewLabel_2.setForeground(Color.BLACK);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_4 = new JLabel("RG:");
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_5 = new JLabel("Telefone:");
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2_1 = new JLabel("______________________________________________________________________________________________________________________________");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		
		JLabel lblNewLabel_1_1 = new JLabel("INFORMA\u00C7\u00D5ES DE ACESSO");
		lblNewLabel_1_1.setForeground(Color.BLACK);
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_6 = new JLabel("Digite um email:");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_7 = new JLabel("Digite uma senha:");
		lblNewLabel_7.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblNewLabel_8 = new JLabel("Cofirme sua senha:");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 16));
		
		passwordConfirmaSenha = new JPasswordField();
		passwordConfirmaSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaConfirmaSenha();
				}
			}
		});
		
		btnSalvar = new JButton("SALVAR");
		
		if(acao == 3) {
			btnSalvar.setText("EXCLUIR");
		}
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(acao == 1) {
					incluirPorteiro();
				}
				
				if(acao == 2) {
					alterarPorteiro();
				}
				
				if(acao == 3) {
					excluirPorteiro();
				}
			}
		});
		btnSalvar.setIcon(new ImageIcon(CadastroPorteiro.class.getResource("/com/projeto/estrutura/imagens/attach.png")));
		btnSalvar.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JButton btnVoltar = new JButton("VOLTAR");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		btnVoltar.setIcon(new ImageIcon(CadastroPorteiro.class.getResource("/com/projeto/estrutura/imagens/arrow_undo.png")));
		btnVoltar.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaNome();
					verificaFoto();
				}
				
			}
		});
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaCPF();
				}
			}
		});
		txtCPF.setColumns(10);
		
		txtRG = new JTextField();
		txtRG.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaRG();
				}
			}
		});
		txtRG.setColumns(10);
		
		txtTelefone = new JTextField();
		txtTelefone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaTelefone();
				}
			}
		});
		txtTelefone.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaEmail();
				}
			}
		});
		txtEmail.setColumns(10);
		
		JButton btnInserirFoto = new JButton("INSERIR FOTO");
		btnInserirFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirFoto();
			}
		});
		btnInserirFoto.setIcon(new ImageIcon(CadastroPorteiro.class.getResource("/com/projeto/estrutura/imagens/class.png")));
		
		passwordSenha = new JPasswordField();
		passwordSenha.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					verificaSenha();
				}
			}
		});
		
		lblFoto = new JLabel("");
		lblFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		icone1 = new JLabel("");
		icone2 = new JLabel("");
		icone3 = new JLabel("");
		icone4 = new JLabel("");
		icone5 = new JLabel("");		
		icone6 = new JLabel("");		
		icone7 = new JLabel("");
		
		lblSenhaErrada = new JLabel("Deve conter no m\u00EDnimo 8 caracteres");
		lblSenhaErrada.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblSenhaErrada.setForeground(new Color(255, 0, 0));
		
		lblSenhasDiferentes = new JLabel("As senhas n\u00E3o s\u00E3o iguais");
		lblSenhasDiferentes.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblSenhasDiferentes.setForeground(Color.RED);
		
		iconeCheckFoto = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(211)
							.addComponent(btnSalvar)
							.addGap(78)
							.addComponent(btnVoltar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(21)
							.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtTelefone))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(14)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(txtNome)
											.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))
										.addComponent(txtRG))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(icone4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(icone3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(icone1)
									.addComponent(icone2, GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(55)
							.addComponent(btnInserirFoto)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(iconeCheckFoto, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_8)
										.addComponent(lblNewLabel_7)
										.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
										.addComponent(passwordSenha)
										.addComponent(passwordConfirmaSenha))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(icone6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblSenhaErrada))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(icone7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblSenhasDiferentes, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))
										.addComponent(icone5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE))))
					.addGap(35))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(8)
									.addComponent(lblNewLabel)
									.addGap(28)
									.addComponent(lblNewLabel_3))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
										.addComponent(icone1))
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(icone2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_4)
										.addComponent(txtRG, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
									.addGap(29)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel_5)
										.addComponent(icone4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
								.addComponent(icone3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
						.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnInserirFoto)
						.addComponent(iconeCheckFoto, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2_1)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_6)
							.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
						.addComponent(icone5, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(15)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_7)
							.addComponent(passwordSenha, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblSenhaErrada)
							.addComponent(icone6, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8)
								.addComponent(passwordConfirmaSenha, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnSalvar)
								.addComponent(btnVoltar)))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblSenhasDiferentes)
							.addComponent(icone7, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	

	private boolean verificaNome() {
		if(VariaveisProjeto.digitacaoCampo(txtNome.getText())) {
			icone1.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtNome.requestFocus();
			return false;
		}
		else {
			icone1.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtCPF.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaCPF() {
		if(VariaveisProjeto.digitacaoCampo(txtCPF.getText())) {
			icone2.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtCPF.requestFocus();
			return false;
		}
		else {
			icone2.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtRG.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaRG() {
		if(VariaveisProjeto.digitacaoCampo(txtRG.getText())) {
			icone3.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtRG.requestFocus();
			return false;
		}
		else {
			icone3.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtTelefone.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaTelefone() {
		if(VariaveisProjeto.digitacaoCampo(txtTelefone.getText())) {
			icone4.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtTelefone.requestFocus();
			return false;
		}
		else {
			icone4.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtEmail.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaEmail() {
		if(VariaveisProjeto.digitacaoCampo(txtEmail.getText())) {
			icone5.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtEmail.requestFocus();
			return false;
		}
		else {
			icone5.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			passwordSenha.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaSenha() {
		if(VariaveisProjeto.digitacaoCampo(new String (passwordSenha.getPassword()))) {
			icone6.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			lblSenhaErrada.setVisible(true);
			passwordSenha.requestFocus();
			return false;
		}
		else {
			if(passwordSenha.getPassword().length < 8) {
				icone6.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
				lblSenhaErrada.setVisible(true);
				passwordSenha.requestFocus();
				return false;
			}
			else {
				icone6.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
				lblSenhaErrada.setVisible(false);
				passwordConfirmaSenha.requestFocus();
				return true;
			}
			
		}
	}
	
	private boolean verificaConfirmaSenha() {
		if(VariaveisProjeto.digitacaoCampo(new String (passwordConfirmaSenha.getPassword()))) {
			icone7.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			passwordConfirmaSenha.requestFocus();
			return false;
		}
		else {
			if(new String(passwordSenha.getPassword()).equals(new String (passwordConfirmaSenha.getPassword()))) {
				icone7.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
				lblSenhasDiferentes.setVisible(false);
				return true;
			}
			else {
				icone7.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
				lblSenhasDiferentes.setVisible(true);
				passwordConfirmaSenha.requestFocus();
				return false;
			}
		}
	}
	
	private boolean verificaFoto() {
		if(fotoInserida) {
			iconeCheckFoto.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			return true;
		}
		else {
			iconeCheckFoto.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			return false;
		}
	}
	
	public boolean verificaCampos() {
		
		if(verificaNome() && verificaCPF() && verificaRG() && verificaTelefone() && verificaEmail() && verificaSenha() &&
				verificaConfirmaSenha() && verificaFoto()) {
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
			
			if(extensaoFoto.equals("png")) {
				ImageIO.write((BufferedImage)foto, "png", bytesImg);
			}
			
			if(extensaoFoto.equals("jpg")) {
				ImageIO.write((BufferedImage)foto, "jpg", bytesImg);
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
	
	
	private void exibirFoto(Porteiro porteiro) {
	
		byte[] foto = null;
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new ByteArrayInputStream(porteiro.getFoto_porteiro()));
			this.byteFoto = porteiro.getFoto_porteiro();
			lblFoto.setIcon(new ImageIcon(img));
			fotoInserida = true;
			
		}catch(IOException e) {
			e.printStackTrace();
			fotoInserida = false;
		}
		
	}
	
	protected void incluirPorteiro() {
		Integer toReturn =0;
		Porteiro porteiro = pegarDados();
		
		if(verificaCampos()) {
			PorteiroService porteiroService= new PorteiroService();
			toReturn = porteiroService.save(porteiro);
			JOptionPane.showMessageDialog(null, "Porteiro inserido com sucesso");
			
			tabelaPorteiroModel.fireTableDataChanged();
			porteiro = new Porteiro();
		}
		
		else JOptionPane.showMessageDialog(null, "Erro ao incluir porteiro, verifique seus dados e tente novamente");
		
	
	}
	
	protected void alterarPorteiro() {
		Integer toReturn =0;
		Porteiro porteiro = pegarDados();
		porteiro.setId_porteiro(id_porteiro);
		
		PorteiroService porteiroService = new PorteiroService();
		
		toReturn = porteiroService.update(porteiro);
		
		if(toReturn == VariaveisProjeto.CAMPO_VAZIO) {
			verificaCampos();
			showMensagem("Campo nome deve ser informado");
		}
		if(toReturn == VariaveisProjeto.ERRO_ALTERACAO) {
			showMensagem("Erro na alteração do registro");
		}
		if(toReturn == VariaveisProjeto.ALTERECAO_REALIZADA) {
			showMensagem( "Alteração foi realizada com sucesso");
			
			tabelaPorteiroModel.fireTableDataChanged();
			
			porteiro = new Porteiro();
			
		}
	}
	
	private void excluirPorteiro() {
		
		if(confirmarAcao()) {
			Integer toReturn = 0;
			
			Porteiro porteiro = pegarDados();
			porteiro.setId_porteiro(id_porteiro);
			
			PorteiroService porteiroService = new PorteiroService();
			
			toReturn = porteiroService.delete(porteiro);
			
			if(toReturn == VariaveisProjeto.ERRO_EXCLUSAO) {
				showMensagem("Erro na exclusao do registro");
			}
			if(toReturn == VariaveisProjeto.EXCLUSAO_REALIZADA) {
				showMensagem( "Exclusao realizada com sucesso");
				porteiro = new Porteiro();
				dispose();
			}
		}
		
	}

	public Porteiro pegarDados() {
		Porteiro porteiro  = new Porteiro();
		
		if(verificaCampos()) {
			porteiro.setNome_Porteiro(txtNome.getText());
			porteiro.setCpf_Porteiro(Integer.parseInt((txtCPF.getText())));
			porteiro.setRg_Porteiro(txtRG.getText());
			porteiro.setEmail(txtEmail.getText());
			porteiro.setSenha(new String(passwordSenha.getPassword()));
			porteiro.setTelefone(txtTelefone.getText());
			porteiro.setCondominio(condominio);
			porteiro.setFoto_porteiro(this.byteFoto);
		}
			
		return porteiro;
	}
	
	private void buscarPorteiro() {
		Porteiro porteiro = new Porteiro();
		
		
		porteiro = tabelaPorteiroModel.getPorteiro(this.linha);
		
		txtNome.setText(porteiro.getNome_Porteiro());
		txtCPF.setText(String.valueOf(porteiro.getCpf_Porteiro()));
		txtRG.setText(porteiro.getRg_Porteiro());
		txtTelefone.setText(porteiro.getTelefone());
		txtEmail.setText(porteiro.getEmail());
		passwordSenha.setText(porteiro.getSenha());
		passwordConfirmaSenha.setText(porteiro.getSenha());
		id_porteiro = porteiro.getId_porteiro();
		exibirFoto(porteiro);
		
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
