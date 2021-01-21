package com.projeto.view.motorista;


import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projeto.model.models.Motorista;


import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;

import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;


public class ExibirMotorista extends JInternalFrame {

	
	private static final long serialVersionUID = 4235996973490753627L;
	
	private JPanel contentPane;
	private JLabel lblFoto;
	private JLabel lblNewLabel_2;
	private JTextField txtNome;
	private JLabel lblNewLabel_3;
	private JTextField txtCPF;
	private JLabel lblNewLabel_6;
	private JRadioButton rdbtnFeminino;
	private JRadioButton rdbtnMasculino;
	private JLabel lblNewLabel_8;
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
	
	private Motorista motorista;
	
	
	public ExibirMotorista() {
		
		initComponents();
		
	}
	private void initComponents() {
		setTitle("INFORMA\u00C7\u00D5ES DO MOTORISTA");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		lblFoto = new JLabel("");
		lblFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			
		});
		txtNome.setColumns(10);
		
		lblNewLabel_3 = new JLabel("CPF:");
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 16));
		
		txtCPF = new JTextField();
		txtCPF.addKeyListener(new KeyAdapter() {
		});
		txtCPF.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Telefone:");
		lblNewLabel_6.setFont(new Font("Arial", Font.PLAIN, 16));
		
		rdbtnFeminino = new JRadioButton("Feminino");
		rdbtnFeminino.setFont(new Font("Arial", Font.PLAIN, 14));
		
		rdbtnMasculino = new JRadioButton("Masculino");
		rdbtnMasculino.setFont(new Font("Arial", Font.PLAIN, 14));
		
		lblNewLabel_8 = new JLabel("Email:");
		lblNewLabel_8.setFont(new Font("Arial", Font.PLAIN, 16));
		
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
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtComplemento))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(rdbtnFeminino, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
									.addGap(10)
									.addComponent(rdbtnMasculino)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
									.addGap(134)
									.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtNumeroBloco))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtBlocoResidencial))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE))))))
							.addGap(161)
							.addComponent(iconeCheck9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addGap(67)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(367)
									.addComponent(iconeCheck5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(365)
									.addComponent(iconeCheck4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(2)
									.addComponent(iconeCheck7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(iconeCheck3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(iconeCheck2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(iconeCheck1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
										.addComponent(iconeCheck6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(244)
							.addComponent(txtNumeroResidencial, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 855, Short.MAX_VALUE)
							.addComponent(iconeCheck8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(31)
									.addComponent(iconeCheck1)
									.addGap(45)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(iconeCheck2, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
											.addGap(30)
											.addComponent(iconeCheck3, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(83)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(txtBlocoResidencial, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_10, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
												.addComponent(iconeCheck4, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtCPF, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtTelefone, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_8, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(19)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(iconeCheck5, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(27)
											.addComponent(iconeCheck9, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_11, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtNumeroResidencial, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblNewLabel_12, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtNumeroBloco, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
							.addGap(9)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(28)
									.addComponent(iconeCheck6, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(26)
									.addComponent(iconeCheck7, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblFoto, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(rdbtnFeminino)
								.addComponent(rdbtnMasculino))
							.addGap(33)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_13, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtComplemento, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))))
					.addGap(76)
					.addComponent(iconeCheck8, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
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
	
	public void buscarMotorista() {
		Motorista motorista = new Motorista();
		
		txtNome.setText(this.motorista.getNome_motorista());
		txtCPF.setText(String.valueOf(this.motorista.getCpf_Motorista()));
		txtBlocoResidencial.setText(this.motorista.getBloco_residencial());
		txtNumeroResidencial.setText(this.motorista.getNumero_residencia());
		txtNumeroBloco.setText(this.motorista.getN_bloco());
		txtComplemento.setText(this.motorista.getComplemento());
		txtTelefone.setText(this.motorista.getTelefone_motorista());
		txtEmail.setText(this.motorista.getEmail_motorista());
		
		if(this.motorista.getSexo_motorista().equals("feminino")) {
			rdbtnFeminino.setSelected(true);
		}
		else rdbtnMasculino.setSelected(true);
		
		exibirFoto(this.motorista);
		
	}
	
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

}
