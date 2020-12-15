package com.projeto.view.porteiro;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.projeto.model.models.Porteiro;

public class TabelaPorteiroModel extends AbstractTableModel {

	private static final long serialVersionUID = -6125297727940900499L;
	
	private static final int id_porteiro= 0;
	private static final int nome_Porteiro = 1;
	private static final int cpf_Porteiro= 2;
	private static final int rg_Porteiro= 3 ;
	private static final int email= 4;
	private static final int telefone= 5;
	
	private final String colunas[] = {"ID", "NOME","CPF" , "RG", "EMAIL" ,"TELEFONE"};
	
	private List<Porteiro> listaPorteiro;
	
	public List<Porteiro> getListaPorteiro() {
		return listaPorteiro;
	}

	public void setListaPorteiro(List<Porteiro> listaPorteiro) {
		this.listaPorteiro = listaPorteiro;
	}
	
	public Porteiro getPorteiro(int rowIndex) {
		return getListaPorteiro().get(rowIndex);
	}
	
	public void savePorteiro(Porteiro porteiro) {
		getListaPorteiro().add(porteiro);
		fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
		
	}
	
	public void updatePorteiro(Porteiro porteiro, int rowIndex) {
		getListaPorteiro().set(rowIndex, porteiro);
		fireTableRowsInserted(rowIndex, rowIndex);
		
	}
	
	public void removePorteiro(int rowIndex) {
		getListaPorteiro().remove(rowIndex);
		fireTableRowsInserted(rowIndex, rowIndex);
	}
	
	public void removeAll() {
		getListaPorteiro().clear();
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return getListaPorteiro().size();
	}

	@Override
	public int getColumnCount() {
		return getColunas().length;
	}
	
	public String getColluName(int columnIndex) {
		return colunas[columnIndex];
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Porteiro porteiro = getListaPorteiro().get(rowIndex);
		
		switch(columnIndex) {
		
			case id_porteiro:
				return porteiro.getId_porteiro();
				
			case nome_Porteiro:
				return porteiro.getNome_Porteiro();
				
			case cpf_Porteiro:
				return porteiro.getCpf_Porteiro();
				
			
			case rg_Porteiro:
				return porteiro.getRg_Porteiro();
				
			case email:
				return porteiro.getEmail();
				
			case telefone:
				return porteiro.getTelefone();
					
			default:
					return porteiro;
		}
	
	}
	
	public Class<?> getColumnClass(int columnIndex){
		
		switch(columnIndex) {
		
			case id_porteiro:
				return Integer.class;
				
			case nome_Porteiro:
				return String.class;
				
			case cpf_Porteiro:
				return Integer.class;
				
			
			case rg_Porteiro:
				return String.class;
				
			case email:
				return String.class;
				
			case telefone:
				return String.class;
					
			default:
				return null;
		}
	}
		
	public String[] getColunas() {
		return colunas;
	}

}
