package com.projeto.view.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projeto.main.Login;
import com.projeto.model.models.Condominio;
import com.projeto.model.models.Porteiro;
import com.projeto.view.motorista.TabelaMotorista;
import com.projeto.view.porteiro.TabelaPorteiro;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class MenuCondominio extends JFrame {

	private static final long serialVersionUID = 5660163520018698714L;
	private JPanel contentPane;
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
	//private Porteiro porteiro;
	
	
	private Login login;
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
		this.login =login;
		this.condominio = condominio;
		initComponents();
		
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
		menuHistorico.add(menuHistoricoCompleto);
		
		menuHistoricoAcesso = new JMenuItem("Hist\u00F3rico de Acesso");
		menuHistorico.add(menuHistoricoAcesso);
		
		menuHistoricoSaida = new JMenuItem("Hist\u00F3rico de Entrada");
		menuHistorico.add(menuHistoricoSaida);
		
		menuSair = new JMenu("Sair");
		menuBar.add(menuSair);
		
		menuSairSistema = new JMenuItem("Sair");
		menuSair.add(menuSairSistema);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 776, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 531, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void tabelaPorteiro() {
		TabelaPorteiro tabelaPorteiro = new TabelaPorteiro(condominio);
		centralizaForm(tabelaPorteiro);
		contentPane.add(tabelaPorteiro);
		tabelaPorteiro.setSize(800,600);
		tabelaPorteiro.setResizable(false);
		
		tabelaPorteiro.setVisible(true);
	}

	private void tabelaMotorista() {
		TabelaMotorista tabelaMotorista = new TabelaMotorista(condominio);
		centralizaForm(tabelaMotorista);
		contentPane.add(tabelaMotorista);
		tabelaMotorista.setSize(800,600);
		tabelaMotorista.setResizable(false);
		
		tabelaMotorista.setVisible(true);
		
	}
	
	private void centralizaForm(JInternalFrame frame) {
		Dimension desktopSize = this.getSize();
		Dimension internalFrameSize = frame.getSize();
		frame.setLocation((desktopSize.width - internalFrameSize.width) / 2, (desktopSize.height - internalFrameSize.height)/2);
	}
}
