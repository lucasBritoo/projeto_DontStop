package com.projeto.view.veiculo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FilenameUtils;

import com.projeto.estrutura.util.VariaveisProjeto;
import com.projeto.model.models.Condominio;
import com.projeto.model.models.Motorista;
import com.projeto.model.models.Veiculo;
import com.projeto.model.service.MotoristaService;
import com.projeto.model.service.VeiculoService;
import com.projeto.view.condominio.CadastroCondominio;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CadastroVeiculo extends JDialog {

	
	private static final long serialVersionUID = -3228887371797173245L;
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblFoto;
	private JButton btnInserirFoto;
	private JLabel lblPlaca;
	private JTextField txtPlaca;
	private JLabel lblDocumento;
	private JTextField txtDocumento;
	private JLabel lblCor;
	private JTextField txtCor;
	private JTextField txtMarca;
	private JLabel lblMarca;
	private JTextField txtModelo;
	private JLabel lblModelo;
	private JTextField txtAno;
	private JLabel lblModelo_1;
	private JLabel lblInformaesDeEndereo;
	private JLabel lblNewLabel_2;
	private JLabel lblModelo_2;
	private JTextField txtCPFMotorista;
	private JButton btnBuscar;
	private JLabel lblModelo_3;
	private JTextField txtNomeMotorista;
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

	
	
	private JFileChooser fileChooser;
	private boolean fotoInserida =false;
	private byte[] byteFoto;
	private String extensaoFoto;
	
	private String cpf_motorista;
	
	private Motorista motorista;
	private Integer id_veiculo;
	
	
	private JTable tabelaVeiculo;
	private TabelaVeiculoModel tabelaVeiculoModel;
	
	private int linha = 0;
	private int acao = 0;
	
	/**
	 * Launch the application.
	

	/**
	 * Create the frame.
	 */
	
	public CadastroVeiculo(JFrame frame, boolean modal, JTable tabelaVeiculo, TabelaVeiculoModel tabelaVeiculoModel, 
			int linha, int acao) {

		super(frame, modal);
		
		//this.motorista = motorista;
		this.tabelaVeiculo = tabelaVeiculo;
		this.tabelaVeiculoModel = tabelaVeiculoModel;
		this.linha = linha;
		this.acao = acao;
		
		initComponents();
		
		if(acao>=2) {
			buscarVeiculo();
		}
		
		configuraFrame(acao);
	}
	private void initComponents() {
		setTitle("CADASTRO DE VE\u00CDCULO");
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblNewLabel = new JLabel("______________________________________________________________________________________________________________________________");
		lblNewLabel.setForeground(Color.BLACK);
		
		lblNewLabel_1 = new JLabel("INFORMA\u00C7\u00D5ES B\u00C1SICAS");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		lblFoto = new JLabel("");
		lblFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		btnInserirFoto = new JButton("INSERIR FOTO");
		btnInserirFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inserirFoto();
			}
		});
		
		lblPlaca = new JLabel("Placa:");
		lblPlaca.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtPlaca = new JTextField();
		txtPlaca.setColumns(10);
		
		lblDocumento = new JLabel("Documento:");
		lblDocumento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDocumento.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtDocumento = new JTextField();
		txtDocumento.setColumns(10);
		
		lblCor = new JLabel("Cor:");
		lblCor.setHorizontalAlignment(SwingConstants.LEFT);
		lblCor.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtCor = new JTextField();
		txtCor.setColumns(10);
		
		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		
		lblMarca = new JLabel("Marca:");
		lblMarca.setHorizontalAlignment(SwingConstants.LEFT);
		lblMarca.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		
		lblModelo = new JLabel("Modelo:");
		lblModelo.setHorizontalAlignment(SwingConstants.LEFT);
		lblModelo.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtAno = new JTextField();
		txtAno.setColumns(10);
		
		lblModelo_1 = new JLabel("Ano:");
		lblModelo_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblModelo_1.setFont(new Font("Arial", Font.PLAIN, 16));
		
		lblInformaesDeEndereo = new JLabel("INFORMA\u00C7\u00D5ES DE ENDERE\u00C7O");
		lblInformaesDeEndereo.setForeground(Color.BLACK);
		lblInformaesDeEndereo.setFont(new Font("Arial", Font.PLAIN, 16));
		
		lblNewLabel_2 = new JLabel("______________________________________________________________________________________________________________________________");
		lblNewLabel_2.setForeground(Color.BLACK);
		
		lblModelo_2 = new JLabel("CPF do motorista:");
		lblModelo_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblModelo_2.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtCPFMotorista = new JTextField();
		txtCPFMotorista.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarMotorista();
			}
		});
		
		lblModelo_3 = new JLabel("Nome do motorista:");
		lblModelo_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblModelo_3.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtNomeMotorista = new JTextField();
		txtNomeMotorista.setEditable(false);
		txtNomeMotorista.setColumns(10);
		
		btnSalvar = new JButton();
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(acao == 1) {
					incluirVeiculo();
				}
				if(acao == 2) {
					alterarVeiculo();
				}
				
				if(acao == 3) {
					excluirVeiculo();
				}
			}
		});
		
		btnVoltar = new JButton("VOLTAR");
		
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		iconeCheck1 = new JLabel("");
		
		iconeCheck2 = new JLabel("");
		
		iconeCheck3 = new JLabel("");
		
		iconeCheck4 = new JLabel("");
		
		iconeCheck5 = new JLabel("");
		
		iconeCheck6 = new JLabel("");
		
		iconeCheck7 = new JLabel("");
		
		iconeCheck8 = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(257)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblDocumento)
										.addComponent(lblPlaca, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblCor, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblMarca, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblModelo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblModelo_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
									.addGap(27)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDocumento, 273, 273, 273)
										.addComponent(txtCor, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(iconeCheck6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(iconeCheck5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(iconeCheck4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(iconeCheck3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(iconeCheck2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(iconeCheck1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(20)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(38)
									.addComponent(btnInserirFoto, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(iconeCheck8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblInformaesDeEndereo, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 731, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblModelo_2, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtCPFMotorista, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(iconeCheck7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(8)
							.addComponent(btnBuscar))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblModelo_3, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtNomeMotorista, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(228)
							.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(35, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnInserirFoto, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(iconeCheck8, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(8)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPlaca, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(iconeCheck1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(txtDocumento, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDocumento, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(iconeCheck2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtCor, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(iconeCheck3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblCor, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(iconeCheck4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblMarca, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblModelo, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(iconeCheck5, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
									.addComponent(iconeCheck6, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblModelo_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))))
					.addGap(23)
					.addComponent(lblInformaesDeEndereo, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModelo_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtCPFMotorista, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBuscar)
						.addComponent(iconeCheck7, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblModelo_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNomeMotorista, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private boolean verificaPlaca() {
		if(VariaveisProjeto.digitacaoCampo(txtPlaca.getText())) {
			iconeCheck1.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtPlaca.requestFocus();
			return false;
		}
		else {
			iconeCheck1.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtDocumento.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaDocumento() {
		if(VariaveisProjeto.digitacaoCampo(txtDocumento.getText())) {
			iconeCheck2.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtDocumento.requestFocus();
			return false;
		}
		else {
			iconeCheck2.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtCor.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaCor() {
		if(VariaveisProjeto.digitacaoCampo(txtCor.getText())) {
			iconeCheck3.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtCor.requestFocus();
			return false;
		}
		else {
			iconeCheck3.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtMarca.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaMarca() {
		if(VariaveisProjeto.digitacaoCampo(txtMarca.getText())) {
			iconeCheck4.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtMarca.requestFocus();
			return false;
		}
		else {
			iconeCheck4.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtModelo.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaModelo() {
		if(VariaveisProjeto.digitacaoCampo(txtModelo.getText())) {
			iconeCheck5.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtMarca.requestFocus();
			return false;
		}
		else {
			iconeCheck5.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtModelo.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaAno() {
		if(VariaveisProjeto.digitacaoCampo(txtAno.getText())) {
			iconeCheck6.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtAno.requestFocus();
			return false;
		}
		else {
			iconeCheck6.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			txtCPFMotorista.requestFocus();
			return true;
		}
		
	}
	
	private boolean verificaCPFMotorista() {
		if(VariaveisProjeto.digitacaoCampo(txtCPFMotorista.getText())) {
			iconeCheck7.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			txtCPFMotorista.requestFocus();
			return false;
		}
		else {
			iconeCheck7.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			btnSalvar.requestFocus();
			return true;
		}
		
	}
	
	
	
	private boolean verificaFoto() {
		if(fotoInserida) {
			iconeCheck8.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/ok.png")));
			return true;
		}
		else {
			iconeCheck8.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			btnInserirFoto.requestFocus();
			return false;
		}
	}
	
	private boolean verificaDados() {
		if(verificaPlaca() && verificaDocumento() && verificaAno() && verificaCor() && verificaMarca() && verificaModelo() &&
				verificaCPFMotorista() && verificaFoto()) {
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
			//BufferedImage foto = (BufferedImage) lblFoto.getIcon();
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
	

	private void exibirFoto(Veiculo veiculo) {
		
		byte[] foto = null;
		
		BufferedImage img = null;
		
		try {
			img = ImageIO.read(new ByteArrayInputStream(veiculo.getFoto_veiculo()));
			this.byteFoto = veiculo.getFoto_veiculo();
			
			lblFoto.setIcon(new ImageIcon(img));
			fotoInserida = true;
			
		}catch(IOException e) {
			e.printStackTrace();
			fotoInserida = false;
		}
		
	}
	
	protected void buscarMotoristaID(Veiculo veiculo) {
		Motorista motorista = veiculo.getMotorista();
		MotoristaService motoristaService = new MotoristaService();
		
		this.motorista = motoristaService.findById(motorista.getId_motorista());
		
	}
	
	protected void buscarMotorista() {
		
		if(verificaCPFMotorista()) {
			MotoristaService motoristaService = new MotoristaService();
			
			List<Motorista> listaMotorista = motoristaService.findByCpf(Integer.parseInt(txtCPFMotorista.getText()));
			
			
			if(listaMotorista.isEmpty()) {
				motoristaInvalido();
			}
			
			else {
				for(Motorista motorista: listaMotorista) {
						exibirMotorista(motorista);
						this.motorista = motorista;
					}
			}
			
		}
		else {
			txtCPFMotorista.setText("");
		}
	}
	
	private void exibirMotorista(Motorista motorista) {
		txtNomeMotorista.setText(motorista.getNome_motorista());
		txtCPFMotorista.setText(String.valueOf(motorista.getCpf_Motorista()));
	}
	
	private void motoristaInvalido() {
		iconeCheck6.setIcon(new ImageIcon(CadastroCondominio.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
		txtCPFMotorista.requestFocus();
	}
	
	protected void incluirVeiculo() {
		Integer toReturn =0;
		Veiculo veiculo = pegarDadosVeiculo();
		
		if(verificaDados()) {
			VeiculoService veiculoService = new VeiculoService();
			toReturn = veiculoService.save(veiculo);
			JOptionPane.showMessageDialog(null, "Veiculo inserido com sucesso");
			
			tabelaVeiculoModel.fireTableDataChanged();
			veiculo = new Veiculo();
		}
		
		else JOptionPane.showMessageDialog(null, "Erro ao incluir veiculo, verifique os dados e tente novamente");
	}
	
	protected void alterarVeiculo() {
		Integer toReturn =0;
		Veiculo veiculo = pegarDadosVeiculo();
		veiculo.setId_veiculo(id_veiculo);
		
		VeiculoService veiculoService = new VeiculoService();
		
		toReturn = veiculoService.update(veiculo);
		
		if(toReturn == VariaveisProjeto.CAMPO_VAZIO) {
			verificaDados();
			showMensagem("Campo nome deve ser informado");
		}
		if(toReturn == VariaveisProjeto.ERRO_ALTERACAO) {
			showMensagem("Erro na alteração do registro");
		}
		if(toReturn == VariaveisProjeto.ALTERECAO_REALIZADA) {
			showMensagem( "Alteração foi realizada com sucesso");
			
			
			tabelaVeiculoModel.fireTableDataChanged();
			
			veiculo = new Veiculo();
			
		}
	}
	
	protected void excluirVeiculo() {
		
		if(confirmarAcao()) {
			Integer toReturn = 0;
			
			Veiculo veiculo = pegarDadosVeiculo();
			veiculo.setId_veiculo(id_veiculo);
			
			VeiculoService veiculoService = new VeiculoService();
			
			toReturn = veiculoService.delete(veiculo);
			
			if(toReturn == VariaveisProjeto.ERRO_EXCLUSAO) {
				showMensagem("Erro na exclusao do registro");
			}
			if(toReturn == VariaveisProjeto.EXCLUSAO_REALIZADA) {
				showMensagem( "Exclusao realizada com sucesso");
				veiculo = new Veiculo();
				dispose();
			}
		}
		
	}
	
	protected Veiculo pegarDadosVeiculo() {
		Veiculo veiculo = new Veiculo();
		
		if(verificaDados()) {
			
			veiculo.setPlaca(txtPlaca.getText());
			veiculo.setDocumento(txtDocumento.getText());
			veiculo.setAno(txtAno.getText());
			veiculo.setCor(txtCor.getText());
			veiculo.setMarca(txtMarca.getText());
			veiculo.setModelo(txtModelo.getText());
			veiculo.setFoto_veiculo(this.byteFoto);
			
			veiculo.setMotorista(this.motorista);
			
			
		}
		return veiculo;
	}
	
	protected void buscarVeiculo() {
		Veiculo veiculo = new Veiculo();
		
		veiculo = tabelaVeiculoModel.getVeiculo(this.linha);
		
		txtPlaca.setText(veiculo.getPlaca());
		txtDocumento.setText(veiculo.getDocumento());
		txtAno.setText(veiculo.getAno());
		txtMarca.setText(veiculo.getMarca());
		txtModelo.setText(veiculo.getModelo());
		txtCor.setText(veiculo.getCor());
		
		id_veiculo = veiculo.getId_veiculo();
		
		buscarMotoristaID(veiculo);
		exibirFoto(veiculo);
		
		txtCPFMotorista.setText(String.valueOf(motorista.getCpf_Motorista()));
		txtNomeMotorista.setText(motorista.getNome_motorista());
		
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
	
	private void configuraFrame(int acao) {
		if(acao == 1) {
			btnSalvar.setText("SALVAR");
		}
		if(acao == 2) {
			btnSalvar.setText("ALTERAR");
		}
		
		if(acao == 3) {
			btnSalvar.setText("EXCLUIR");
			txtPlaca.setEditable(false);
			txtDocumento.setEditable(false);
			txtAno.setEditable(false);
			txtCor.setEditable(false);
			txtMarca.setEditable(false);
			txtModelo.setEditable(false);
			txtAno.setEditable(false);
			btnInserirFoto.setEnabled(false);
			txtCPFMotorista.setEditable(false);
		}
	}
}
