package com.projeto.view.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projeto.main.Login;
import com.projeto.model.models.Condominio;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	
	
	public MenuCondominio(Login login) {
		this.login =login;
		
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
		menuArquivo.add(menuPorteiro);
		
		menuMotorista = new JMenuItem("Motorista");
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
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	public Condominio getCondominio() {
		return condominio;
	}
	public void setCondominio(Condominio condominio) {
		this.condominio = condominio;
	}

}
