package com.projeto.view.menu;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projeto.model.models.Motorista;
import com.projeto.model.models.Porteiro;
import com.projeto.model.models.PrintJasperReport;
import com.projeto.model.models.Veiculo;
import com.projeto.model.service.JasperReportsService;
import com.projeto.model.service.MotoristaService;
import com.projeto.model.service.PorteiroService;
import com.projeto.model.service.VeiculoService;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Relatorios extends JDialog {

	private static final long serialVersionUID = 6420229797181191581L;

	private final JPanel contentPanel = new JPanel();
	private JLabel lblInicio;
	private JTextField txtInicio;
	private JLabel lblFinal;
	private JTextField txtFinal;
	private JButton btnPorteiro;
	private JButton btnMotorista;
	private JButton btnVeiculo;
	private JButton cancelButton;

	public Relatorios() {
		//super(frame, modal);
		initComponents();
	}
	private void initComponents() {
		setBackground(new Color(175, 238, 238));
		
				setBounds(100, 100, 490, 353);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(175, 238, 238));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		lblInicio = new JLabel("IN\u00CDCIO:");
		
		txtInicio = new JTextField();
		txtInicio.setColumns(10);
		
		lblFinal = new JLabel("FINAL:");
		
		txtFinal = new JTextField();
		txtFinal.setColumns(10);
		
		btnPorteiro = new JButton("PORTEIRO");
		btnPorteiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioPorteiro();
			}
		});
		btnPorteiro.setIcon(new ImageIcon(Relatorios.class.getResource("/com/projeto/estrutura/imagens/book.png")));
		
		btnMotorista = new JButton("MOTORISTA");
		btnMotorista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioMotorista();
			}
		});
		btnMotorista.setIcon(new ImageIcon(Relatorios.class.getResource("/com/projeto/estrutura/imagens/book.png")));
		
		btnVeiculo = new JButton("VEICULO");
		btnVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				relatorioVeiculo();
			}
		});
		btnVeiculo.setIcon(new ImageIcon(Relatorios.class.getResource("/com/projeto/estrutura/imagens/book.png")));
		{
			cancelButton = new JButton("CANCELAR");
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelButton.setIcon(new ImageIcon(Relatorios.class.getResource("/com/projeto/estrutura/imagens/iconFechar.png")));
			cancelButton.setActionCommand("Cancel");
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblInicio, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblFinal, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(btnPorteiro)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnMotorista)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(cancelButton)
						.addComponent(txtFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVeiculo))
					.addContainerGap(168, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInicio)
						.addComponent(txtInicio, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFinal)
						.addComponent(txtFinal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPorteiro)
						.addComponent(btnVeiculo)
						.addComponent(btnMotorista))
					.addGap(68)
					.addComponent(cancelButton)
					.addContainerGap(73, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}
	
	private void relatorioMotorista() {
		MotoristaService motoristaService = new MotoristaService();
		PrintJasperReport printJasperReport = new PrintJasperReport();
		JasperReportsService jasperReportsService = new JasperReportsService();

		List<Motorista> listaMotorista = motoristaService.findAll();

		printJasperReport.setFile("rel_motorista");
		printJasperReport.setCollection(listaMotorista);

		setVisible(false);
		jasperReportsService.generateListReports(printJasperReport);
	}
	
	private void relatorioPorteiro() {
		PorteiroService porteiroService = new PorteiroService();
		PrintJasperReport printJasperReport = new PrintJasperReport();
		JasperReportsService jasperReportsService = new JasperReportsService();
		
		List<Porteiro> listaPorteiro = porteiroService.findAll();
		
		printJasperReport.setFile("rel_porteiro");
		printJasperReport.setCollection(listaPorteiro);
		
		setVisible(false);
		jasperReportsService.generateListReports(printJasperReport);
	}
	
	private void relatorioVeiculo() {
		VeiculoService veiculoService = new VeiculoService();
		PrintJasperReport printJasperReport = new PrintJasperReport();
		JasperReportsService jasperReportsService = new JasperReportsService();
		
		List<Veiculo> listaVeiculo = veiculoService.findAll();
		
		printJasperReport.setFile("rel_veiculo");
		printJasperReport.setCollection(listaVeiculo);
		
		setVisible(false);
		jasperReportsService.generateListReports(printJasperReport);
		
	}
}
