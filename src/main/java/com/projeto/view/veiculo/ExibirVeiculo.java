package com.projeto.view.veiculo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
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
import java.awt.SystemColor;

public class ExibirVeiculo extends JInternalFrame {

	
	private static final long serialVersionUID = -3228887371797173245L;
	
	private JPanel contentPane;
	private JLabel lblFoto;
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
	private JLabel iconeCheck7;

	
	
	private JFileChooser fileChooser;
	private boolean fotoInserida =false;
	private byte[] byteFoto;
	private String extensaoFoto;
	
	private String cpf_motorista;
	
	private Motorista motorista;
	private Veiculo veiculo;
	

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
	
	public ExibirVeiculo() {
	
		initComponents();
		
	
	}
	private void initComponents() {
		setTitle("INFORMA\u00C7\u00D5ES DO VE\u00CDCULO");
		setBounds(100, 100, 650, 350);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblFoto = new JLabel("");
		lblFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
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
		
		iconeCheck7 = new JLabel("");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(440)
							.addComponent(iconeCheck7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblModelo_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblModelo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblMarca, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblCor, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtCor, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblPlaca, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(lblDocumento)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(txtDocumento, 273, 273, 273)))))
					.addContainerGap(175, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(29)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblDocumento, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtDocumento, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
									.addGap(12)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblCor, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCor, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(18)
											.addComponent(lblMarca, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtMarca, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
											.addGap(18)))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblModelo, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtModelo, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPlaca, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblModelo_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtAno, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addGap(184)
					.addComponent(iconeCheck7, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
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
	

	protected Veiculo pegarDadosVeiculo() {
		Veiculo veiculo = new Veiculo();
	
		veiculo.setPlaca(txtPlaca.getText());
		veiculo.setDocumento(txtDocumento.getText());
		veiculo.setAno(txtAno.getText());
		veiculo.setCor(txtCor.getText());
		veiculo.setMarca(txtMarca.getText());
		veiculo.setModelo(txtModelo.getText());
		veiculo.setFoto_veiculo(this.byteFoto);
			
		veiculo.setMotorista(this.motorista);
		
		return veiculo;
	}
	
	public void buscarVeiculo() {
		
		txtPlaca.setText(this.veiculo.getPlaca());
		txtDocumento.setText(this.veiculo.getDocumento());
		txtAno.setText(this.veiculo.getAno());
		txtMarca.setText(this.veiculo.getMarca());
		txtModelo.setText(this.veiculo.getModelo());
		txtCor.setText(this.veiculo.getCor());
		
		exibirFoto(this.veiculo);
		
	}
	
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
}
