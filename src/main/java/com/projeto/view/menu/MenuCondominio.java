package com.projeto.view.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import com.projeto.main.Login;
import com.projeto.model.models.Condominio;
import com.projeto.model.models.Motorista;
import com.projeto.model.models.Porteiro;
import com.projeto.model.models.Veiculo;
import com.projeto.model.service.VeiculoService;
import com.projeto.view.condominio.CadastroCondominio;
import com.projeto.view.motorista.ExibirMotorista;
import com.projeto.view.motorista.TabelaMotorista;
import com.projeto.view.porteiro.TabelaPorteiro;
import com.projeto.view.trocaSenha.EsqueceuSenhaLogado;
import com.projeto.view.veiculo.CadastroVeiculo;
import com.projeto.view.veiculo.ExibirVeiculo;
import com.projeto.view.veiculo.TabelaVeiculo;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.CardLayout;
import javax.swing.JLayeredPane;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;

public class MenuCondominio extends JFrame {

	private static final long serialVersionUID = 5660163520018698714L;
	private JLayeredPane contentPane;
	private JMenuBar menuBar;
	private JMenu menuArquivo;
	private JMenuItem menuCondominio;
	private JMenuItem menuLogout;
	private JMenuItem menuPorteiro;
	private JMenu menuSair;
	private JMenuItem menuSairSistema;
	private JMenuItem menuMotorista;
	private JMenuItem menuVeiculo;
	private JMenu menuHistorico;
	private JMenuItem menuHistoricoAcesso;
	private JMenuItem menuHistoricoSaida;
	private JMenuItem menuHistoricoCompleto;
	
	private Condominio condominio;
	private Motorista motorista;
	private ExibirVeiculo telaVeiculo = new ExibirVeiculo();
	private ExibirMotorista telaMotorista = new ExibirMotorista();
	
	//private Porteiro porteiro;
	
	
	private Login login;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JLabel lblInformaesDeCadastros;
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JPanel panel;
	private JLabel lblNewLabel_3;
	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuCondominio frame = new MenuCondominio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	
	
	public MenuCondominio(Login login, Condominio condominio) {
		setBackground(new Color(175, 238, 238));
		this.login =login;
		this.condominio = condominio;
		initComponents();
		chamarTela();
		//iniciarTabelas();
		
	}
	
	private void initComponents() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuArquivo = new JMenu("Arquivo");
		menuBar.add(menuArquivo);
		
		menuCondominio = new JMenuItem("Condominio");
		menuArquivo.add(menuCondominio);
		
		menuPorteiro = new JMenuItem("Porteiro");
		menuPorteiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaPorteiro();
				
				
			}
		});
		menuArquivo.add(menuPorteiro);
		
		menuMotorista = new JMenuItem("Motorista");
		menuMotorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaMotorista();
			}
		});
		menuArquivo.add(menuMotorista);
		
		menuVeiculo = new JMenuItem("Ve\u00EDculo");
		menuVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaVeiculo();
			}
		});
		menuArquivo.add(menuVeiculo);
		
		menuLogout = new JMenuItem("Logout");
		menuLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				login.setVisible(true);
			}
		});
		menuArquivo.add(menuLogout);
		
		menuHistorico = new JMenu("Historico");
		menuBar.add(menuHistorico);
		
		menuHistoricoCompleto = new JMenuItem("Hist\u00F3rico Completo");
		menuHistoricoCompleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarHistorico();
			}
		});
		menuHistorico.add(menuHistoricoCompleto);
		
		menuHistoricoAcesso = new JMenuItem("Hist\u00F3rico de Acesso");
		menuHistorico.add(menuHistoricoAcesso);
		
		menuHistoricoSaida = new JMenuItem("Hist\u00F3rico de Entrada");
		menuHistorico.add(menuHistoricoSaida);
		
		menuSair = new JMenu("Sair");
		menuBar.add(menuSair);
		
		menuSairSistema = new JMenuItem("Sair");
		menuSair.add(menuSairSistema);
		contentPane = new JLayeredPane();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(10, 5, 10, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 250, 240));
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Login.class.getResource("/com/projeto/estrutura/imagens/logoCarro.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 533, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 398, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(233, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 223, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		lblInformaesDeCadastros = new JLabel("INFORMA\u00C7\u00D5ES DE CADASTROS");
		lblInformaesDeCadastros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				chamarMotorista();
			}
		});
		lblInformaesDeCadastros.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblNewLabel_2 = new JLabel("________________________________________________________________________________________");
		lblNewLabel_2.setForeground(Color.BLACK);
		
		btnNewButton_2 = new JButton("MOTORISTA");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaMotorista();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(MenuCondominio.class.getResource("/com/projeto/estrutura/imagens/application_form_add.png")));
		
		btnNewButton_3 = new JButton("VE\u00CDCULO");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaVeiculo();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(MenuCondominio.class.getResource("/com/projeto/estrutura/imagens/application_form_add.png")));
		
		btnNewButton_4 = new JButton("PORTEIRO");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabelaPorteiro();
			}
		});
		btnNewButton_4.setIcon(new ImageIcon(MenuCondominio.class.getResource("/com/projeto/estrutura/imagens/application_form_add.png")));
		
		lblNewLabel = new JLabel("INFORMA\u00C7\u00D5ES DO CONDOM\u00CDNIO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		lblNewLabel_1 = new JLabel("________________________________________________________________________________________");
		lblNewLabel_1.setForeground(Color.BLACK);
		
		btnNewButton = new JButton("EDITAR CADASTRO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarCadastro();
			}
		});
		btnNewButton.setIcon(new ImageIcon(MenuCondominio.class.getResource("/com/projeto/estrutura/imagens/application_edit.png")));
		
		btnNewButton_1 = new JButton("ALTERAR SENHA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EsqueceuSenhaLogado esqueceuSenhaLogado = new EsqueceuSenhaLogado();
				esqueceuSenhaLogado.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(MenuCondominio.class.getResource("/com/projeto/estrutura/imagens/application_form_edit.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblInformaesDeCadastros, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_1)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(11)
									.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_3, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(40)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 523, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(21)
					.addComponent(lblInformaesDeCadastros)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_2)
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_3)
						.addComponent(btnNewButton_4))
					.addGap(94)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel_1)
					.addGap(36)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void tabelaPorteiro() {
		
		TabelaPorteiro tabelaPorteiro = new TabelaPorteiro(condominio, 1);
		centralizaForm(tabelaPorteiro);
		contentPane.add(tabelaPorteiro);
		tabelaPorteiro.setResizable(false);
		
		tabelaPorteiro.setVisible(true);
	}

	private void tabelaMotorista() {
		
		TabelaMotorista tabelaMotorista = new TabelaMotorista(condominio,1);
		centralizaForm(tabelaMotorista);
		contentPane.add(tabelaMotorista);
		tabelaMotorista.setResizable(false);
		
		tabelaMotorista.setVisible(true);
		
	}
	
	private void tabelaVeiculo() {
		
		TabelaVeiculo tabelaVeiculo = new TabelaVeiculo(1);
		centralizaForm(tabelaVeiculo);
		contentPane.add(tabelaVeiculo);
		tabelaVeiculo.setResizable(false);
		tabelaVeiculo.setVisible(true);
		
	}
	
	private void centralizaForm(JInternalFrame frame) {
		Dimension desktopSize = this.getSize();
		Dimension internalFrameSize = frame.getSize();
		frame.setLocation((desktopSize.width - internalFrameSize.width) / 2, (desktopSize.height - internalFrameSize.height)/2);
	}
	
	private void iniciarTabelas() {
		tabelaMotorista();
		tabelaVeiculo();
		tabelaPorteiro();
	}
	
	private void chamarTela() {
		
		Dimension tamanhoTela = this.getSize();
		
		
		
		telaVeiculo.setLocation((tamanhoTela.width ), (tamanhoTela.height - (tamanhoTela.height - 30)));
		contentPane.add(telaVeiculo);
		telaVeiculo.setVisible(true);
		
		telaVeiculo.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
				telaVeiculo.setLocation((tamanhoTela.width ), (tamanhoTela.height - (tamanhoTela.height - 30)));
			}
		});
	
	
		telaMotorista.setLocation((tamanhoTela.width ), (tamanhoTela.height - 200));
		contentPane.add(telaMotorista);
		telaMotorista.setVisible(true);
		
		telaMotorista.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
				telaMotorista.setLocation((tamanhoTela.width ), (tamanhoTela.height - 200));
			}
		});
	}
	
	private void chamarMotorista() {
		VeiculoService veiculoService = new VeiculoService();
		Veiculo veiculo = new Veiculo();
		Motorista motorista = new Motorista();
		
		veiculo = veiculoService.findById(3);
		telaVeiculo.setVeiculo(veiculo);
		telaVeiculo.buscarVeiculo();
		
		motorista = veiculo.getMotorista();
		telaMotorista.setMotorista(motorista);
		telaMotorista.buscarMotorista();
		
		
		
	}
	
	private void editarCadastro() {
		CadastroCondominio cadastroCondominio = new CadastroCondominio(login, 2);
		cadastroCondominio.exibirCondominio(condominio);
		cadastroCondominio.setVisible(true);
		
	}
	
	protected void iniciarHistorico() {
		Relatorios relatorios = new Relatorios();
		relatorios.setVisible(true);
	}
}
