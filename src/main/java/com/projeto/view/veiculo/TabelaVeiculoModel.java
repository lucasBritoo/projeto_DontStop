package com.projeto.view.veiculo;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.projeto.model.models.Motorista;
import com.projeto.model.models.Veiculo;
import com.projeto.model.service.MotoristaService;

public class TabelaVeiculoModel extends AbstractTableModel {

	private static final long serialVersionUID = -6125297727940900499L;
	
	private static final int id_veiculo= 0;
	private static final int placa = 1;
	private static final int marca= 2;
	private static final int modelo= 3 ;
	private static final int nome_motorista= 4;
	
	
	private final String colunas[] = {"ID", "PLACA","MARCA" , "MODELO", "NOME DO MOTORISTA"};
	
	private List<Veiculo> listaVeiculo;
	
	public List<Veiculo> getListaVeiculo() {
		return listaVeiculo;
	}

	public void setListaVeiculo(List<Veiculo> listaVeiculo) {
		this.listaVeiculo = listaVeiculo;
	}
	
	public Veiculo getVeiculo(int rowIndex) {
		return getListaVeiculo().get(rowIndex);
	}
	
	public void saveVeiculo(Veiculo veiculo) {
		getListaVeiculo().add(veiculo);
		fireTableRowsInserted(getRowCount()-1, getColumnCount()-1);
		
	}
	
	public void updateVeiculo(Veiculo veiculo, int rowIndex) {
		getListaVeiculo().set(rowIndex, veiculo);
		fireTableRowsInserted(rowIndex, rowIndex);
		
	}
	
	public void removeVeiculo(int rowIndex) {
		getListaVeiculo().remove(rowIndex);
		fireTableRowsInserted(rowIndex, rowIndex);
	}
	
	public void removeAll() {
		getListaVeiculo().clear();
		fireTableDataChanged();
	}

	@Override
	public int getRowCount() {
		return getListaVeiculo().size();
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
		Veiculo veiculo = getListaVeiculo().get(rowIndex);
		Motorista motorista = veiculo.getMotorista();
		
		switch(columnIndex) {
		
			case id_veiculo:
				return veiculo.getId_veiculo();
				
			case placa:
				return veiculo.getPlaca();
				
			case marca:
				return veiculo.getMarca();
				
			
			case modelo:
				return veiculo.getModelo();
				
			case nome_motorista:
				return motorista.getNome_motorista();
				
				
			default:
					return veiculo;
		}
		
	}
	
	public Class<?> getColumnClass(int columnIndex){
		
		switch(columnIndex) {
			
			case id_veiculo:
				return Integer.class;
				
			case placa:
				return String.class;
				
			case marca:
				return String.class;
				
			case modelo:
				return String.class;
				
			case nome_motorista:
				return String.class;
					
			default:
				return null;
		}
	}
		
	public String[] getColunas() {
		return colunas;
	}
	
}
