package com.projeto.model.service;

import java.util.List;
import javax.persistence.EntityTransaction;
import com.projeto.estrutura.util.VariaveisProjeto;
import com.projeto.model.dao.PorteiroDao;
import com.projeto.model.models.Porteiro;

public class PorteiroService extends ConexaoBancoService{
	
	private PorteiroDao porteiroDao;
	
	
	public PorteiroService() {
		this.porteiroDao = new PorteiroDao(this.getEntityManager());
	}
	
	public Integer save(Porteiro porteiro) {
		
		Integer toReturn =0;
		
		EntityTransaction trx = this.getTransaction();
		
		
		toReturn = validarDigitacao(porteiro);
		if(toReturn == VariaveisProjeto.DIGITACAO_OK) {
			try {
				trx.begin();
				this.getPorteiroDao().save(porteiro);
				trx.commit();
				toReturn = VariaveisProjeto.INCLUSAO_REALIZADA;
				
			}catch(Exception ex){
				ex.printStackTrace();
				if(trx.isActive()) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_INCLUSAO;
			}finally {
				this.close();
			}
		}
		return toReturn;
	}
	
	public Integer update(Porteiro porteiro) {
		Integer toReturn =0 ;
		EntityTransaction trx = this.getTransaction();
		
		toReturn = validarDigitacao(porteiro);
		if(toReturn == VariaveisProjeto.DIGITACAO_OK) {
			
			try {
				trx.begin();
				this.getPorteiroDao().update(porteiro);
				trx.commit();
				toReturn = VariaveisProjeto.ALTERECAO_REALIZADA;
			}catch(Exception ex) {
				ex.printStackTrace();
				if(trx.isActive()) {
					trx.rollback();
				}
				toReturn = VariaveisProjeto.ERRO_ALTERACAO;
			}finally {
				this.close();
			}
		}
		return toReturn;
	}
	
	public Integer delete(Porteiro porteiro) {
		Integer toReturn = 0;
		
		EntityTransaction trx = this.getTransaction();
		
		try {
			trx.begin();
			Porteiro porteiroEncontrado = this.getPorteiroDao().findById(porteiro.getId_porteiro());
			this.getPorteiroDao().remove(porteiroEncontrado);
			trx.commit();
			toReturn = VariaveisProjeto.EXCLUSAO_REALIZADA;
			
		}catch(Exception ex){
			ex.printStackTrace();
			if(trx.isActive()) {
				trx.rollback();
			}
			toReturn = VariaveisProjeto.ERRO_EXCLUSAO;
		}finally {
			this.close();
		}
		
		return toReturn;
	}
	
	public Porteiro findById(Integer id) {
		return this.getPorteiroDao().findById(id);
		
	}
	
	public List<Porteiro> findByEmail(String email) {
		return this.getPorteiroDao().findEmail(Porteiro.class, email);
	}
	

	public List<Porteiro> findAll(){
		return this.getPorteiroDao().findAll(Porteiro.class);
	}
	
	public Integer validarDigitacao(Porteiro porteiro) {
		if(VariaveisProjeto.digitacaoCampo(porteiro.getNome_Porteiro())) {
			System.out.println("EAE PARÇA");
			return VariaveisProjeto.CAMPO_VAZIO;
		}
		else {
			return VariaveisProjeto.DIGITACAO_OK;
		}
	}
	
	public PorteiroDao getPorteiroDao() {
		return porteiroDao;
	}
	
	public Integer countTotalRegister() {
		return porteiroDao.countTotalRegister(Porteiro.class);
	}
		
	public List<Porteiro> listPorteiroPaginacao(Integer numeroPagina, Integer defaultPagina) {
		return porteiroDao.listUsuarioPaginacao(numeroPagina, defaultPagina);
	}

}
