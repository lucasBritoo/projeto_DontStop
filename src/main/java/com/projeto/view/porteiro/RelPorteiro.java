package com.projeto.view.porteiro;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.projeto.model.models.Porteiro;
import com.projeto.model.models.PrintJasperReport;
import com.projeto.model.service.JasperReportsService;
import com.projeto.model.service.PorteiroService;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class RelPorteiro extends JDialog {


	private static final long serialVersionUID = 6420229797181191581L;
	
	private final JPanel contentPanel = new JPanel();

	
	public RelPorteiro(JFrame frame, boolean modal) {
		super(frame, modal);
		
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						PorteiroService porteiroService = new PorteiroService();
						PrintJasperReport printJasperReport = new PrintJasperReport();
						JasperReportsService jasperReportsService = new JasperReportsService();
						
						List<Porteiro> listaPorteiro = porteiroService.findAll();
						
						printJasperReport.setFile("rel_porteiro");
						printJasperReport.setCollection(listaPorteiro);
						
						setVisible(false);
						jasperReportsService.generateListReports(printJasperReport);
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
