package com.projeto.model.service;

import java.io.InputStream;

import javax.swing.JFrame;

import com.projeto.estrutura.util.VariaveisProjeto;
import com.projeto.model.models.PrintJasperReport;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.swing.JRViewer;

public class JasperReportsService extends JFrame {

	private static final long serialVersionUID = -3983317412847903600L;
	
	public JasperReportsService() {
		
	}
	
	public void generateListReports(PrintJasperReport printJasperReport) {
		
		try {
		InputStream fileIn = getClass().getClassLoader().getResourceAsStream(
				VariaveisProjeto.DIRETORIO_RELATORIO+ printJasperReport.getFile()+ VariaveisProjeto.SUFIXO_RELATORIO_COMPILADO);
	
	
		JasperPrint jasperPrint = JasperFillManager.fillReport(fileIn,
															printJasperReport.getParams(), 
															new  JRBeanCollectionDataSource(printJasperReport.getCollection()));
		
		viewReport(jasperPrint);
		
		} catch(JRException e) {
			e.printStackTrace();
		}
	}


	private void viewReport(JasperPrint jasperPrint) {
		
		JRViewer viewer = new JRViewer(jasperPrint);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setTitle("Visualização de Relatórios");
		getContentPane().add(viewer);
		setVisible(true);
	}

}
