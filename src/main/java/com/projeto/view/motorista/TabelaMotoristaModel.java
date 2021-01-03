package com.projeto.view.motorista;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.projeto.model.models.Motorista;

public class TabelaMotoristaModel extends AbstractTableModel {

	private static final long serialVersionUID = -6125297727940900499L;
	
	private static final int id_motorista= 0;
	private static final int nome_Motorista = 1;
	private static final int cpf_Motorista= 2;
	private static final int rg_Motorista= 3 ;
	private static final int telefone= 4;
	private static final int email= 5;
	
	
	private final String colunas[] = {"ID", "NOME","CPF" , "RG", "TELEFONE", "EMAIL"};
	
	private List<Motorista> listaMotorista;
	
	public List<Motorista> getListaMotorista() {
		return listaMotorista;
	}

	public void setListaMotorista(List<Motorista> listaMotorista) {
		this.listaMotorista = listaMotorista;
	}
	
	public Motorista getMotorista(int rowIndex) {
		return getListaMotorista().get(rowIndex);
	}
	
	public void saveMotorista(Motorista motorista) {
		getListaMotorista().add(motorista);
		fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
		
	}
	
	public void updateMotorista(Motorista motorista, int rowIndex) {
		getListaMotorista().set(rowIndex, motorista);
		fireTableRowsInserted(rowIndex, rowIndex);
		
	}
	
	public void removeMotorista(int rowIndex) {
		getListaMotorista().remove(rowIndex);
		fireTableRowsInserted(rowIndex, rowIndex);
	}
	
	public void removeAll() {
		getListaMotorista().clear();
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return getListaMotorista().size();
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
		Motorista motorista = getListaMotorista().get(rowIndex);
		
		switch(columnIndex) {
		
			case id_motorista:
				return motorista.getId_motorista();
				
			case nome_Motorista:
				return motorista.getNome_motorista();
				
			case cpf_Motorista:
				return motorista.getCpf_Motorista();
				
			
			case rg_Motorista:
				return motorista.getRg_Motorista();
				
			case telefone:
				return motorista.getTelefone_motorista();
				
			case email:
				return motorista.getEmail_motorista();
				
			default:
					return motorista;
		}
		
	}
	
	public Class<?> getColumnClass(int columnIndex){
		
		switch(columnIndex) {
			
			case id_motorista:
				return Integer.class;
				
			case nome_Motorista:
				return String.class;
				
			case cpf_Motorista:
				return Integer.class;
				
			case rg_Motorista:
				return String.class;
				
			case telefone:
				return String.class;
				
			case email:
				return String.class;
					
			default:
				return null;
		}
	}
		
	public String[] getColunas() {
		return colunas;
	}

}
