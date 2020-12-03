package com.projeto.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projeto.model.models.Condominio;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCondominio extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JTextField txtVeiculo;
	
	private Condominio condominio;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCondominio frame = new TelaCondominio();
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
	public TelaCondominio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(175, 238, 238));
		tabbedPane.addTab("Pagina Inicial", new ImageIcon(TelaCondominio.class.getResource("/com/projeto/estrutura/imagens/application_home.png")), panel, null);
		
		JLabel lblNewLabel = new JLabel("SELECIONE A OP\u00C7\u00C3O DESEJADA");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		
		JLabel lblNewLabel_1 = new JLabel("Buscar motorista por CPF:");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 14));
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Buscar ve\u00EDculo pela Placa:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 14));
		
		txtVeiculo = new JTextField();
		txtVeiculo.setColumns(10);
		
		JButton btnUsuario = new JButton("BUSCAR");
		
		JButton btnVeiculo = new JButton("BUSCAR");
		
		JButton btncCadastrarUsuario = new JButton("CADASTRAR NOVO USU\u00C1RIO");
		btncCadastrarUsuario.setIcon(new ImageIcon(TelaCondominio.class.getResource("/com/projeto/estrutura/imagens/application_add.png")));
		btncCadastrarUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnPorteiro = new JButton("CADASTRAR NOVO PORTEIRO");
		btnPorteiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CadastroPorteiro cadastroPorteiro = new CadastroPorteiro();
				cadastroPorteiro.setCondominio(condominio);
				cadastroPorteiro.setVisible(true);
				
			}
		});
		btnPorteiro.setIcon(new ImageIcon(TelaCondominio.class.getResource("/com/projeto/estrutura/imagens/application_add.png")));
		btnPorteiro.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnCadastrarVeculo = new JButton("CADASTRAR NOVO VE\u00CDCULO");
		btnCadastrarVeculo.setIcon(new ImageIcon(TelaCondominio.class.getResource("/com/projeto/estrutura/imagens/application_add.png")));
		btnCadastrarVeculo.setFont(new Font("Arial", Font.PLAIN, 14));
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logout();
			}

			
		});
		btnLogout.setIcon(new ImageIcon(TelaCondominio.class.getResource("/com/projeto/estrutura/imagens/arrow_undo.png")));
		btnLogout.setFont(new Font("Arial", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(23)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtVeiculo, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
								.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 343, GroupLayout.PREFERRED_SIZE)
										.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnUsuario)
								.addComponent(btnVeiculo)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(91)
							.addComponent(btncCadastrarUsuario)
							.addGap(86)
							.addComponent(btnCadastrarVeculo, GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
							.addGap(22)))
					.addGap(59))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(289)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(315, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(242)
					.addComponent(btnPorteiro)
					.addContainerGap(264, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnUsuario)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addGap(30)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtVeiculo, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVeiculo))
					.addGap(68)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btncCadastrarUsuario, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCadastrarVeculo, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(btnPorteiro, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(56)
					.addComponent(btnLogout, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Ve\u00EDculos", new ImageIcon(TelaCondominio.class.getResource("/com/projeto/estrutura/imagens/application_view_gallery.png")), panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Relat\u00F3rio de Entrada", new ImageIcon(TelaCondominio.class.getResource("/com/projeto/estrutura/imagens/book_next.png")), panel_2, null);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Relat\u00F3rio de Sa\u00EDda", new ImageIcon(TelaCondominio.class.getResource("/com/projeto/estrutura/imagens/book_previous.png")), panel_3, null);
	}
	
	private void logout() {
		TelaInicial telaInicial = new TelaInicial();
		telaInicial.setVisible(true);
		dispose();
		
	}
	
	public Condominio getCondominio() {
		return condominio;
	}

	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

}
